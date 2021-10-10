package com.jmc.commons.utils;

import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.fail;

/**
 * @author Jeremy MARTIN CATANI
 * @created 08/10/2021
 */
@TestInstance(value = TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(value = MethodOrderer.OrderAnnotation.class)
public abstract class AbstractFinalClassHelperTest {

	protected static long START_GLOBAL_TIME;
	protected static long START_EACH_TIME;
	protected static Class<?> CLASS_TO_TEST;
	protected final Logger LOG = LoggerFactory.getLogger(getClass());

	protected abstract void setClassToTest();

	@BeforeAll
	public void beforeAll() {
		LOG.info("START");
		START_GLOBAL_TIME = System.nanoTime();
	}

	@BeforeEach
	public void beforeEach(final TestInfo testInfo) {
		LOG.info("Start : {}", testInfo.getDisplayName());
		START_EACH_TIME = System.nanoTime();
	}

	@AfterEach
	public void afterEach(final TestInfo testInfo) {
		LOG.info("End : {}, duration {}", testInfo.getDisplayName(), TestCalculatorHelper.calculateExecutionTime(START_EACH_TIME));
	}

	@AfterAll
	public void afterAll() {
		LOG.info("END duration {}", TestCalculatorHelper.calculateExecutionTime(START_GLOBAL_TIME));
	}

	@Test
	@Order(value = 0)
	public void privateConstructorTest() {
		this.setClassToTest();
		try {
			Constructor<?> constructor = CLASS_TO_TEST.getDeclaredConstructor();
			if (!Modifier.isPrivate(constructor.getModifiers())) {
				fail("Constructor is not private");
			}
			constructor.setAccessible(Boolean.TRUE);
			constructor.newInstance();
		} catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException ex) {
			assertNull(ex.getMessage(), "Exception message must be null");
		}
	}

}
