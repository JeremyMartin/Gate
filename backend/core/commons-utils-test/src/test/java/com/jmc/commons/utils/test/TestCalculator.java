package com.jmc.commons.utils.test;

import jakarta.validation.constraints.NotNull;

import java.time.Duration;

/**
 * This class consists of static utility methods for calculate execution time of tests
 *
 * @author Jeremy MARTIN CATANI
 * created on 26/10/2021
 */
public final class TestCalculator {

	/**
	 * Calculate the execution time
	 *
	 * @param start System.nanoTime()
	 *
	 * @return human-readable time
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
		StringBuilder stringBuilder = new StringBuilder();
		if (years > 0) {
			stringBuilder.append(years)
						 .append("Y");
		}
		if (months > 0 || stringBuilder.length() > 0) {
			if (stringBuilder.length() > 0) {
				stringBuilder.append(" ");
			}
			stringBuilder.append(months)
						 .append("M");
		}
		if (weeks > 0 || stringBuilder.length() > 0) {
			if (stringBuilder.length() > 0) {
				stringBuilder.append(" ");
			}
			stringBuilder.append(weeks)
						 .append("w");
		}
		if (days > 0 || stringBuilder.length() > 0) {
			if (stringBuilder.length() > 0) {
				stringBuilder.append(" ");
			}
			stringBuilder.append(days)
						 .append("d");
		}
		if (hours > 0 || stringBuilder.length() > 0) {
			if (stringBuilder.length() > 0) {
				stringBuilder.append(" ");
			}
			stringBuilder.append(hours)
						 .append("h");
		}
		if (minutes > 0 || stringBuilder.length() > 0) {
			if (stringBuilder.length() > 0) {
				stringBuilder.append(" ");
			}
			stringBuilder.append(minutes)
						 .append("m");
		}
		if (seconds > 0 || stringBuilder.length() > 0) {
			if (stringBuilder.length() > 0) {
				stringBuilder.append(" ");
			}
			stringBuilder.append(seconds)
						 .append("s");
		}
		if (milliseconds > 0) {
			if (stringBuilder.length() > 0) {
				stringBuilder.append(" ");
			}
			stringBuilder.append(milliseconds)
						 .append("ms");
		}
		if (nanoseconds > 0 && stringBuilder.length() == 0) {
			stringBuilder.append(nanoseconds)
						 .append("ns");
		}
		return stringBuilder.toString();
	}

	private TestCalculator() {
	}

}
