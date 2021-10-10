package com.jmc.commons.utils.exceptions;

/**
 * @author Jeremy MARTIN CATANI
 * @created 10/10/2021
 */
public class FileException extends RuntimeException {

	private final String source;
	private String destination;

	public FileException(final String message, final String source) {
		super(message);
		this.source = source;
	}

	public FileException(final String message, final String source, final String destination) {
		super(message);
		this.source = source;
		this.destination = destination;
	}

	public String getSource() {
		return source;
	}

	public String getDestination() {
		return destination;
	}

}
