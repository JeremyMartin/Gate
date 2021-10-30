package com.jmc.commons.utils.exception;

import com.jmc.commons.utils.helpers.MessageHelper;

/**
 * This class consists of throwing not found element type exception
 *
 * @author Jeremy MARTIN CATANI
 * created on 28/10/2021
 */
public class ResourceNotFoundException extends RuntimeException {

	private final String resource;
	private final String name;
	private final Object value;

	public ResourceNotFoundException(final String resource, final String name, final Object value) {
		super(MessageHelper.RESOURCE_NOT_FOUND);
		this.resource = resource;
		this.name = name;
		this.value = value;
	}

	public String getResource() {
		return resource;
	}

	public String getName() {
		return name;
	}

	public Object getValue() {
		return value;
	}

}
