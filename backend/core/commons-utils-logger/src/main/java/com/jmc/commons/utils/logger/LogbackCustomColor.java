package com.jmc.commons.utils.logger;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.pattern.color.ForegroundCompositeConverterBase;

/**
 * This class consists of define severity color in logback console appender
 *
 * @author Jeremy MARTIN CATANI
 * created on 26/10/2021
 * @see ch.qos.logback.core.pattern.color.ANSIConstants
 */
public class LogbackCustomColor extends ForegroundCompositeConverterBase<ILoggingEvent> {

	@Override
	protected String getForegroundColorCode(final ILoggingEvent event) {
		return switch (event.getLevel()
							.toInt()) {
			case Level.DEBUG_INT -> "38;5;11"; // Yellow
			case Level.ERROR_INT -> "38;5;9"; // Red
			case Level.INFO_INT -> "38;5;10"; // Green
			case Level.WARN_INT -> "38;5;166"; // Orange
			default -> "38;5;7"; // Gray
		};
	}

}
