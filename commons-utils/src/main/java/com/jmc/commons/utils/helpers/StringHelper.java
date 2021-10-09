package com.jmc.commons.utils.helpers;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.text.WordUtils;

import javax.annotation.Nullable;
import java.util.UUID;

/**
 * @author Jeremy MARTIN CATANI
 * @created 07/10/2021
 */
public class StringHelper {

	public static String capitalize(@Nullable final String value) {
		if (StringUtils.isNotBlank(value)) {
			return WordUtils.capitalize(value.toLowerCase(), ' ', '-', '—', '\'', '`', '.');
		}
		return null;
	}

	public static String generateUUid() {
		return UUID.randomUUID().toString();
	}

	public static String trimStartEnd(@Nullable final String value) {
		String lTrim = StringUtils.stripStart(value, null);
		return StringUtils.stripEnd(lTrim, null);
	}

	private StringHelper() {}

}
