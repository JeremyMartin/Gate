package com.jmc.commons.utils.test;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This abstract class provides method utilities for class validation defined in parameter
 *
 * @author Jeremy MARTIN CATANI
 * created on 26/10/2021
 */
public abstract class AbstractValidatorTest<T> extends AbstractUnitTest {

	protected Validator validator;

	@Override
	@BeforeEach
	public void beforeEach(final TestInfo testInfo) {
		super.beforeEach(testInfo);
		this.validator = Validation.buildDefaultValidatorFactory()
								   .getValidator();
		assertNotNull(this.validator, "Validator must not be null");
	}

	protected void assertErrors(final T bean, final int numberError, final List<String> messageError) {
		Set<ConstraintViolation<T>> violations = this.validator.validate(bean);
		assertTrue(CollectionUtils.isNotEmpty(violations), "Violations must not be empty");
		assertEquals(numberError, violations.size(), "Violations size must be equal to " + numberError);
		List<String> messages = violations.stream()
										  .map(ConstraintViolation::getMessage)
										  .collect(Collectors.toList());
		assertTrue(messages.containsAll(messageError), "Message must be contains " + messageError);
	}

	protected void assertValid(final T bean) {
		Set<ConstraintViolation<T>> violations = this.validator.validate(bean);
		assertTrue(CollectionUtils.isEmpty(violations), "Violations must be empty");
		assertEquals(0, violations.size(), "Violations size must be equal to 0");
	}

}
