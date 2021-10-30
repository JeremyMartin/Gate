package com.jmc.commons.utils.exception;

/**
 * This class consists of throwing an exception
 *
 * @author Jeremy MARTIN CATANI
 * created on 28/10/2021
 */
public class MessageException extends RuntimeException {

	private final String field;
	private final Object value;

	public MessageException(final String message, final String field, final Object value) {
		super(message);
		this.field = field;
		this.value = value;
	}

	public String getField() {
		return field;
	}

	public Object getValue() {
		return value;
	}

}
