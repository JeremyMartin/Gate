package com.jmc.commons.utils.exception;

/**
 * This class consists of throwing file type exception
 *
 * @author Jeremy MARTIN CATANI
 * created on 28/10/2021
 */
public class FileException extends RuntimeException {

	private final Object source;
	private Object destination;

	public FileException(final String message, final Object source) {
		super(message);
		this.source = source;
	}

	public FileException(final String message, final Object source, final Object destination) {
		super(message);
		this.source = source;
		this.destination = destination;
	}

	public Object getSource() {
		return source;
	}

	public Object getDestination() {
		return destination;
	}

}
