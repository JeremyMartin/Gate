package com.jmc.commons.utils.helpers.password;

import com.jmc.commons.utils.helpers.regexp.RegExpHelper;

import java.security.SecureRandom;
import java.util.Random;
import java.util.regex.Pattern;

/**
 * This class consists of static utility for generate password
 *
 * @author Jeremy MARTIN CATANI
 * @created 07/10/2021
 */
public final class PasswordGeneratorHelper {

	public static final int MIN_PASSWORD_LENGTH = 10;
	public static final int MAX_PASSWORD_LENGTH = 50;

	private static final String CHAR_LOWER = "abcdefghijklmnopqrstuvwxyz";
	private static final String CHAR_UPPER = CHAR_LOWER.toUpperCase();
	private static final String NUMBER = "0123456789";
	private static final String OTHER_CHAR = "!@#$%&*()_+-=[]?";
	private static final String PASSWORD_ALLOW_BASE = CHAR_LOWER + CHAR_UPPER + NUMBER + OTHER_CHAR;
	private static final Pattern PATTERN_PASSWORD = Pattern.compile(RegExpHelper.PASSWORD);
	private static final Random RANDOM = new SecureRandom();

	private PasswordGeneratorHelper() {}

	/**
	 * Password generator
	 *
	 * @param passwordLength length of the generated password
	 * <p>
	 * if passwordLength < MIN_PASSWORD_LENGTH ? passwordLength = MIN_PASSWORD_LENGTH
	 * if passwordLength > MAX_PASSWORD_LENGTH ? passwordLength = MAX_PASSWORD_LENGTH
	 * </p>
	 *
	 * @return generated password
	 */
	public static String generate(final int passwordLength) {
		int length = passwordLength;
		if (length < MIN_PASSWORD_LENGTH) {
			length = MIN_PASSWORD_LENGTH;
		}
		if (length > MAX_PASSWORD_LENGTH) {
			length = MAX_PASSWORD_LENGTH;
		}
		String generatedPassword = null;
		boolean isOk = Boolean.FALSE;
		while (isOk != Boolean.TRUE) {
			StringBuilder stringBuilder = new StringBuilder(length);
			for (int i = 0; i < length; i++) {
				stringBuilder.append(PASSWORD_ALLOW_BASE.charAt(RANDOM.nextInt(PASSWORD_ALLOW_BASE.length())));
			}
			if (PATTERN_PASSWORD.matcher(stringBuilder.toString()).matches()) {
				isOk = Boolean.TRUE;
				generatedPassword = stringBuilder.toString();
			}
		}
		return generatedPassword;
	}

}
