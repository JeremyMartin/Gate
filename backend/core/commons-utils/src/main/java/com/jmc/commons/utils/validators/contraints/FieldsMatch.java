package com.jmc.commons.utils.validators.contraints;

import com.jmc.commons.utils.helpers.MessageHelper;
import com.jmc.commons.utils.validators.FieldsMatchValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * This annotation requires that two elements must be equal
 *
 * @author Jeremy MARTIN CATANI
 * created on 27/10/2021
 */
@Target(value = {
	TYPE
})
@Retention(value = RUNTIME)
@Documented
@Constraint(validatedBy = FieldsMatchValidator.class)
public @interface FieldsMatch {

	String message() default MessageHelper.FIELDS_MUST_MATCH;

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

	String field();

	String fieldMatch();

	String messagePattern() default MessageHelper.FIELDS_INVALID_PATTERN;

	String pattern() default "";

	@Target(value = {
		TYPE
	})
	@Retention(value = RUNTIME)
	@interface List {

		FieldsMatch[] value();

	}

}
