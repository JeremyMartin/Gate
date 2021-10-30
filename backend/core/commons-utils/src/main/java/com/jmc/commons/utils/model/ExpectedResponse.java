package com.jmc.commons.utils.model;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * This class consists of define expected response for error response whole web application
 *
 * @author Jeremy MARTIN CATANI
 * created on 28/10/2021
 */
public class ExpectedResponse {

	@JsonInclude(value = JsonInclude.Include.NON_NULL)
	private final String resource;
	@JsonInclude(value = JsonInclude.Include.NON_NULL)
	private final String field;
	private final Object value;
	@JsonInclude(value = JsonInclude.Include.NON_NULL)
	private final String message;

	public ExpectedResponse(final String field, final Object value) {
		this.resource = null;
		this.field = field;
		this.value = value;
		this.message = null;
	}

	public ExpectedResponse(final String resourceOrElement, final boolean isResource, final Object value) {
		if (isResource) {
			this.resource = resourceOrElement;
			this.field = null;
		} else {
			this.resource = null;
			this.field = resourceOrElement;
		}
		this.value = value;
		this.message = null;
	}

	public ExpectedResponse(final String resource, final String field, final Object value, final String message) {
		this.resource = resource;
		this.field = field;
		this.value = value;
		this.message = message;
	}

	public String getResource() {
		return resource;
	}

	public String getField() {
		return field;
	}

	public Object getValue() {
		return value;
	}

	public String getMessage() {
		return message;
	}

	@Override
	public String toString() {
		final StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("ExpectedResponse{")
					 .append("resource=")
					 .append(this.resource)
					 .append(", field=")
					 .append(this.field)
					 .append(", value=")
					 .append(this.value)
					 .append(", message=")
					 .append(this.message)
					 .append("}");
		return stringBuilder.toString();
	}

}
