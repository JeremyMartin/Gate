package com.jmc.commons.utils.test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.modules.junit4.PowerMockRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This abstract class consists in testing with mocks for code coverage
 *
 * @author Jeremy MARTIN CATANI
 * created on 27/10/2021
 */
@FixMethodOrder(value = MethodSorters.NAME_ASCENDING)
@RunWith(value = PowerMockRunner.class)
@PowerMockIgnore(value = {"com.sun.org.apache.xerces.*", "javax.xml.*", "org.xml.*", "javax.management.*"})
public abstract class AbstractMockTest {

	protected static Logger LOG = LoggerFactory.getLogger(AbstractMockTest.class);
	protected static long START_GLOBAL_TIME;
	protected static long START_EACH_TIME;

	@Rule
	public TestWatcher testWatcher = new TestWatcher() {
		@Override
		protected void starting(final Description description) {
			LOG.info("Start : {}()", description.getMethodName());
			START_EACH_TIME = System.nanoTime();
		}

		@Override
		protected void finished(final Description description) {
			LOG.info("End : {}(), duration {}", description.getMethodName(), TestCalculator.calculateExecutionTime(START_EACH_TIME));
		}
	};

	@BeforeClass
	public static void beforeAll() {
		LOG.info("START");
		START_GLOBAL_TIME = System.nanoTime();
	}

	@AfterClass
	public static void afterAll() {
		LOG.info("END duration {}", TestCalculator.calculateExecutionTime(START_GLOBAL_TIME));
	}

}
