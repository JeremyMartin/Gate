package com.jmc.commons.utils.exception;

import com.jmc.commons.utils.test.AbstractUnitTest;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Jeremy MARTIN CATANI
 * created on 29/10/2021
 */
public class MessageExceptionTest extends AbstractUnitTest {

	private static final String FIELD = "field";
	private static final String MESSAGE = "message";
	private static final String VALUE = "value";
	private static final MessageException EXCEPTION = new MessageException(MESSAGE, FIELD, VALUE);

	@Test
	@Order(value = 1)
	public void getMessage() {
		assertEquals(MESSAGE, EXCEPTION.getMessage(), "Message must be equal");
	}

	@Test
	@Order(value = 2)
	public void getField() {
		assertEquals(FIELD, EXCEPTION.getField(), "Field must be equal");
	}

	@Test
	@Order(value = 3)
	public void getValue() {
		assertEquals(VALUE, EXCEPTION.getValue(), "Value must be equal");
	}

}