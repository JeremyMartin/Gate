package com.jmc.commons.utils;

import javax.validation.constraints.NotNull;
import java.time.Duration;

/**
 * This class consists of static utility methods for calculate execution time of test
 *
 * @author Jeremy MARTIN CATANI
 * @created 10/10/2021
 */
public final class TestCalculatorHelper {

	/**
	 * @param start System.nanTime()
	 *
	 * @return human readable time
	 *
	 * @see System#nanoTime()
	 */
	public static String calculateExecutionTime(@NotNull final long start) {
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

	private TestCalculatorHelper() {}

}
