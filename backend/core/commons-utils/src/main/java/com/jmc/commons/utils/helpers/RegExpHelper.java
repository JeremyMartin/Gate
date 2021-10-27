package com.jmc.commons.utils.helpers;

/**
 * This class consists of regular expression utilities
 * @author Jeremy MARTIN CATANI
 * created on 27/10/2021
 */
public final class RegExpHelper {

	public static final String EMAIL = "^[\\w!#$%&’*+/=\\-?^_`{|}~]+(\\.[\\w!#$%&’*+/=\\-?^_`{|}~]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z-A-Z]{2,})$";
	public static final String PASSWORD = "((?=.*[a-z])(?=.*\\d)(?=.*[A-Z])(?=.*[\\W]).{10,50})";

	private RegExpHelper() {
	}

}
