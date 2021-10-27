package com.jmc.commons.utils.test;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * This abstract class consists in testing the class of type enum
 *
 * @author Jeremy MARTIN CATANI
 * created on 27/10/2021
 */
public abstract class AbstractEnumTest extends AbstractUnitTest {

	protected static Class<?> CLASS_TO_TEST;

	protected abstract void setClassToTest();

	@Test
	@Order(value = 0)
	public void valueOfEnumTest() {
		this.setClassToTest();
		Exception exception = null;
		try {
			Method method = CLASS_TO_TEST.getMethod("values");
			Object[] objects = (Object[]) method.invoke(null);
			for (Object o : objects) {
				CLASS_TO_TEST.getMethod("valueOf", String.class)
							 .invoke(null, o.toString());
			}
		} catch (Exception ex) {
			exception = ex;
		}
		assertNull(exception, "Exception must be null");
	}

}
