package com.jmc.commons.utils.validators.contraints;

import com.jmc.commons.utils.helpers.MessageHelper;
import com.jmc.commons.utils.validators.FieldOfEnumValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * This annotation requires that the element be a value of an enum
 *
 * @author Jeremy MARTIN CATANI
 * created on 27/10/2021
 */
@Target(value = {
	METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE
})
@Retention(value = RUNTIME)
@Documented
@Constraint(validatedBy = FieldOfEnumValidator.class)
public @interface FieldOfEnum {

	Class<? extends Enum<?>> enumClass();

	String message() default MessageHelper.FIELD_NOT_IN_ENUM;

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}
