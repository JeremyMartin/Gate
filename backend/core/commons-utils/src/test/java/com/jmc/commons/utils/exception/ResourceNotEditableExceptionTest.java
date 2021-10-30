package com.jmc.commons.utils.exception;

import com.jmc.commons.utils.helpers.MessageHelper;
import com.jmc.commons.utils.test.AbstractUnitTest;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * @author Jeremy MARTIN CATANI
 * created on 29/10/2021
 */
public class ResourceNotEditableExceptionTest extends AbstractUnitTest {

	private static final String RESOURCE = "resource";
	private static final String MESSAGE_CAUSE = "message cause";
	private static final ResourceNotEditableException SIMPLE = new ResourceNotEditableException(RESOURCE);
	private static final ResourceNotEditableException ALL = new ResourceNotEditableException(RESOURCE, MESSAGE_CAUSE);

	@Test
	@Order(value = 1)
	public void getMessage() {
		assertEquals(MessageHelper.RESOURCE_NOT_EDITABLE, SIMPLE.getMessage(), "Message must be equal");
		assertEquals(MessageHelper.RESOURCE_NOT_EDITABLE, ALL.getMessage(), "Message must be equal");
	}

	@Test
	@Order(value = 2)
	public void getResource() {
		assertEquals(RESOURCE, SIMPLE.getResource(), "Resource must be equal");
		assertEquals(RESOURCE, ALL.getResource(), "Resource must be equal");
	}

	@Test
	@Order(value = 3)
	public void getMessageCause() {
		assertNull(SIMPLE.getMessageCause(), "Message cause must be null");
		assertEquals(MESSAGE_CAUSE, ALL.getMessageCause(), "Message cause must be equal");
	}

}