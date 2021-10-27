package com.jmc.commons.utils.validators.bean;

import com.jmc.commons.utils.validators.contraints.FieldsMatch;

/**
 * @author Jeremy MARTIN CATANI
 * created on 27/10/2021
 */
@FieldsMatch(field = "first",
			 fieldMatch = "second",
			 pattern = "\\w+")
public class BeanFieldsMatch {

	private String first;
	private String second;

	public BeanFieldsMatch() {
		super();
	}

	public BeanFieldsMatch(final String first) {
		super();
		this.first = first;
	}

	public BeanFieldsMatch(final String first, final String second) {
		super();
		this.first = first;
		this.second = second;
	}

	public String getFirst() {
		return first;
	}

	public String getSecond() {
		return second;
	}

}
