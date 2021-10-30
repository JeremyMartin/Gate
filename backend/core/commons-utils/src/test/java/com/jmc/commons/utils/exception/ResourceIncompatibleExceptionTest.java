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
public class ResourceIncompatibleExceptionTest extends AbstractUnitTest {

	private static final String RESOURCE = "resource";
	private static final String VALUE = "value";
	private static final ResourceIncompatibleException EXCEPTION = new ResourceIncompatibleException(RESOURCE, VALUE);

	@Test
	@Order(value = 1)
	public void getMessage() {
		assertEquals(MessageHelper.RESOURCE_INCOMPATIBLE, EXCEPTION.getMessage(), "Message must be equal");
	}

	@Test
	@Order(value = 2)
	public void getResource() {
		assertEquals(RESOURCE, EXCEPTION.getResource(), "Resource must be equal");
	}

	@Test
	@Order(value = 2)
	public void getValue() {
		assertEquals(VALUE, EXCEPTION.getValue(), "Value must be equal");
	}

}