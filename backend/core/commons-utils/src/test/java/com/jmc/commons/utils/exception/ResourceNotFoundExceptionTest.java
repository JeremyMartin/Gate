package com.jmc.commons.utils.exception;

import com.jmc.commons.utils.helpers.MessageHelper;
import com.jmc.commons.utils.test.AbstractUnitTest;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Jeremy MARTIN CATANI
 * created on 29/10/2021
 */
public class ResourceNotFoundExceptionTest extends AbstractUnitTest {

	private static final String RESOURCE = "resource";
	private static final String NAME = "name";
	private static final String VALUE = "value";
	private static final ResourceNotFoundException EXCEPTION = new ResourceNotFoundException(RESOURCE, NAME, VALUE);

	@Test
	@Order(value = 1)
	public void getMessage() {
		assertEquals(MessageHelper.RESOURCE_NOT_FOUND, EXCEPTION.getMessage(), "Message must be equal");
	}

	@Test
	@Order(value = 2)
	public void getResource() {
		assertEquals(RESOURCE, EXCEPTION.getResource(), "Resource must be equal");
	}

	@Test
	@Order(value = 3)
	public void getName() {
		assertEquals(NAME, EXCEPTION.getName(), "Name must be equal");
	}

	@Test
	@Order(value = 4)
	public void getValue() {
		assertEquals(VALUE, EXCEPTION.getValue(), "Value must be equal");
	}

}