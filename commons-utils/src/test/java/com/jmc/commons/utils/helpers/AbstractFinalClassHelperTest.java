package com.jmc.commons.utils.helpers;

import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nonnull;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.time.Duration;

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

	protected static String calculateExecutionTime(@Nonnull final long start) {
		long executionTime = System.nanoTime() - start;
		final Duration duration = Duration.ofNanos(executionTime);
		long days = duration.toDays();
		final long years = days / 365;
		days %= 365;
		final long months = days / 30;
		days %= 30;
		final long weeks = days / 7;
		days %= 7;
		final long hours = duration.toHours() % 24;
		final long minutes = duration.toMinutes() % 60;
		final long seconds = duration.toSeconds() % 60;
		final long milliseconds = duration.toMillis() % 1000;
		final long nanoseconds = duration.toNanos() % 1000000;
		StringBuilder sb = new StringBuilder();
		if (years > 0) {
			sb.append(years).append("Y");
		}
		if (months > 0 || sb.length() > 0) {
			if (sb.length() > 0) {
				sb.append(" ");
			}
			sb.append(months).append("M");
		}
		if (weeks > 0 || sb.length() > 0) {
			if (sb.length() > 0) {
				sb.append(" ");
			}
			sb.append(weeks).append("w");
		}
		if (days > 0 || sb.length() > 0) {
			if (sb.length() > 0) {
				sb.append(" ");
			}
			sb.append(days).append("d");
		}
		if (hours > 0 || sb.length() > 0) {
			if (sb.length() > 0) {
				sb.append(" ");
			}
			sb.append(hours).append("h");
		}
		if (minutes > 0 || sb.length() > 0) {
			if (sb.length() > 0) {
				sb.append(" ");
			}
			sb.append(minutes).append("m");
		}
		if (seconds > 0 || sb.length() > 0) {
			if (sb.length() > 0) {
				sb.append(" ");
			}
			sb.append(seconds).append("s");
		}
		if (milliseconds > 0) {
			if (sb.length() > 0) {
				sb.append(" ");
			}
			sb.append(milliseconds).append("ms");
		}
		if (nanoseconds > 0 && sb.length() == 0) {
			sb.append(nanoseconds).append("ns");
		}
		return sb.toString();
	}

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
		LOG.info("End : {}, duration {}", testInfo.getDisplayName(), calculateExecutionTime(START_EACH_TIME));
	}

	@AfterAll
	public void afterAll() {
		LOG.info("END duration {}", calculateExecutionTime(START_GLOBAL_TIME));
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
