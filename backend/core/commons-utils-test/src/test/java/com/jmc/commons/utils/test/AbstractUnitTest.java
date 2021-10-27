package com.jmc.commons.utils.test;

import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This abstract class consists of monitoring the tests
 *
 * @author Jeremy MARTIN CATANI
 * created on 26/10/2021
 */
@TestInstance(value = TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(value = MethodOrderer.OrderAnnotation.class)
public abstract class AbstractUnitTest {

	protected static long START_GLOBAL_TIME;
	protected static long START_EACH_TIME;

	protected final Logger LOG = LoggerFactory.getLogger(getClass());

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
		LOG.info("End : {}, duration {}", testInfo.getDisplayName(), TestCalculator.calculateExecutionTime(START_EACH_TIME));
	}

	@AfterAll
	public void afterAll() {
		LOG.info("END duration {}", TestCalculator.calculateExecutionTime(START_GLOBAL_TIME));
	}

}
