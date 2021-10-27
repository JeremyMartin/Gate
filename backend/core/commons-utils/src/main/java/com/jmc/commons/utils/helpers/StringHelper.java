package com.jmc.commons.utils.helpers;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.text.WordUtils;

import javax.annotation.Nullable;
import java.util.UUID;

/**
 * This class consists of string utilities
 * @author Jeremy MARTIN CATANI
 * created on 27/10/2021
 */
public final class StringHelper {

	/**
	 * Capitalizes String. Only the first character by delimiters.
	 *
	 * @param value the String to capitalize, may be null
	 *
	 * @return capitalized String, {@code null} if null input
	 *
	 * @see org.apache.commons.text.WordUtils
	 */
	public static String capitalize(@Nullable final String value) {
		if (StringUtils.isBlank(value)) {
			return value;
		}
		return WordUtils.capitalize(value.toLowerCase(), ' ', '-', '—', '\'', '`', '.');
	}

	/**
	 * Generate a new uuid as string
	 *
	 * @return A randomly generated {@code UUID}
	 *
	 * @see UUID
	 */
	public static String generateUUid() {
		return UUID.randomUUID().toString();
	}

	/**
	 * Strips any of a set of characters from the start and end of a String.
	 *
	 * @param value the String to remove characters from, may be null
	 *
	 * @return the stripped String, {@code null} if null input
	 */
	public static String trimStartEnd(@Nullable final String value) {
		return StringUtils.stripEnd(StringUtils.stripStart(value, null), null);
	}

	private StringHelper() {}

}
