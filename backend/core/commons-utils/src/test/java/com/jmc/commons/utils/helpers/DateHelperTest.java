package com.jmc.commons.utils.helpers;

import com.jmc.commons.utils.test.AbstractFinalClassTest;
import org.apache.commons.lang3.time.DateUtils;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Jeremy MARTIN CATANI
 * created on 27/10/2021
 */
public class DateHelperTest extends AbstractFinalClassTest {

	@Override
	protected void setClassToTest() {
		CLASS_TO_TEST = DateHelper.class;
	}

	@Test
	@Order(value = 1)
	public void convertDate2LocalDateTest() {
		assertNull(DateHelper.convertDate2LocalDate(null), "Result must be null");
		LocalDate result = DateHelper.convertDate2LocalDate(new Date());
		assertNotNull(result, "Result must not be null");
	}

	@Test
	@Order(value = 2)
	public void convertLocalDate2DateTest() {
		assertNull(DateHelper.convertLocalDate2Date(null), "Result must be null");
		Date result = DateHelper.convertLocalDate2Date(LocalDate.now());
		assertNotNull(result, "Result must not be null");
	}

	@Test
	@Order(value = 3)
	public void convertLocalDateTime2DateTest() {
		assertNull(DateHelper.convertLocalDateTime2Date(null), "Result must be null");
		Date result = DateHelper.convertLocalDateTime2Date(LocalDateTime.now());
		assertNotNull(result, "Result must not be null");
	}

	@Test
	@Order(value = 4)
	public void convertDate2LocalDateTimeTest() {
		assertNull(DateHelper.convertDate2LocalDateTime(null), "Result must be null");
		LocalDateTime result = DateHelper.convertDate2LocalDateTime(new Date());
		assertNotNull(result, "Result must not be null");
	}

	@Test
	@Order(value = 5)
	public void calculateDifferenceTest() {
		Date dateStart = new Date();
		Date dateEnd = new Date();
		long diff = DateHelper.calculateDifference(ChronoUnit.DAYS, dateStart, dateEnd);
		assertEquals(0, diff, "Diff must be equals");
		dateEnd = DateUtils.addDays(dateEnd, 1);
		diff = DateHelper.calculateDifference(ChronoUnit.DAYS, dateStart, dateEnd);
		assertEquals(1, diff, "Diff must be equals");
		diff = DateHelper.calculateDifference(ChronoUnit.HOURS, dateStart, dateEnd);
		assertEquals(24, diff, "Diff must be equals");
		LocalDateTime localDateTimeStart = LocalDateTime.now();
		LocalDateTime localDateTimeEnd = LocalDateTime.now();
		diff = DateHelper.calculateDifference(ChronoUnit.DAYS, localDateTimeStart, localDateTimeEnd);
		assertEquals(0, diff, "Diff must be equals");
		localDateTimeEnd = localDateTimeEnd.plusDays(1);
		diff = DateHelper.calculateDifference(ChronoUnit.DAYS, localDateTimeStart, localDateTimeEnd);
		assertEquals(1, diff, "Diff must be equals");
		diff = DateHelper.calculateDifference(ChronoUnit.HOURS, localDateTimeStart, localDateTimeEnd);
		assertEquals(24, diff, "Diff must be equals");
	}

}