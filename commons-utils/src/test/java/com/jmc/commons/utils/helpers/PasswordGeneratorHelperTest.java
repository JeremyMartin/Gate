package com.jmc.commons.utils.helpers;

import com.jmc.commons.utils.AbstractFinalClassHelperTest;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Jeremy MARTIN CATANI
 * @created 09/10/2021
 */
public class PasswordGeneratorHelperTest extends AbstractFinalClassHelperTest {

	@Override
	protected void setClassToTest() {
		CLASS_TO_TEST = PasswordGeneratorHelper.class;
	}

	@Order(value = 1)
	@Test
	public void generateTest() {
		int passwordLength = PasswordGeneratorHelper.MIN_PASSWORD_LENGTH - 1;
		String passwordGenerated = PasswordGeneratorHelper.generate(passwordLength);
		assertTrue(StringUtils.isNotBlank(passwordGenerated), "Password generated must not be null or empty");
		assertEquals(PasswordGeneratorHelper.MIN_PASSWORD_LENGTH, passwordGenerated.length(), "Password generated size must be equals");

		passwordLength = PasswordGeneratorHelper.MAX_PASSWORD_LENGTH + 1;
		passwordGenerated = PasswordGeneratorHelper.generate(passwordLength);
		assertTrue(StringUtils.isNotBlank(passwordGenerated), "Password generated must not be null or empty");
		assertEquals(PasswordGeneratorHelper.MAX_PASSWORD_LENGTH, passwordGenerated.length(), "Password generated size must be equals");
	}

}
