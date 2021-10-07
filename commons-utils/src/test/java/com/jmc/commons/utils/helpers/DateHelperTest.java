package com.jmc.commons.utils.helpers;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Jeremy MARTIN CATANI
 * @created 08/10/2021
 */
public class DateHelperTest extends AbstractFinalClassHelperTest {

	@Override
	protected void setClassToTest() {
		CLASS_TO_TEST = DateHelper.class;
	}

	@Order(value = 1)
	@Test
	public void convertDate2LocalDateTest() {
		assertNull(DateHelper.convertDate2LocalDate(null), "Result must be null");
		LocalDate result = DateHelper.convertDate2LocalDate(new Date());
		assertNotNull(result, "Result must not be null");
	}

	@Order(value = 2)
	@Test
	public void convertLocalDate2DateTest() {
		assertNull(DateHelper.convertLocalDate2Date(null), "Result must be null");
		Date result = DateHelper.convertLocalDate2Date(LocalDate.now());
		assertNotNull(result, "Result must not be null");
	}

	@Order(value = 3)
	@Test
	public void convertLocalDateTime2DateTest() {
		assertNull(DateHelper.convertLocalDateTime2Date(null), "Result must be null");
		Date result = DateHelper.convertLocalDateTime2Date(LocalDateTime.now());
		assertNotNull(result, "Result must not be null");
	}

	@Order(value = 4)
	@Test
	public void convertDate2LocalDateTimeTest() {
		assertNull(DateHelper.convertDate2LocalDateTime(null), "Result must be null");
		LocalDateTime result = DateHelper.convertDate2LocalDateTime(new Date());
		assertNotNull(result, "Result must not be null");
	}

	@Order(value = 5)
	@Test
	public void calculateDifferenceDateTest() {
		Date start = new Date();
		Date end = new Date();
		long diff = DateHelper.calculateDifference(start, end);
		assertEquals(0, diff, "Diff must be equals");
	}

	@Order(value = 6)
	@Test
	public void calculateDifferenceLocalDateTest() {
		LocalDate start = LocalDate.now();
		LocalDate end = LocalDate.now();
		long diff = DateHelper.calculateDifference(start, end);
		assertEquals(0, diff, "Diff must be equals");
		end = end.plusDays(1);
		diff = DateHelper.calculateDifference(start, end);
		assertEquals(1, diff, "Diff must be equals");
	}

	@Order(value = 7)
	@Test
	public void calculateDifferenceTest() {
		LocalDateTime start = LocalDateTime.now();
		LocalDateTime end = LocalDateTime.now();
		long diff = DateHelper.calculateDifference(ChronoUnit.DAYS, start, end);
		assertEquals(0, diff, "Diff must be equals");
		end = end.plusDays(1);
		diff = DateHelper.calculateDifference(ChronoUnit.DAYS, start, end);
		assertEquals(1, diff, "Diff must be equals");
		diff = DateHelper.calculateDifference(ChronoUnit.HOURS, start, end);
		assertEquals(24, diff, "Diff must be equals");
	}

}