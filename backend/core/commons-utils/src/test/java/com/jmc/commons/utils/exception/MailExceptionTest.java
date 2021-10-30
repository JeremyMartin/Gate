package com.jmc.commons.utils.exception;

import com.jmc.commons.utils.test.AbstractUnitTest;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Jeremy MARTIN CATANI
 * created on 29/10/2021
 */
public class MailExceptionTest extends AbstractUnitTest {

	private static final String MESSAGE = "message";
	private static final MailException EXCEPTION = new MailException(MESSAGE);

	@Test
	@Order(value = 1)
	public void getMessage() {
		assertEquals(MESSAGE, EXCEPTION.getMessage(), "Message must be equals");
	}

}