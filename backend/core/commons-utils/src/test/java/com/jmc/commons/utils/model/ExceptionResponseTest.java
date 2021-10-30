package com.jmc.commons.utils.model;

import com.jmc.commons.utils.test.AbstractUnitTest;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Jeremy MARTIN CATANI
 * created on 29/10/2021
 */
public class ExceptionResponseTest extends AbstractUnitTest {

	private static final String MESSAGE = "message";
	private static final String PATH = "path";
	private static final Object EXPECTED = "expected";
	private static final Object FOUND = "found";
	private static final ExceptionResponse MESSAGE_PATH = new ExceptionResponse(MESSAGE, PATH);
	private static final String TO_STRING_MESSAGE_PATH = MESSAGE_PATH.toString();
	private static final ExceptionResponse MESSAGE_PATH_EXPECTED = new ExceptionResponse(MESSAGE, PATH, EXPECTED);
	private static final String TO_STRING_MESSAGE_PATH_EXPECTED = MESSAGE_PATH_EXPECTED.toString();
	private static final ExceptionResponse ALL = new ExceptionResponse(MESSAGE, PATH, EXPECTED, FOUND);
	private static final String TO_STRING_ALL = ALL.toString();

	@Test
	@Order(value = 1)
	public void getTimestamp() {
		assertNotNull(MESSAGE_PATH.getTimestamp(), "Timestamp must not be null");
		assertNotNull(MESSAGE_PATH_EXPECTED.getTimestamp(), "Timestamp must not be null");
		assertNotNull(ALL.getTimestamp(), "Timestamp must not be null");
	}

	@Test
	@Order(value = 2)
	public void getMessage() {
		assertNotNull(MESSAGE_PATH.getMessage(), "Message must not be null");
		assertNotNull(MESSAGE_PATH_EXPECTED.getMessage(), "Message must not be null");
		assertNotNull(ALL.getMessage(), "Message must not be null");
	}

	@Test
	@Order(value = 3)
	public void getPath() {
		assertNotNull(MESSAGE_PATH.getPath(), "Path must not be null");
		assertNotNull(MESSAGE_PATH_EXPECTED.getPath(), "Path must not be null");
		assertNotNull(ALL.getPath(), "Path must not be null");
	}

	@Test
	@Order(value = 4)
	public void getExpected() {
		assertNull(MESSAGE_PATH.getExpected(), "Expected must be null");
		assertNotNull(MESSAGE_PATH_EXPECTED.getExpected(), "Expected must not be null");
		assertNotNull(ALL.getExpected(), "Expected must not be null");
	}

	@Test
	@Order(value = 5)
	public void getFound() {
		assertNull(MESSAGE_PATH.getFound(), "Found must be null");
		assertNull(MESSAGE_PATH_EXPECTED.getFound(), "Found must be null");
		assertNotNull(ALL.getFound(), "Found must not be null");
	}

	@Test
	@Order(value = 6)
	public void testToString() {
		assertEquals(TO_STRING_MESSAGE_PATH, MESSAGE_PATH.toString(), "ToString method must be equal");
		assertEquals(TO_STRING_MESSAGE_PATH_EXPECTED, MESSAGE_PATH_EXPECTED.toString(), "ToString method must be equal");
		assertEquals(TO_STRING_ALL, ALL.toString(), "ToString method must be equal");
	}

}