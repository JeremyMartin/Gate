package com.jmc.commons.utils.helpers.date;

import javax.annotation.Nullable;
import javax.validation.constraints.NotNull;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Objects;

/**
 * This class consists of static utility methods for converting dates
 *
 * @author Jeremy MARTIN CATANI
 * @created 07/10/2021
 */
public final class DateHelper {

	private static final ZoneId ZONE_ID = ZoneId.systemDefault();

	/**
	 * Convert {@link Date} to {@link LocalDate}
	 *
	 * @param date value to convert, nullable
	 *
	 * @return localDate for a non-null argument and null for a null argument
	 *
	 * @see Instant
	 * @see ZoneId
	 */
	public static LocalDate convertDate2LocalDate(@Nullable final Date date) {
		if (Objects.nonNull(date)) {
			return Instant.ofEpochMilli(date.getTime()).atZone(ZONE_ID).toLocalDate();
		}
		return null;
	}

	/**
	 * Convert {@link LocalDate} to {@link Date}
	 *
	 * @param localDate value to convert, nullable
	 *
	 * @return date for a non-null argument and null for a null argument
	 *
	 * @see Instant
	 * @see ZoneId
	 */
	public static Date convertLocalDate2Date(@Nullable final LocalDate localDate) {
		if (Objects.nonNull(localDate)) {
			return Date.from(localDate.atStartOfDay().atZone(ZONE_ID).toInstant());
		}
		return null;
	}

	/**
	 * Convert {@link LocalDateTime} to {@link Date}
	 *
	 * @param localDateTime value to convert, nullable
	 *
	 * @return date for a non-null argument and null for a null argument
	 *
	 * @see Instant
	 * @see ZoneId
	 */
	public static Date convertLocalDateTime2Date(@Nullable final LocalDateTime localDateTime) {
		if (Objects.nonNull(localDateTime)) {
			return Date.from(localDateTime.atZone(ZONE_ID).toInstant());
		}
		return null;
	}

	/**
	 * Convert {@link Date} to {@link LocalDateTime}
	 *
	 * @param date value to convert, nullable
	 *
	 * @return localDateTime for a non-null argument and null for a null argument
	 *
	 * @see Instant
	 * @see ZoneId
	 */
	public static LocalDateTime convertDate2LocalDateTime(@Nullable final Date date) {
		if (Objects.nonNull(date)) {
			return Instant.ofEpochMilli(date.getTime()).atZone(ZONE_ID).toLocalDateTime();
		}
		return null;
	}

	/**
	 * Calculates the amount of time in days between two {@link Date}
	 *
	 * @param start date inclusive, not null
	 * @param end date exclusive, not null
	 *
	 * @return the amount of time in days between start and end in terms of this unit
	 * <p>
	 * positive if end is later than start, negative if earlier
	 * </p>
	 *
	 * @see ChronoUnit
	 * @see Instant
	 */
	public static long calculateDifference(@NotNull final Date start, @NotNull final Date end) {
		return ChronoUnit.DAYS.between(Instant.ofEpochMilli(start.getTime()), Instant.ofEpochMilli(end.getTime()));
	}

	/**
	 * Calculates the amount of time in days between two {@link LocalDate}
	 *
	 * @param start localDate inclusive, not null
	 * @param end LocalDate exclusive, not null
	 *
	 * @return the amount of time in days between start and end in terms of this unit
	 * <p>
	 * positive if end is later than start, negative if earlier
	 * </p
	 *
	 * @see ChronoUnit
	 * @see Instant
	 */
	public static long calculateDifference(@NotNull final LocalDate start, @NotNull final LocalDate end) {
		return calculateDifference(Objects.requireNonNull(convertLocalDate2Date(start)), Objects.requireNonNull(convertLocalDate2Date(end)));
	}

	/**
	 * Calculates the amount of time between two {@link LocalDateTime}
	 *
	 * @param chronoUnit value standard set of date periods units, not null
	 * @param start localDateTime inclusive, not null
	 * @param end localDateTime exclusive, not null
	 *
	 * @return the amount of time between start and end in terms of this unit
	 * <p>
	 * positive if end is later than start, negative if earlier
	 * </p
	 *
	 * @see ChronoUnit
	 */
	public static long calculateDifference(@NotNull final ChronoUnit chronoUnit,
										   @NotNull final LocalDateTime start,
										   @NotNull final LocalDateTime end) {
		return chronoUnit.between(start, end);
	}

	private DateHelper() {}

}
