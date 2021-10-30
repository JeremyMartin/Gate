package com.jmc.commons.utils.logger;

import com.jmc.commons.utils.test.AbstractUnitTest;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

/**
 * @author Jeremy MARTIN CATANI
 * created on 30/10/2021
 */
public class LogbackCustomColorTest extends AbstractUnitTest {

	@Test
	@Order(value = 1)
	public void getForegroundColorCode(){
		LOG.debug("debug");
		LOG.error("error");
		LOG.info("info");
		LOG.trace("trace");
		LOG.warn("warn");
	}

}
