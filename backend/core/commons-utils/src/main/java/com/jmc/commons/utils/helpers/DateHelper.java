package com.jmc.commons.utils.helpers;

import jakarta.validation.constraints.NotNull;

import javax.annotation.Nullable;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;

/**
 * This class consists of date utilities
 *
 * @author Jeremy MARTIN CATANI
 * created on 27/10/2021
 */
public final class DateHelper {

	private static final ZoneId ZONE_ID = ZoneId.systemDefault();

	/**
	 * Convert {@link Date} to {@link LocalDate}
	 *
	 * @param date date to be converted, may be null
	 *
	 * @return localDate {@code null} if null input
	 */
	public static LocalDate convertDate2LocalDate(@Nullable final Date date) {
		if (date != null) {
			return Instant.ofEpochMilli(date.getTime())
						  .atZone(ZONE_ID)
						  .toLocalDate();
		}
		return null;
	}

	/**
	 * Convert {@link LocalDate} to {@link Date}
	 *
	 * @param localDate localDate to be converted, may be null
	 *
	 * @return date {@code null} if null input
	 */
	public static Date convertLocalDate2Date(@Nullable final LocalDate localDate) {
		if (localDate != null) {
			return Date.from(localDate.atStartOfDay()
									  .atZone(ZONE_ID)
									  .toInstant());
		}
		return null;
	}

	/**
	 * Convert {@link LocalDateTime} to {@link Date}
	 *
	 * @param localDateTime localDateTime to be converted, may be null
	 *
	 * @return date {@code null} if null input
	 */
	public static Date convertLocalDateTime2Date(@Nullable final LocalDateTime localDateTime) {
		if (localDateTime != null) {
			return Date.from(localDateTime.atZone(ZONE_ID)
										  .toInstant());
		}
		return null;
	}

	/**
	 * Convert {@link Date} to {@link LocalDateTime}
	 *
	 * @param date date to be converted, may be null
	 *
	 * @return localDateTime {@code null} if null input
	 */
	public static LocalDateTime convertDate2LocalDateTime(@Nullable final Date date) {
		if (date != null) {
			return Instant.ofEpochMilli(date.getTime())
						  .atZone(ZONE_ID)
						  .toLocalDateTime();
		}
		return null;
	}

	/**
	 * Calculates the amount of time between two {@link Date}
	 *
	 * @param chronoUnit date periods units
	 * @param start the date inclusive, not null
	 * @param end the date exclusive, not null
	 *
	 * @return the amount of time between start and end in terms of this unit; positive if end is later than start, negative if earlier
	 */
	public static long calculateDifference(@NotNull final ChronoUnit chronoUnit, @NotNull final Date start, @NotNull final Date end) {
		return chronoUnit.between(start.toInstant(), end.toInstant());
	}

	/**
	 * Calculates the amount of time between two {@link LocalDateTime}
	 *
	 * @param chronoUnit date periods units
	 * @param start the localDateTime inclusive, not null
	 * @param end the localDateTime exclusive, not null
	 *
	 * @return the amount of time between start and end in terms of this unit; positive if end is later than start, negative if earlier
	 */
	public static long calculateDifference(@NotNull final ChronoUnit chronoUnit,
										   @NotNull final LocalDateTime start,
										   @NotNull final LocalDateTime end) {
		return chronoUnit.between(start, end);
	}

	private DateHelper() {
	}

}
