package com.jmc.commons.web.exception;

import com.jmc.commons.utils.test.AbstractUnitTest;
import jakarta.validation.constraints.NotNull;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.validation.BindException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.async.AsyncRequestTimeoutException;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;

/**
 * @author Jeremy MARTIN CATANI
 * created on 29/10/2021
 */
public class ExceptionControllerTest extends AbstractUnitTest {

	private final ResponseEntityExceptionHandler exceptionHandlerSupport = new ExceptionController();
	private final MockHttpServletRequest servletRequest = new MockHttpServletRequest("GET", "/");
	private final MockHttpServletResponse servletResponse = new MockHttpServletResponse();
	private final WebRequest request = new ServletWebRequest(this.servletRequest, this.servletResponse);

	private void testException(@NotNull final Exception exception, final int expectedStatus) {
		try {
			ResponseEntity<Object> responseEntity = this.exceptionHandlerSupport.handleException(exception, this.request);
			if (Objects.nonNull(responseEntity)) {
				assertEquals(expectedStatus, responseEntity.getStatusCodeValue(), "Status must be equal");
			}
		} catch (Exception ex) {
			assertNull(ex, "Exception must be null");
		}
	}

	@SuppressWarnings("unused")
	public void handle(String arg) {
		// do not remove because it's use by test missingPathVariable
	}

	@Test
	@Order(value = 1)
	public void httpRequestMethodNotSupported() {
		this.testException(new HttpRequestMethodNotSupportedException("GET", "POST"), 405);
	}

	@Test
	@Order(value = 2)
	public void httpMediaTypeNotSupported() {
		List<MediaType> acceptable = List.of(MediaType.APPLICATION_JSON);
		Exception exception = new HttpMediaTypeNotSupportedException(MediaType.APPLICATION_PDF, acceptable);
		this.testException(exception, 415);
	}

	@Test
	@Order(value = 3)
	public void httpMediaTypeNotAcceptable() {
		this.testException(new HttpMediaTypeNotAcceptableException(""), 406);
	}

	@Test
	@Order(value = 4)
	public void missingPathVariable() {
		try {
			Method method = getClass().getMethod("handle", String.class);
			MethodParameter parameter = new MethodParameter(method, 0);
			this.testException(new MissingPathVariableException("param", parameter), 500);
		} catch (Exception ex) {
			assertNull(ex, "Exception must be null");
		}
	}

	@Test
	@Order(value = 5)
	public void missingServletRequestParameter() {
		this.testException(new MissingServletRequestParameterException("param", "type"), 400);
	}

	@Test
	@Order(value = 6)
	public void servletRequestBindingException() {
		this.testException(new ServletRequestBindingException("message"), 400);
	}

	@Test
	@Order(value = 7)
	public void conversionNotSupported() {
		this.testException(new ConversionNotSupportedException(new Object(), Object.class, null), 500);
	}

	@Test
	@Order(value = 8)
	public void typeMismatch() {
		this.testException(new TypeMismatchException("test", String.class), 400);
	}

	@Test
	@Order(value = 9)
	@SuppressWarnings(value = {"all"})
	public void httpMessageNotReadable() {
		HttpInputMessage httpInputMessage = new HttpInputMessage() {
			@Override
			public InputStream getBody() throws IOException {
				return null;
			}

			@Override
			public HttpHeaders getHeaders() {
				return null;
			}
		};
		this.testException(new HttpMessageNotReadableException("message", httpInputMessage), 400);
	}

	@Test
	@Order(value = 10)
	public void httpMessageNotWritable() {
		this.testException(new HttpMessageNotWritableException(""), 500);
	}

	@Test
	@Order(value = 11)
	public void methodArgumentNotValid() {
		Exception exception = mock(MethodArgumentNotValidException.class);
		this.testException(exception, 400);
	}

	@Test
	@Order(value = 12)
	public void missingServletRequestPart() {
		this.testException(new MissingServletRequestPartException("partName"), 400);
	}

	@Test
	@Order(value = 13)
	public void bindException() {
		this.testException(new BindException(new Object(), "name"), 400);
	}

	@Test
	@Order(value = 14)
	public void noHandlerFoundException() {
		this.testException(new NoHandlerFoundException("GET", "/", new HttpHeaders()), 404);
	}

	@Test
	@Order(value = 15)
	public void asyncRequestTimeoutException() {
		this.testException(new AsyncRequestTimeoutException(), 503);
	}


}