package com.jmc.commons.utils.validators;

import com.jmc.commons.utils.helpers.MessageHelper;
import com.jmc.commons.utils.test.AbstractValidatorTest;
import com.jmc.commons.utils.validators.bean.BeanFieldsMatchWithPattern;
import com.jmc.commons.utils.validators.bean.BeanFieldsMatchWithoutPattern;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.util.Collections;

/**
 * @author Jeremy MARTIN CATANI
 * created on 27/10/2021
 */
public class FieldsMatchValidatorTest extends AbstractValidatorTest<Object> {

	private final String EMPTY = "";
	private final String TEST = "test";
	private final BeanFieldsMatchWithPattern BEAN_FAILED_FIRST_FILED_WITH_PATTERN = new BeanFieldsMatchWithPattern(null, TEST);
	private final BeanFieldsMatchWithoutPattern BEAN_FAILED_FIRST_FILED_WITHOUT_PATTERN = new BeanFieldsMatchWithoutPattern(null, TEST);
	private final BeanFieldsMatchWithPattern BEAN_FAILED_SECOND_FILED_WITH_PATTERN = new BeanFieldsMatchWithPattern(TEST);
	private final BeanFieldsMatchWithoutPattern BEAN_FAILED_SECOND_FILED_WITHOUT_PATTERN = new BeanFieldsMatchWithoutPattern(TEST);
	private final BeanFieldsMatchWithPattern BEAN_FAILED_NOT_EQUALS_WITH_PATTERN = new BeanFieldsMatchWithPattern(TEST, EMPTY);
	private final BeanFieldsMatchWithoutPattern BEAN_FAILED_NOT_EQUALS_WITHOUT_PATTERN = new BeanFieldsMatchWithoutPattern(TEST, EMPTY);
	private final BeanFieldsMatchWithPattern BEAN_FAILED_EMPTY_NULL_WITH_PATTERN = new BeanFieldsMatchWithPattern(EMPTY, null);
	private final BeanFieldsMatchWithoutPattern BEAN_FAILED_EMPTY_NULL_WITHOUT_PATTERN = new BeanFieldsMatchWithoutPattern(EMPTY, null);
	private final BeanFieldsMatchWithPattern BEAN_FAILED_EMPTY_WITH_PATTERN = new BeanFieldsMatchWithPattern(EMPTY, EMPTY);
	private final BeanFieldsMatchWithPattern BEAN_VALID_EMPTY_WITH_PATTERN = new BeanFieldsMatchWithPattern();
	private final BeanFieldsMatchWithoutPattern BEAN_VALID_EMPTY_WITHOUT_PATTERN = new BeanFieldsMatchWithoutPattern();
	private final BeanFieldsMatchWithPattern BEAN_VALID_WITH_PATTERN = new BeanFieldsMatchWithPattern(TEST, TEST);
	private final BeanFieldsMatchWithoutPattern BEAN_VALID_WITHOUT_PATTERN = new BeanFieldsMatchWithoutPattern(TEST, TEST);
	private final BeanFieldsMatchWithoutPattern BEAN_VALID_EMPTY_FULL_WITHOUT_PATTERN = new BeanFieldsMatchWithoutPattern(EMPTY, EMPTY);


	@Test
	@Order(value = 1)
	public void invalidTest() {
		assertErrors(BEAN_FAILED_FIRST_FILED_WITH_PATTERN, 1, Collections.singletonList(MessageHelper.FIELDS_MUST_MATCH));
		assertErrors(BEAN_FAILED_FIRST_FILED_WITHOUT_PATTERN, 1, Collections.singletonList(MessageHelper.FIELDS_MUST_MATCH));
		assertErrors(BEAN_FAILED_SECOND_FILED_WITH_PATTERN, 1, Collections.singletonList(MessageHelper.FIELDS_MUST_MATCH));
		assertErrors(BEAN_FAILED_SECOND_FILED_WITHOUT_PATTERN, 1, Collections.singletonList(MessageHelper.FIELDS_MUST_MATCH));
		assertErrors(BEAN_FAILED_NOT_EQUALS_WITH_PATTERN, 1, Collections.singletonList(MessageHelper.FIELDS_MUST_MATCH));
		assertErrors(BEAN_FAILED_NOT_EQUALS_WITHOUT_PATTERN, 1, Collections.singletonList(MessageHelper.FIELDS_MUST_MATCH));
		assertErrors(BEAN_FAILED_EMPTY_NULL_WITH_PATTERN, 1, Collections.singletonList(MessageHelper.FIELDS_MUST_MATCH));
		assertErrors(BEAN_FAILED_EMPTY_NULL_WITHOUT_PATTERN, 1, Collections.singletonList(MessageHelper.FIELDS_MUST_MATCH));
		assertErrors(BEAN_FAILED_EMPTY_WITH_PATTERN, 1, Collections.singletonList(MessageHelper.FIELDS_INVALID_PATTERN));
	}

	@Test
	@Order(value = 2)
	public void validTest() {
		assertValid(BEAN_VALID_EMPTY_WITH_PATTERN);
		assertValid(BEAN_VALID_EMPTY_WITHOUT_PATTERN);
		assertValid(BEAN_VALID_WITH_PATTERN);
		assertValid(BEAN_VALID_WITHOUT_PATTERN);
		assertValid(BEAN_VALID_EMPTY_FULL_WITHOUT_PATTERN);
	}

}