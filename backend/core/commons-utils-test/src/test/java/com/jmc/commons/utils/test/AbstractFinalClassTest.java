package com.jmc.commons.utils.test;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.fail;

/**
 * This abstract class consists in testing the final class with private constructor
 *
 * @author Jeremy MARTIN CATANI
 * created on 27/10/2021
 */
public abstract class AbstractFinalClassTest extends AbstractUnitTest {

	protected static Class<?> CLASS_TO_TEST;

	protected abstract void setClassToTest();

	@Test
	@Order(value = 0)
	public void privateConstructorTest() {
		this.setClassToTest();
		Exception exception = null;
		try {
			Constructor<?> constructor = CLASS_TO_TEST.getDeclaredConstructor();
			if (!Modifier.isPrivate(constructor.getModifiers())) {
				fail("Constructor is not private");
			}
			constructor.setAccessible(Boolean.TRUE);
			constructor.newInstance();
		} catch (Exception ex) {
			exception = ex;
		}
		assertNull(exception, "Exception must be null");
	}

}
