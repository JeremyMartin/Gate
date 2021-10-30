package com.jmc.commons.utils.exception;

/**
 * This class consists of throwing mail type exception
 *
 * @author Jeremy MARTIN CATANI
 * created on 28/10/2021
 */
public class MailException extends RuntimeException {

	public MailException(final String message) {
		super(message);
	}

}
