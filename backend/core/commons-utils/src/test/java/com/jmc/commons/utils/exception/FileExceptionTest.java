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
public class FileExceptionTest extends AbstractUnitTest {

	private static final String DESTINATION = "destination";
	private static final String MESSAGE = "message";
	private static final String SOURCE = "source";
	private static final FileException EXCEPTION = new FileException(MESSAGE, SOURCE);
	private static final FileException EXCEPTION_ALL = new FileException(MESSAGE, SOURCE, DESTINATION);

	@Test
	@Order(value = 1)
	public void getMessage() {
		assertEquals(MESSAGE, EXCEPTION.getMessage(), "Message must be equal");
		assertEquals(MESSAGE, EXCEPTION_ALL.getMessage(), "Message must be equal");
	}

	@Test
	@Order(value = 2)
	public void getSource() {
		assertEquals(SOURCE, EXCEPTION.getSource(), "Source must be equal");
		assertEquals(SOURCE, EXCEPTION_ALL.getSource(), "Source must be equal");
	}

	@Test
	@Order(value = 3)
	public void getDestination() {
		assertNull(EXCEPTION.getDestination(), "Destination must be null");
		assertEquals(DESTINATION, EXCEPTION_ALL.getDestination(), "Destination must be equal");
	}

}