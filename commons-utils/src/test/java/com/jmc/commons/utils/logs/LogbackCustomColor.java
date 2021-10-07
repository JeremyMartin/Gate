package com.jmc.commons.utils.logs;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.pattern.color.ForegroundCompositeConverterBase;
import org.springframework.boot.ansi.Ansi8BitColor;

/**
 * @author Jeremy MARTIN CATANI
 * @created 08/10/2021
 */
public class LogbackCustomColor extends ForegroundCompositeConverterBase<ILoggingEvent> {

	@Override
	protected String getForegroundColorCode(final ILoggingEvent event) {
		return switch (event.getLevel().toInt()) {
			case Level.ERROR_INT -> Ansi8BitColor.foreground(9).toString(); // Red
			case Level.WARN_INT -> Ansi8BitColor.foreground(166).toString(); // Orange
			case Level.INFO_INT -> Ansi8BitColor.foreground(10).toString(); // Green
			case Level.DEBUG_INT -> Ansi8BitColor.foreground(7).toString(); // Grey
			default -> Ansi8BitColor.foreground(15).toString(); // White
		};
	}

}
