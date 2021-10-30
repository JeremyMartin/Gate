package com.jmc.commons.utils.model;

/**
 * This class consists of define success response for whole web application
 *
 * @author Jeremy MARTIN CATANI
 * created on 28/10/2021
 */
public class SimpleResponse {

	private final String message;

	public SimpleResponse(final String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	@Override
	public String toString() {
		final StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("SimpleResponse{")
					 .append("message=")
					 .append(this.message)
					 .append("}");
		return stringBuilder.toString();
	}

}
