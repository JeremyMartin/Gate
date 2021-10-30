package com.jmc.commons.utils.model;

import com.jmc.commons.utils.test.AbstractUnitTest;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Jeremy MARTIN CATANI
 * created on 28/10/2021
 */
public class ExpectedResponseTest extends AbstractUnitTest {

	private static final String RESOURCE = "resource";
	private static final String FIELD = "field";
	private static final String VALUE = "value";
	private static final String MESSAGE = "message";
	private static final ExpectedResponse FIELD_VALUE = new ExpectedResponse(FIELD, VALUE);
	private static final String TO_STRING_FIELD_VALUE = FIELD_VALUE.toString();
	private static final ExpectedResponse RESOURCE_VALUE_BY_TYPE = new ExpectedResponse(RESOURCE, Boolean.TRUE, VALUE);
	private static final String TO_STRING_RESOURCE_VALUE_BY_TYPE = RESOURCE_VALUE_BY_TYPE.toString();
	private static final ExpectedResponse FIELD_VALUE_BY_TYPE = new ExpectedResponse(FIELD, Boolean.FALSE, VALUE);
	private static final String TO_STRING_FIELD_VALUE_BY_TYPE = FIELD_VALUE_BY_TYPE.toString();
	private static final ExpectedResponse ALL = new ExpectedResponse(RESOURCE, FIELD, VALUE, MESSAGE);
	private static final String TO_STRING_ALL = ALL.toString();

	@Test
	@Order(value = 1)
	public void getResource() {
		assertNull(FIELD_VALUE.getResource(), "Resource must be null");
		assertEquals(RESOURCE, RESOURCE_VALUE_BY_TYPE.getResource(), "Resource must be equal");
		assertNull(FIELD_VALUE_BY_TYPE.getResource(), "Resource must be null");
		assertEquals(RESOURCE, ALL.getResource(), "Resource must be equal");
	}

	@Test
	@Order(value = 2)
	public void getField() {
		assertEquals(FIELD, FIELD_VALUE.getField(), "Field must be equal");
		assertNull(RESOURCE_VALUE_BY_TYPE.getField(), "Field must be null");
		assertEquals(FIELD, FIELD_VALUE_BY_TYPE.getField(), "Field must be equal");
		assertEquals(FIELD, ALL.getField(), "Field must be equal");
	}

	@Test
	@Order(value = 3)
	public void getValue() {
		assertEquals(VALUE, FIELD_VALUE.getValue(), "Value must be equal");
		assertEquals(VALUE, RESOURCE_VALUE_BY_TYPE.getValue(), "Value must be equal");
		assertEquals(VALUE, FIELD_VALUE_BY_TYPE.getValue(), "Value must be equal");
		assertEquals(VALUE, ALL.getValue(), "Value must be equal");
	}

	@Test
	@Order(value = 4)
	public void getMessage() {
		assertNull(FIELD_VALUE.getMessage(), "Message must be null");
		assertNull(RESOURCE_VALUE_BY_TYPE.getMessage(), "Message must be null");
		assertNull(FIELD_VALUE_BY_TYPE.getMessage(), "Message must be null");
		assertEquals(MESSAGE, ALL.getMessage(), "Message must be equal");
	}

	@Test
	@Order(value = 5)
	public void testToString() {
		assertEquals(TO_STRING_FIELD_VALUE, FIELD_VALUE.toString(), "ToString method must be equal");
		assertEquals(TO_STRING_RESOURCE_VALUE_BY_TYPE, RESOURCE_VALUE_BY_TYPE.toString(), "ToString method must be equal");
		assertEquals(TO_STRING_FIELD_VALUE_BY_TYPE, FIELD_VALUE_BY_TYPE.toString(), "ToString method must be equal");
		assertEquals(TO_STRING_ALL, ALL.toString(), "ToString method must be equal");
	}

}