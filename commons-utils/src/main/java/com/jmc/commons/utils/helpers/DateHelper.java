package com.jmc.commons.utils.helpers;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;

/**
 * @author Jeremy MARTIN CATANI
 * @created 07/10/2021
 */
public final class DateHelper {

	private static final ZoneId ZONE_ID = ZoneId.systemDefault();

	public static LocalDate convertDate2LocalDate(@Nullable final Date date) {
		if (date != null) {
			return Instant.ofEpochMilli(date.getTime()).atZone(ZONE_ID).toLocalDate();
		}
		return null;
	}

	public static Date convertLocalDate2Date(@Nullable final LocalDate localDate) {
		if (localDate != null) {
			return Date.from(localDate.atStartOfDay().atZone(ZONE_ID).toInstant());
		}
		return null;
	}

	public static Date convertLocalDateTime2Date(@Nullable final LocalDateTime localDateTime) {
		if (localDateTime != null) {
			return convertLocalDate2Date(localDateTime.toLocalDate());
		}
		return null;
	}

	public static LocalDateTime convertDate2LocalDateTime(@Nullable final Date date) {
		if (date != null) {
			return Instant.ofEpochMilli(date.getTime()).atZone(ZONE_ID).toLocalDateTime();
		}
		return null;
	}

	public static long calculateDifference(@Nonnull final Date start, @Nonnull final Date end) {
		return ChronoUnit.DAYS.between(Instant.ofEpochMilli(start.getTime()), Instant.ofEpochMilli(end.getTime()));
	}

	public static long calculateDifference(@Nonnull final LocalDate start, @Nonnull final LocalDate end) {
		return calculateDifference(convertLocalDate2Date(start), convertLocalDate2Date(end));
	}

	public static long calculateDifference(@Nonnull final ChronoUnit chronoUnit,
										   @Nonnull final LocalDateTime start,
										   @Nonnull final LocalDateTime end) {
		return chronoUnit.between(start, end);
	}

	private DateHelper() {}

}
