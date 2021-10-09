package com.jmc.commons.utils.helpers;

/**
 * @author Jeremy MARTIN CATANI
 * @created 07/10/2021
 */
public class RegExpHelper {

	public static final String EMAIL = "^[\\w!#$%&’*+/=\\-?^_`{|}~]+(\\.[\\w!#$%&’*+/=\\-?^_`{|}~]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z-A-Z]{2,})$";
	public static final String PASSWORD = "((?=.*[a-z])(?=.*\\d)(?=.*[A-Z])(?=.*[\\W]).{6,255})";

	private RegExpHelper() {}

}
