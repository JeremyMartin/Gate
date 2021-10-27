package com.jmc.commons.utils.validators;

import com.jmc.commons.utils.validators.contraints.FieldsMatch;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.BeanWrapperImpl;

import java.util.regex.Pattern;

/**
 * This class consists of defining the logic to validate a given two fields constraints
 *
 * @author Jeremy MARTIN CATANI
 * created on 27/10/2021
 */
public class FieldsMatchValidator implements ConstraintValidator<FieldsMatch, Object> {

	private String field;
	private String fieldMatch;
	private String message;
	private String messagePattern;
	private String pattern;

	@Override
	public void initialize(final FieldsMatch annotation) {
		this.field = annotation.field();
		this.fieldMatch = annotation.fieldMatch();
		this.message = annotation.message();
		this.messagePattern = annotation.messagePattern();
		this.pattern = annotation.pattern();
	}

	@Override
	public boolean isValid(final Object value, final ConstraintValidatorContext context) {
		boolean isValid;
		Object fieldValue = new BeanWrapperImpl(value).getPropertyValue(this.field);
		Object fieldMatchValue = new BeanWrapperImpl(value).getPropertyValue(this.fieldMatch);
		if (fieldValue != null) {
			isValid = fieldValue.equals(fieldMatchValue);
		} else {
			isValid = fieldMatchValue == null;
		}
		if (!isValid) {
			context.buildConstraintViolationWithTemplate(this.message)
				   .addConstraintViolation()
				   .disableDefaultConstraintViolation();
		}
		if (!"".equals(this.pattern) && isValid) {
			if (fieldValue instanceof String) {
				isValid = Pattern.matches(this.pattern, (String) fieldValue);
				if (!isValid) {
					context.buildConstraintViolationWithTemplate(this.messagePattern)
						   .addConstraintViolation()
						   .disableDefaultConstraintViolation();
				}
			}
		}
		return isValid;
	}

}
