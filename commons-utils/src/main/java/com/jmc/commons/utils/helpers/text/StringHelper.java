package com.jmc.commons.utils.helpers.text;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.text.WordUtils;

import javax.annotation.Nullable;
import java.util.UUID;

/**
 * This class consists of static utility methods for converting string
 *
 * @author Jeremy MARTIN CATANI
 * @created 07/10/2021
 */
public class StringHelper {

	/**
	 * Capitalizes all the delimiter separated words in a String. Only the first character of each word is changed.
	 *
	 * @param value the value to capitalize, nullable
	 * <p>
	 * delimiters ' ', '-', '—', '\'', '`', '.'
	 * </p>
	 *
	 * @return the capitalized argument for a non-null argument and null for a null argument
	 *
	 * @see WordUtils
	 */
	public static String capitalize(@Nullable final String value) {
		if (StringUtils.isNotBlank(value)) {
			return WordUtils.capitalize(value.toLowerCase(), ' ', '-', '—', '\'', '`', '.');
		}
		return null;
	}

	/**
	 * Generate new uuid string
	 *
	 * @return generated uuid
	 *
	 * @see UUID
	 */
	public static String generateUUid() {
		return UUID.randomUUID().toString();
	}

	/**
	 * Strips any of a set of characters from the start and end of a String.
	 *
	 * @param value value to trimmed, nullable
	 *
	 * @return the stripped argument for a non-null argument and null for a null argument
	 */
	public static String trimStartEnd(@Nullable final String value) {
		String lTrim = StringUtils.stripStart(value, null);
		return StringUtils.stripEnd(lTrim, null);
	}

	private StringHelper() {}

}
