package com.jmc.commons.utils;

import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

/**
 * @author Jeremy MARTIN CATANI
 * @created 10/10/2021
 */
@TestInstance(value = TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(value = MethodOrderer.OrderAnnotation.class)
public abstract class AbstractEnumTest {

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
	public void valueOfEnumTest() {
		this.setClassToTest();
		try {
			Method method = CLASS_TO_TEST.getMethod("values");
			Object[] objects = (Object[]) method.invoke(null);
			for (Object o : objects) {
				CLASS_TO_TEST.getMethod("valueOf", String.class).invoke(null, o.toString());
			}
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
		}
	}

}
