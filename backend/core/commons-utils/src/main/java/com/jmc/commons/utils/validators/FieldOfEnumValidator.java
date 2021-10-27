package com.jmc.commons.utils.validators;

import com.jmc.commons.utils.validators.contraints.FieldOfEnum;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * This class consists in defining the logic to validate the value of a given field either in the defined enumeration
 * @author Jeremy MARTIN CATANI
 * created on 27/10/2021
 */
public class FieldOfEnumValidator implements ConstraintValidator<FieldOfEnum, Enum<?>> {

	private List<String> acceptedValues;
	private String message;

	@Override
	public void initialize(final FieldOfEnum annotation) {
		this.acceptedValues = Stream.of(annotation.enumClass().getEnumConstants())
									.map(Enum::name)
									.collect(Collectors.toList());
		this.message = annotation.message();
	}

	@Override
	public boolean isValid(final Enum<?> value, final ConstraintValidatorContext context) {
		boolean isValid;
		if (value == null) {
			isValid = false;
		} else {
			isValid = this.acceptedValues.contains(value.name());
		}
		if (!isValid) {
			context.buildConstraintViolationWithTemplate(this.message)
				   .addConstraintViolation()
				   .disableDefaultConstraintViolation();
		}
		return isValid;
	}}
