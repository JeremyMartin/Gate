package com.jmc.commons.utils.exception;

import com.jmc.commons.utils.helpers.MessageHelper;

/**
 * * This class consists of throwing not editable element type exception
 *
 * @author Jeremy MARTIN CATANI
 * created on 28/10/2021
 */
public class ResourceNotEditableException extends RuntimeException {

	private final String resource;
	private final String messageCause;

	public ResourceNotEditableException(final String resource) {
		super(MessageHelper.RESOURCE_NOT_EDITABLE);
		this.resource = resource;
		this.messageCause = null;
	}

	public ResourceNotEditableException(final String resource, final String messageCause) {
		super(MessageHelper.RESOURCE_NOT_EDITABLE);
		this.resource = resource;
		this.messageCause = messageCause;
	}

	public String getResource() {
		return resource;
	}

	public String getMessageCause() {
		return messageCause;
	}

}
