package com.jmc.commons.utils.exception;

import com.jmc.commons.utils.helpers.MessageHelper;

/**
 * This class consists of throwing incompatible element type exception
 *
 * @author Jeremy MARTIN CATANI
 * created on 28/10/2021
 */
public class ResourceIncompatibleException extends RuntimeException {

	private final String resource;
	private final Object value;

	public ResourceIncompatibleException(final String resource, final Object value) {
		super(MessageHelper.RESOURCE_INCOMPATIBLE);
		this.resource = resource;
		this.value = value;
	}

	public String getResource() {
		return resource;
	}

	public Object getValue() {
		return value;
	}

}
