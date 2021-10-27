package com.jmc.commons.utils.validators;

import com.jmc.commons.utils.helpers.MessageHelper;
import com.jmc.commons.utils.test.AbstractValidatorTest;
import com.jmc.commons.utils.validators.bean.BeanFieldsMatch;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.util.Collections;

/**
 * @author Jeremy MARTIN CATANI
 * created on 27/10/2021
 */
public class FieldsMatchValidatorTest extends AbstractValidatorTest<BeanFieldsMatch> {

	private final String EMPTY = "";
	private final String TEST = "test";
	private final BeanFieldsMatch BEAN_FAILED_FIRST_FILED = new BeanFieldsMatch(null, TEST);
	private final BeanFieldsMatch BEAN_FAILED_SECOND_FILED = new BeanFieldsMatch(TEST);
	private final BeanFieldsMatch BEAN_FAILED_NOT_EQUALS = new BeanFieldsMatch(TEST, EMPTY);
	private final BeanFieldsMatch BEAN_FAILED_EMPTY_NULL = new BeanFieldsMatch(EMPTY, null);
	private final BeanFieldsMatch BEAN_FAILED_EMPTY = new BeanFieldsMatch(EMPTY, EMPTY);
	private final BeanFieldsMatch BEAN_VALID_EMPTY = new BeanFieldsMatch();
	private final BeanFieldsMatch BEAN_VALID = new BeanFieldsMatch(TEST, TEST);


	@Test
	@Order(value = 1)
	public void invalidTest() {
		assertErrors(BEAN_FAILED_FIRST_FILED, 1, Collections.singletonList(MessageHelper.FIELDS_MUST_MATCH));
		assertErrors(BEAN_FAILED_SECOND_FILED, 1, Collections.singletonList(MessageHelper.FIELDS_MUST_MATCH));
		assertErrors(BEAN_FAILED_NOT_EQUALS, 1, Collections.singletonList(MessageHelper.FIELDS_MUST_MATCH));
		assertErrors(BEAN_FAILED_EMPTY_NULL, 1, Collections.singletonList(MessageHelper.FIELDS_MUST_MATCH));
		assertErrors(BEAN_FAILED_EMPTY, 1, Collections.singletonList(MessageHelper.FIELDS_INVALID_PATTERN));
	}

	@Test
	@Order(value = 2)
	public void validTest() {
		assertValid(BEAN_VALID_EMPTY);
		assertValid(BEAN_VALID);
	}

}