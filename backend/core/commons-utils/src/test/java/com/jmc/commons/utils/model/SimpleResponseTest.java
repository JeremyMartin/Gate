package com.jmc.commons.utils.model;

import com.jmc.commons.utils.test.AbstractUnitTest;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Jeremy MARTIN CATANI
 * created on 28/10/2021
 */
public class SimpleResponseTest extends AbstractUnitTest {

	private static final String MESSAGE = "ok";
	private static final SimpleResponse SIMPLE_RESPONSE = new SimpleResponse(MESSAGE);
	private static final String TO_STRING = SIMPLE_RESPONSE.toString();

	@Test
	@Order(value = 1)
	public void getMessage() {
		assertEquals(MESSAGE, SIMPLE_RESPONSE.getMessage());
	}

	@Test
	@Order(value = 2)
	public void testToString() {
		assertEquals(TO_STRING, SIMPLE_RESPONSE.toString());
	}

}