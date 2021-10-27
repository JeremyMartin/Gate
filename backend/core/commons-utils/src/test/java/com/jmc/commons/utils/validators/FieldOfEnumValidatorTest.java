package com.jmc.commons.utils.validators;

import com.jmc.commons.utils.enums.user.Civility;
import com.jmc.commons.utils.helpers.MessageHelper;
import com.jmc.commons.utils.test.AbstractValidatorTest;
import com.jmc.commons.utils.validators.bean.BeanOfEnum;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.util.Collections;

/**
 * @author Jeremy MARTIN CATANI
 * created on 27/10/2021
 */
public class FieldOfEnumValidatorTest extends AbstractValidatorTest<BeanOfEnum> {

	private final BeanOfEnum BEAN_FAILED = new BeanOfEnum();
	private final BeanOfEnum BEAN_VALID = new BeanOfEnum(Civility.OTH);

	@Test
	@Order(value = 1)
	public void invalidTest() {
		assertErrors(BEAN_FAILED, 1, Collections.singletonList(MessageHelper.FIELD_NOT_IN_ENUM));
	}

	@Test
	@Order(value = 2)
	public void validTest() {
		assertValid(BEAN_VALID);
	}

}