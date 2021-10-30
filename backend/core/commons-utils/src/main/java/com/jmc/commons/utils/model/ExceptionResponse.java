package com.jmc.commons.utils.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;

/**
 * This class consists of define error response for whole web application
 *
 * @author Jeremy MARTIN CATANI
 * created on 28/10/2021
 */
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class ExceptionResponse {

	private final Date timestamp = new Date();
	private final String message;
	private final String path;
	private final Object expected;
	private final Object found;

	public ExceptionResponse(final String message, final String path) {
		super();
		this.message = message;
		this.path = path;
		this.expected = null;
		this.found = null;
	}

	public ExceptionResponse(final String message, final String path, final Object expected) {
		super();
		this.message = message;
		this.path = path;
		this.expected = expected;
		this.found = null;
	}

	public ExceptionResponse(final String message, final String path, final Object expected, final Object found) {
		super();
		this.message = message;
		this.path = path;
		this.expected = expected;
		this.found = found;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public String getMessage() {
		return message;
	}

	public String getPath() {
		return path;
	}

	public Object getExpected() {
		return expected;
	}

	public Object getFound() {
		return found;
	}

	@Override
	public String toString() {
		final StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("ExceptionResponse{")
					 .append("timestamp=")
					 .append(this.timestamp)
					 .append(", message=")
					 .append(this.message)
					 .append(", path=")
					 .append(this.path)
					 .append(", expected=")
					 .append(this.expected)
					 .append(", found=")
					 .append(this.found)
					 .append("}");
		return stringBuilder.toString();
	}

}
