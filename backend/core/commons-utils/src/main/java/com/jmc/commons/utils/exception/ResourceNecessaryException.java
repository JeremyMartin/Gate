package com.jmc.commons.utils.exception;

import com.jmc.commons.utils.helpers.MessageHelper;

/**
 * This class consists of throwing necessary element type exception
 *
 * @author Jeremy MARTIN CATANI
 * created on 28/10/2021
 */
public class ResourceNecessaryException extends RuntimeException {

	private final String resource;

	public ResourceNecessaryException(final String resource) {
		super(MessageHelper.RESOURCE_NECESSARY);
		this.resource = resource;
	}

	public String getResource() {
		return resource;
	}

}
