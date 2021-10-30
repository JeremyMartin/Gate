package com.jmc.commons.web.exception;

import com.jmc.commons.utils.helpers.MessageHelper;
import com.jmc.commons.utils.model.ExceptionResponse;
import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.validation.BindException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.async.AsyncRequestTimeoutException;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This class consists of provide centralized exception handling across all {@code @RequestMapping}
 *
 * @author Jeremy MARTIN CATANI
 * created on 28/10/2021
 * @see ResponseEntityExceptionHandler
 */
@Order(value = Ordered.HIGHEST_PRECEDENCE)
@RestControllerAdvice
@SuppressWarnings(value = "NullableProblems")
public class ExceptionController extends ResponseEntityExceptionHandler {

	protected String resolvePath(final WebRequest webRequest) {
		return ((ServletWebRequest) webRequest).getRequest()
											   .getRequestURI();
	}

	protected void logError(final ResponseEntity<Object> responseEntity, final Exception exception) {
		String message = "ResponseBody=" + responseEntity.getBody() + ", RootMessage=" + exception.getMessage();
		logger.error(message);
	}

	private ResponseEntity<Object> buildResponseHttpRequestMethodNotSupported(final HttpRequestMethodNotSupportedException ex,
																			  final HttpHeaders headers,
																			  final HttpStatus status,
																			  final WebRequest request) {

		String path = this.resolvePath(request);
		ExceptionResponse body = new ExceptionResponse(MessageHelper.NOT_VALID, path, ex.getMethod(), ex.getSupportedMethods());
		ResponseEntity<Object> responseEntity = new ResponseEntity<>(body, headers, status);
		this.logError(responseEntity, ex);
		return responseEntity;
	}

	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(final HttpRequestMethodNotSupportedException ex,
																		 final HttpHeaders headers,
																		 final HttpStatus status,
																		 final WebRequest request) {
		return this.buildResponseHttpRequestMethodNotSupported(ex, headers, status, request);
	}

	@Override
	protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(final HttpMediaTypeNotSupportedException ex,
																	 final HttpHeaders headers,
																	 final HttpStatus status,
																	 final WebRequest request) {
		return super.handleHttpMediaTypeNotSupported(ex, headers, status, request);
	}

	@Override
	protected ResponseEntity<Object> handleHttpMediaTypeNotAcceptable(final HttpMediaTypeNotAcceptableException ex,
																	  final HttpHeaders headers,
																	  final HttpStatus status,
																	  final WebRequest request) {
		return super.handleHttpMediaTypeNotAcceptable(ex, headers, status, request);
	}

	@Override
	protected ResponseEntity<Object> handleMissingPathVariable(final MissingPathVariableException ex,
															   final HttpHeaders headers,
															   final HttpStatus status,
															   final WebRequest request) {
		return super.handleMissingPathVariable(ex, headers, status, request);
	}

	@Override
	protected ResponseEntity<Object> handleMissingServletRequestParameter(final MissingServletRequestParameterException ex,
																		  final HttpHeaders headers,
																		  final HttpStatus status,
																		  final WebRequest request) {
		return super.handleMissingServletRequestParameter(ex, headers, status, request);
	}

	@Override
	protected ResponseEntity<Object> handleServletRequestBindingException(final ServletRequestBindingException ex,
																		  final HttpHeaders headers,
																		  final HttpStatus status,
																		  final WebRequest request) {
		return super.handleServletRequestBindingException(ex, headers, status, request);
	}

	@Override
	protected ResponseEntity<Object> handleConversionNotSupported(final ConversionNotSupportedException ex,
																  final HttpHeaders headers,
																  final HttpStatus status,
																  final WebRequest request) {
		return super.handleConversionNotSupported(ex, headers, status, request);
	}

	@Override
	protected ResponseEntity<Object> handleTypeMismatch(final TypeMismatchException ex,
														final HttpHeaders headers,
														final HttpStatus status,
														final WebRequest request) {
		return super.handleTypeMismatch(ex, headers, status, request);
	}

	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(final HttpMessageNotReadableException ex,
																  final HttpHeaders headers,
																  final HttpStatus status,
																  final WebRequest request) {
		return super.handleHttpMessageNotReadable(ex, headers, status, request);
	}

	@Override
	protected ResponseEntity<Object> handleHttpMessageNotWritable(final HttpMessageNotWritableException ex,
																  final HttpHeaders headers,
																  final HttpStatus status,
																  final WebRequest request) {
		return super.handleHttpMessageNotWritable(ex, headers, status, request);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(final MethodArgumentNotValidException ex,
																  final HttpHeaders headers,
																  final HttpStatus status,
																  final WebRequest request) {
		return super.handleMethodArgumentNotValid(ex, headers, status, request);
	}

	@Override
	protected ResponseEntity<Object> handleMissingServletRequestPart(final MissingServletRequestPartException ex,
																	 final HttpHeaders headers,
																	 final HttpStatus status,
																	 final WebRequest request) {
		return super.handleMissingServletRequestPart(ex, headers, status, request);
	}

	@Override
	protected ResponseEntity<Object> handleBindException(final BindException ex,
														 final HttpHeaders headers,
														 final HttpStatus status,
														 final WebRequest request) {
		return super.handleBindException(ex, headers, status, request);
	}

	@Override
	protected ResponseEntity<Object> handleNoHandlerFoundException(final NoHandlerFoundException ex,
																   final HttpHeaders headers,
																   final HttpStatus status,
																   final WebRequest request) {
		return super.handleNoHandlerFoundException(ex, headers, status, request);
	}

	@Override
	protected ResponseEntity<Object> handleAsyncRequestTimeoutException(final AsyncRequestTimeoutException ex,
																		final HttpHeaders headers,
																		final HttpStatus status,
																		final WebRequest webRequest) {
		return super.handleAsyncRequestTimeoutException(ex, headers, status, webRequest);
	}

	@Override
	protected ResponseEntity<Object> handleExceptionInternal(final Exception ex,
															 final Object body,
															 final HttpHeaders headers,
															 final HttpStatus status,
															 final WebRequest request) {
		return super.handleExceptionInternal(ex, body, headers, status, request);
	}

}
