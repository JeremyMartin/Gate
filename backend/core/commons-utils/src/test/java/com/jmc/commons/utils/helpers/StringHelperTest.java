package com.jmc.commons.utils.helpers;

import com.jmc.commons.utils.test.AbstractFinalClassTest;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Jeremy MARTIN CATANI
 * created on 27/10/2021
 */
public class StringHelperTest extends AbstractFinalClassTest {

	@Override
	protected void setClassToTest() {
		CLASS_TO_TEST = StringHelper.class;
	}

	@Test
	@Order(value = 1)
	public void capitalizeTest() {
		String value = "hello";
		String expected = "Hello";
		String response = StringHelper.capitalize(value);
		assertNotNull(response, "Invocation must not be null");
		assertEquals(expected, response, "Expected and invocation must be equals");
		value = "hello world";
		expected = "Hello World";
		response = StringHelper.capitalize(value);
		assertNotNull(response, "Invocation must not be null");
		assertEquals(expected, StringHelper.capitalize(value), "Expected and invocation must be equals");
		value = "hello-world";
		expected = "Hello-World";
		response = StringHelper.capitalize(value);
		assertNotNull(response, "Invocation must not be null");
		assertEquals(expected, StringHelper.capitalize(value), "Expected and invocation must be equals");
		value = "hello—world";
		expected = "Hello—World";
		response = StringHelper.capitalize(value);
		assertNotNull(response, "Invocation must not be null");
		assertEquals(expected, StringHelper.capitalize(value), "Expected and invocation must be equals");
		value = "hello'world";
		expected = "Hello'World";
		response = StringHelper.capitalize(value);
		assertNotNull(response, "Invocation must not be null");
		assertEquals(expected, StringHelper.capitalize(value), "Expected and invocation must be equals");
		value = "hello`world";
		expected = "Hello`World";
		response = StringHelper.capitalize(value);
		assertNotNull(response, "Invocation must not be null");
		assertEquals(expected, StringHelper.capitalize(value), "Expected and invocation must be equals");
		value = "hello.word";
		expected = "Hello.Word";
		response = StringHelper.capitalize(value);
		assertNotNull(response, "Invocation must not be null");
		assertEquals(expected, StringHelper.capitalize(value), "Expected and invocation must be equals");
		expected = "";
		assertEquals(expected, StringHelper.capitalize(""), "Expected and invocation must be equals");
		assertNull(StringHelper.capitalize(null), "Invocation must be null");
	}

	@Test
	@Order(value = 2)
	public void generateUUidTest() {
		assertNotNull(StringHelper.generateUUid(), "Invocation must not be null");
	}

	@Test
	@Order(value = 3)
	public void trimStartEndTest() {
		String value = " hello world ";
		String expected = "hello world";
		assertEquals(expected, StringHelper.trimStartEnd(value), "Expected and invocation must be equals");
		assertEquals("", StringHelper.trimStartEnd(""), "Expected and invocation must be equals");
		assertNull(StringHelper.trimStartEnd(null), "Invocation must be null");
	}

}