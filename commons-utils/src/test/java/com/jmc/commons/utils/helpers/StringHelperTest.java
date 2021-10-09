package com.jmc.commons.utils.helpers;

import com.jmc.commons.utils.AbstractFinalClassHelperTest;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Jeremy MARTIN CATANI
 * @created 09/10/2021
 */
public class StringHelperTest extends AbstractFinalClassHelperTest {

	@Override
	protected void setClassToTest() {
		CLASS_TO_TEST = StringHelper.class;
	}

	@Order(value = 1)
	@Test
	public void capitalizeTest() {
		String result = StringHelper.capitalize(null);
		assertNull(result, "Result must be null");
		result = StringHelper.capitalize("HELLO WORLD");
		assertNotNull(result, "Result must not be null");
		assertEquals("Hello World", result, "Result must not be equals");
	}

	@Order(value = 2)
	@Test
	public void generateUuidTest() {
		String result = StringHelper.generateUUid();
		assertNotNull(result, "Result must not be null");
	}

	@Order(value = 3)
	@Test
	public void trimStartEndTest() {
		String result = StringHelper.trimStartEnd(null);
		assertNull(result, "Result must be null");
		result = StringHelper.trimStartEnd(" HELLO WORLD ");
		assertEquals("HELLO WORLD", result, "Result must not be equals");
	}

}
