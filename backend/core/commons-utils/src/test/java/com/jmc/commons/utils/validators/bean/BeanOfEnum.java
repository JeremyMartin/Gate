package com.jmc.commons.utils.validators.bean;

import com.jmc.commons.utils.enums.user.Civility;
import com.jmc.commons.utils.helpers.MessageHelper;
import com.jmc.commons.utils.validators.contraints.FieldOfEnum;

/**
 * @author Jeremy MARTIN CATANI
 * created on 27/10/2021
 */
public class BeanOfEnum {

	@FieldOfEnum(enumClass = Civility.class)
	private Civility civility;

	public BeanOfEnum() {
		super();
	}

	public BeanOfEnum(final Civility civility) {
		super();
		this.civility = civility;
	}

	public Civility getCivility() {
		return civility;
	}

}
