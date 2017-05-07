package org.jfree.test;

import java.util.GregorianCalendar;

import junit.framework.TestCase;

import org.jfree.date.DateUtil;
import org.jfree.date.Day;
import org.jfree.date.DayDateFactory;
import org.jfree.date.Month;
import org.jfree.date.MonthConstants;
import org.jfree.date.SerialDate;
import org.jfree.date.SpreadsheetDate;
import org.jfree.date.WeekInMonth;
import org.jfree.date.Weekday;

public class BobsSerialDateTest extends TestCase implements MonthConstants {
	
	/*public void testIsValidWeekdayCode() throws Exception {
		for (int day = 1; day <= 7; day++) {
			assertTrue(isValidWeekdayCode(day));
		}
		assertFalse(isValidWeekdayCode(0));
		assertFalse(isValidWeekdayCode(8));
	}*/

	public void testStringToWeekdayCode() throws Exception {

		//assertEquals(-1, Day.parse("Hello"));
		assertEquals(Day.MONDAY, Day.parse("Monday"));
		assertEquals(Day.MONDAY, Day.parse("Mon"));
		// todo 
		assertEquals(Day.MONDAY, Day.parse("monday"));
		assertEquals(Day.MONDAY, Day.parse("MONDAY"));
		assertEquals(Day.MONDAY, Day.parse("mon"));

		assertEquals(Day.TUESDAY, Day.parse("Tuesday"));
		assertEquals(Day.TUESDAY, Day.parse("Tue"));
		// assertEquals(Day.TUESDAY, Day.parse("tuesday"));
		// assertEquals(Day.TUESDAY, Day.parse("TUESDAY"));
		// assertEquals(Day.TUESDAY, Day.parse("tue"));
		// assertEquals(Day.TUESDAY, Day.parse("tues"));

		assertEquals(Day.WEDNESDAY, Day.parse("Wednesday"));
		assertEquals(Day.WEDNESDAY, Day.parse("Wed"));
		// assertEquals(Day.WEDNESDAY, Day.parse("wednesday"));
		// assertEquals(Day.WEDNESDAY, Day.parse("WEDNESDAY"));
		// assertEquals(Day.WEDNESDAY, Day.parse("wed"));

		assertEquals(Day.THURSDAY, Day.parse("Thursday"));
		assertEquals(Day.THURSDAY, Day.parse("Thu"));
		// assertEquals(Day.THURSDAY, Day.parse("thursday"));
		// assertEquals(Day.THURSDAY, Day.parse("THURSDAY"));
		// assertEquals(Day.THURSDAY, Day.parse("thu"));
		// assertEquals(Day.THURSDAY, Day.parse("thurs"));

		assertEquals(Day.FRIDAY, Day.parse("Friday"));
		assertEquals(Day.FRIDAY, Day.parse("Fri"));
		// assertEquals(Day.FRIDAY,Day.parse("friday"));
		// assertEquals(Day.FRIDAY,Day.parse("FRIDAY"));
		// assertEquals(Day.FRIDAY, Day.parse("fri"));

		assertEquals(Day.SATURDAY, Day.parse("Saturday"));
		assertEquals(Day.SATURDAY, Day.parse("Sat"));
		// assertEquals(Day.SATURDAY,Day.parse("saturday"));
		// assertEquals(Day.SATURDAY,Day.parse("SATURDAY"));
		// assertEquals(Day.SATURDAY, Day.parse("sat"));

		assertEquals(Day.SUNDAY, Day.parse("Sunday"));
		assertEquals(Day.SUNDAY, Day.parse("Sun"));
		// assertEquals(Day.SUNDAY,Day.parse("sunday"));
		// assertEquals(Day.SUNDAY,Day.parse("SUNDAY"));
		// assertEquals(Weekday.SUNDAY, Day.parse("sun"));
	}

	public void testWeekdayCodeToString() throws Exception {
		assertEquals("Sunday", DateUtil.weekdayCodeToString(Weekday.SUNDAY.getIndex()));
		assertEquals("Monday", DateUtil.weekdayCodeToString(Weekday.MONDAY.getIndex()));
		assertEquals("Tuesday", DateUtil.weekdayCodeToString(Weekday.TUESDAY.getIndex()));
		assertEquals("Wednesday", DateUtil.weekdayCodeToString(Weekday.WEDNESDAY.getIndex()));
		assertEquals("Thursday", DateUtil.weekdayCodeToString(Weekday.THURSDAY.getIndex()));
		assertEquals("Friday", DateUtil.weekdayCodeToString(Weekday.FRIDAY.getIndex()));
		assertEquals("Saturday", DateUtil.weekdayCodeToString(Weekday.SATURDAY.getIndex()));
	}

	/*public void testIsValidMonthCode() throws Exception {
		for (int i = 1; i <= 12; i++)
			assertTrue(isValidMonthCode(i));
		assertFalse(isValidMonthCode(0));
		assertFalse(isValidMonthCode(13));
	}*/

	public void testMonthToQuarter() throws Exception {
		assertEquals(1, Month.JANUARY.quarter());
		assertEquals(1, Month.FEBRUARY.quarter());
		assertEquals(1, Month.MARCH.quarter());
		assertEquals(2, Month.APRIL.quarter());
		assertEquals(2, Month.MAY.quarter());
		assertEquals(2, Month.JUNE.quarter());
		assertEquals(3, Month.JULY.quarter());
		assertEquals(3, Month.AUGUST.quarter());
		assertEquals(3, Month.SEPTEMBER.quarter());
		assertEquals(4, Month.OCTOBER.quarter());
		assertEquals(4, Month.NOVEMBER.quarter());
		assertEquals(4, Month.DECEMBER.quarter());

		try {
			Month.fromInt(-1);
			fail("Invalid Month Code should throw exception");
		} catch (IllegalArgumentException e) {
		}
	}

	public void testMonthCodeToString() throws Exception {
		assertEquals("January", Month.fromInt(JANUARY).toString());
		assertEquals("February", Month.fromInt(FEBRUARY).toString());
		assertEquals("March", Month.fromInt(MARCH).toString());
		assertEquals("April", Month.fromInt(APRIL).toString());
		assertEquals("May", Month.fromInt(MAY).toString());
		assertEquals("June", Month.fromInt(JUNE).toString());
		assertEquals("July", Month.fromInt(JULY).toString());
		assertEquals("August", Month.fromInt(AUGUST).toString());
		assertEquals("September", Month.fromInt(SEPTEMBER).toString());
		assertEquals("October", Month.fromInt(OCTOBER).toString());
		assertEquals("November", Month.fromInt(NOVEMBER).toString());
		assertEquals("December", Month.fromInt(DECEMBER).toString());

		assertEquals("Jan", Month.fromInt(JANUARY).toShortString());
		assertEquals("Feb", Month.fromInt(FEBRUARY).toShortString());
		assertEquals("Mar", Month.fromInt(MARCH).toShortString());
		assertEquals("Apr", Month.fromInt(APRIL).toShortString());
		assertEquals("May", Month.fromInt(MAY).toShortString());
		assertEquals("Jun", Month.fromInt(JUNE).toShortString());
		assertEquals("Jul", Month.fromInt(JULY).toShortString());
		assertEquals("Aug", Month.fromInt(AUGUST).toShortString());
		assertEquals("Sep", Month.fromInt(SEPTEMBER).toShortString());
		assertEquals("Oct", Month.fromInt(OCTOBER).toShortString());
		assertEquals("Nov", Month.fromInt(NOVEMBER).toShortString());
		assertEquals("Dec", Month.fromInt(DECEMBER).toShortString());

		try {
			Month.fromInt(-1);
			fail("Invalid month code should throw exception");
		} catch (IllegalArgumentException e) {
		}

	}

	public void testStringToMonthCode() throws Exception {
		assertEquals(JANUARY, Month.parse("1").getIndex());
		assertEquals(FEBRUARY, Month.parse("2").getIndex());
		assertEquals(MARCH, Month.parse("3").getIndex());
		assertEquals(APRIL, Month.parse("4").getIndex());
		assertEquals(MAY, Month.parse("5").getIndex());
		assertEquals(JUNE, Month.parse("6").getIndex());
		assertEquals(JULY, Month.parse("7").getIndex());
		assertEquals(AUGUST, Month.parse("8").getIndex());
		assertEquals(SEPTEMBER, Month.parse("9").getIndex());
		assertEquals(OCTOBER, Month.parse("10").getIndex());
		assertEquals(NOVEMBER, Month.parse("11").getIndex());
		assertEquals(DECEMBER, Month.parse("12").getIndex());

		// todo assertEquals(-1, stringToMonthCode("0"));
		// assertEquals(-1, stringToMonthCode("13"));

		try {
			Month.parse("Hello").getIndex();
			fail("Fail to get month code by string");
		} catch (IllegalArgumentException e) {
		}

		for (int m = 1; m <= 12; m++) {
			assertEquals(m, Month.parse(Month.fromInt(m).toString()).getIndex());
			assertEquals(m, Month.parse(Month.fromInt(m).toShortString()).getIndex());
		}

		// assertEquals(1,stringToMonthCode("jan"));
		// assertEquals(2,stringToMonthCode("feb"));
		// assertEquals(3,stringToMonthCode("mar"));
		// assertEquals(4,stringToMonthCode("apr"));
		// assertEquals(5,stringToMonthCode("may"));
		// assertEquals(6,stringToMonthCode("jun"));
		// assertEquals(7,stringToMonthCode("jul"));
		// assertEquals(8,stringToMonthCode("aug"));
		// assertEquals(9,stringToMonthCode("sep"));
		// assertEquals(10,stringToMonthCode("oct"));
		// assertEquals(11,stringToMonthCode("nov"));
		// assertEquals(12,stringToMonthCode("dec"));

		// assertEquals(1,stringToMonthCode("JAN"));
		// assertEquals(2,stringToMonthCode("FEB"));
		// assertEquals(3,stringToMonthCode("MAR"));
		// assertEquals(4,stringToMonthCode("APR"));
		// assertEquals(5,stringToMonthCode("MAY"));
		// assertEquals(6,stringToMonthCode("JUN"));
		// assertEquals(7,stringToMonthCode("JUL"));
		// assertEquals(8,stringToMonthCode("AUG"));
		// assertEquals(9,stringToMonthCode("SEP"));
		// assertEquals(10,stringToMonthCode("OCT"));
		// assertEquals(11,stringToMonthCode("NOV"));
		// assertEquals(12,stringToMonthCode("DEC"));

		// assertEquals(1,stringToMonthCode("january"));
		// assertEquals(2,stringToMonthCode("february"));
		// assertEquals(3,stringToMonthCode("march"));
		// assertEquals(4,stringToMonthCode("april"));
		// assertEquals(5,stringToMonthCode("may"));
		// assertEquals(6,stringToMonthCode("june"));
		// assertEquals(7,stringToMonthCode("july"));
		// assertEquals(8,stringToMonthCode("august"));
		// assertEquals(9,stringToMonthCode("september"));
		// assertEquals(10,stringToMonthCode("october"));
		// assertEquals(11,stringToMonthCode("november"));
		// assertEquals(12,stringToMonthCode("december"));

		// assertEquals(1,stringToMonthCode("JANUARY"));
		// assertEquals(2,stringToMonthCode("FEBRUARY"));
		// assertEquals(3,stringToMonthCode("MAR"));
		// assertEquals(4,stringToMonthCode("APRIL"));
		// assertEquals(5,stringToMonthCode("MAY"));
		// assertEquals(6,stringToMonthCode("JUNE"));
		// assertEquals(7,stringToMonthCode("JULY"));
		// assertEquals(8,stringToMonthCode("AUGUST"));
		// assertEquals(9,stringToMonthCode("SEPTEMBER"));
		// assertEquals(10,stringToMonthCode("OCTOBER"));
		// assertEquals(11,stringToMonthCode("NOVEMBER"));
		// assertEquals(12,stringToMonthCode("DECEMBER"));
	}

	public void testIsValidWeekInMonthCode() throws Exception {
		for (int w = 0; w <= 4; w++) {
			assertTrue(DateUtil.isValidWeekInMonthCode(w));
		}
		assertFalse(DateUtil.isValidWeekInMonthCode(5));
	}

	public void testIsLeapYear() throws Exception {
		assertFalse(DateUtil.isLeapYear(1900));
		assertFalse(DateUtil.isLeapYear(1901));
		assertFalse(DateUtil.isLeapYear(1902));
		assertFalse(DateUtil.isLeapYear(1903));
		assertTrue(DateUtil.isLeapYear(1904));
		assertTrue(DateUtil.isLeapYear(1908));
		assertFalse(DateUtil.isLeapYear(1955));
		assertTrue(DateUtil.isLeapYear(1964));
		assertTrue(DateUtil.isLeapYear(1980));
		assertTrue(DateUtil.isLeapYear(2000));
		assertFalse(DateUtil.isLeapYear(2001));
		assertFalse(DateUtil.isLeapYear(2100));
	}

	public void testLeapYearCount() throws Exception {
		assertEquals(0, SpreadsheetDate.leapYearCount(1900));
		assertEquals(0, SpreadsheetDate.leapYearCount(1901));
		assertEquals(0, SpreadsheetDate.leapYearCount(1902));
		assertEquals(0, SpreadsheetDate.leapYearCount(1903));
		assertEquals(1, SpreadsheetDate.leapYearCount(1904));
		assertEquals(1, SpreadsheetDate.leapYearCount(1905));
		assertEquals(1, SpreadsheetDate.leapYearCount(1906));
		assertEquals(1, SpreadsheetDate.leapYearCount(1907));
		assertEquals(2, SpreadsheetDate.leapYearCount(1908));
		assertEquals(24, SpreadsheetDate.leapYearCount(1999));
		assertEquals(25, SpreadsheetDate.leapYearCount(2001));
		assertEquals(49, SpreadsheetDate.leapYearCount(2101));
		assertEquals(73, SpreadsheetDate.leapYearCount(2201));
		assertEquals(97, SpreadsheetDate.leapYearCount(2301));
		assertEquals(122, SpreadsheetDate.leapYearCount(2401));
	}

	public void testLastDayOfMonth() throws Exception {
		assertEquals(31, DateUtil.lastDayOfMonth(Month.JANUARY, 1901));
		assertEquals(28, DateUtil.lastDayOfMonth(Month.FEBRUARY, 1901));
		assertEquals(31, DateUtil.lastDayOfMonth(Month.MARCH, 1901));
		assertEquals(30, DateUtil.lastDayOfMonth(Month.APRIL, 1901));
		assertEquals(31, DateUtil.lastDayOfMonth(Month.MAY, 1901));
		assertEquals(30, DateUtil.lastDayOfMonth(Month.JUNE, 1901));
		assertEquals(31, DateUtil.lastDayOfMonth(Month.JULY, 1901));
		assertEquals(31, DateUtil.lastDayOfMonth(Month.AUGUST, 1901));
		assertEquals(30, DateUtil.lastDayOfMonth(Month.SEPTEMBER, 1901));
		assertEquals(31, DateUtil.lastDayOfMonth(Month.OCTOBER, 1901));
		assertEquals(30, DateUtil.lastDayOfMonth(Month.NOVEMBER, 1901));
		assertEquals(31, DateUtil.lastDayOfMonth(Month.DECEMBER, 1901));
		assertEquals(29, DateUtil.lastDayOfMonth(Month.FEBRUARY, 1904));
	}

	public void testAddDays() throws Exception {
		SerialDate newYears = d(1, JANUARY, 1900);
		assertEquals(d(2, JANUARY, 1900), newYears.plusDays(1));
		assertEquals(d(1, FEBRUARY, 1900), newYears.plusDays(31));
		assertEquals(d(1, JANUARY, 1901), newYears.plusDays(365));
		assertEquals(d(31, DECEMBER, 1904), newYears.plusDays(5 * 365));
	}

	private static SpreadsheetDate d(int day, int month, int year) {
		return new SpreadsheetDate(day, month, year);
	}

	public void testAddMonths() throws Exception {
		assertEquals(d(1, FEBRUARY, 1900), d(1, JANUARY, 1900).plusMonths(1));
		assertEquals(d(28, FEBRUARY, 1900), d(31, JANUARY, 1900).plusMonths(1));
		assertEquals(d(28, FEBRUARY, 1900), d(30, JANUARY, 1900).plusMonths(1));
		assertEquals(d(28, FEBRUARY, 1900), d(29, JANUARY, 1900).plusMonths(1));
		assertEquals(d(28, FEBRUARY, 1900), d(28, JANUARY, 1900).plusMonths(1));
		assertEquals(d(27, FEBRUARY, 1900), d(27, JANUARY, 1900).plusMonths(1));

		assertEquals(d(30, JUNE, 1900), d(31, JANUARY, 1900).plusMonths(5));
		assertEquals(d(30, JUNE, 1901), d(31, JANUARY, 1900).plusMonths(17));

		assertEquals(d(29, FEBRUARY, 1904), d(31, JANUARY, 1900).plusMonths(49));

	}

	public void testAddYears() throws Exception {
		assertEquals(d(1, JANUARY, 1901), d(1, JANUARY, 1900).plusYears(1));
		assertEquals(d(28, FEBRUARY, 1905), d(29, FEBRUARY, 1904).plusYears(1));
		assertEquals(d(28, FEBRUARY, 1905), d(28, FEBRUARY, 1904).plusYears(1));
		assertEquals(d(28, FEBRUARY, 1904), d(28, FEBRUARY, 1903).plusYears(1));
	}

	public void testGetPreviousDayOfWeek() throws Exception {
		assertEquals(d(24, FEBRUARY, 2006),
				d(1, MARCH, 2006).getPreviousDayOfWeek(Day.FRIDAY));
		assertEquals(d(22, FEBRUARY, 2006),
				d(1, MARCH, 2006).getPreviousDayOfWeek(Day.WEDNESDAY));
		assertEquals(d(29, FEBRUARY, 2004),
				d(3, MARCH, 2004).getPreviousDayOfWeek(Day.SUNDAY));
		assertEquals(d(29, DECEMBER, 2004),
				d(5, JANUARY, 2005).getPreviousDayOfWeek(Day.WEDNESDAY));

		try {
			d(1, JANUARY, 2006).getPreviousDayOfWeek(Day.fromInt(-1));
			fail("Failed to get previous day of week");
		} catch (IllegalArgumentException e) {
		}
	}

	public void testGetFollowingDayOfWeek() throws Exception {
		// assertEquals(d(1, JANUARY, 2005),getFollowingDayOfWeek(Weekday.SATURDAY.getIndex(),
		// d(25, DECEMBER, 2004)));
		assertEquals(d(1, JANUARY, 2005),
				d(26, DECEMBER, 2004).getFollowingDayOfWeek(Day.SATURDAY));
		assertEquals(d(3, MARCH, 2004),
				d(28, FEBRUARY, 2004).getFollowingDayOfWeek(Day.WEDNESDAY));

		try {
			d(1, JANUARY, 2006).getFollowingDayOfWeek(Day.fromInt(-1));
			fail("Invalid day of week code should throw exception");
		} catch (IllegalArgumentException e) {
		}
	}

	public void testGetNearestDayOfWeek() throws Exception {
		assertEquals(d(16, APRIL, 2006),
				d(16, APRIL, 2006).getNearestDayOfWeek(Day.SUNDAY));
		assertEquals(d(16, APRIL, 2006),
				d(17, APRIL, 2006).getNearestDayOfWeek(Day.SUNDAY));
		assertEquals(d(16, APRIL, 2006),
				d(18, APRIL, 2006).getNearestDayOfWeek(Day.SUNDAY));
		assertEquals(d(16, APRIL, 2006),
				d(19, APRIL, 2006).getNearestDayOfWeek(Day.SUNDAY));
		assertEquals(d(23, APRIL, 2006),
				d(20, APRIL, 2006).getNearestDayOfWeek(Day.SUNDAY));
		assertEquals(d(23, APRIL, 2006),
				d(21, APRIL, 2006).getNearestDayOfWeek(Day.SUNDAY));
		assertEquals(d(23, APRIL, 2006),
				d(22, APRIL, 2006).getNearestDayOfWeek(Day.SUNDAY));

		// todo assertEquals(d(17, APRIL, 2006), d(16, APRIL, 2006).getNearestDayOfWeek(Day.MONDAY));
		assertEquals(d(17, APRIL, 2006),
				d(17, APRIL, 2006).getNearestDayOfWeek(Day.MONDAY));
		assertEquals(d(17, APRIL, 2006),
				d(18, APRIL, 2006).getNearestDayOfWeek(Day.MONDAY));
		assertEquals(d(17, APRIL, 2006),
				d(19, APRIL, 2006).getNearestDayOfWeek(Day.MONDAY));
		assertEquals(d(17, APRIL, 2006),
				d(20, APRIL, 2006).getNearestDayOfWeek(Day.MONDAY));
		assertEquals(d(24, APRIL, 2006),
				d(21, APRIL, 2006).getNearestDayOfWeek(Day.MONDAY));
		assertEquals(d(24, APRIL, 2006),
				d(22, APRIL, 2006).getNearestDayOfWeek(Day.MONDAY));

		// assertEquals(d(18, APRIL, 2006), getNearestDayOfWeek(Weekday.TUESDAY, d(16,
		// APRIL, 2006)));
		// assertEquals(d(18, APRIL, 2006), getNearestDayOfWeek(Weekday.TUESDAY, d(17,
		// APRIL, 2006)));
		assertEquals(d(18, APRIL, 2006),
				d(18, APRIL, 2006).getNearestDayOfWeek(Day.TUESDAY));
		assertEquals(d(18, APRIL, 2006),
				d(19, APRIL, 2006).getNearestDayOfWeek(Day.TUESDAY));
		assertEquals(d(18, APRIL, 2006),
				d(20, APRIL, 2006).getNearestDayOfWeek(Day.TUESDAY));
		assertEquals(d(18, APRIL, 2006),
				d(21, APRIL, 2006).getNearestDayOfWeek(Day.TUESDAY));
		assertEquals(d(25, APRIL, 2006),
				d(22, APRIL, 2006).getNearestDayOfWeek(Day.TUESDAY));

		// assertEquals(d(19, APRIL, 2006), getNearestDayOfWeek(Weekday.WEDNESDAY, d(16,
		// APRIL, 2006)));
		// assertEquals(d(19, APRIL, 2006), getNearestDayOfWeek(Weekday.WEDNESDAY, d(17,
		// APRIL, 2006)));
		// assertEquals(d(19, APRIL, 2006), getNearestDayOfWeek(Weekday.WEDNESDAY, d(18,
		// APRIL, 2006)));
		assertEquals(d(19, APRIL, 2006),
				d(19, APRIL, 2006).getNearestDayOfWeek(Day.WEDNESDAY));
		assertEquals(d(19, APRIL, 2006),
				d(20, APRIL, 2006).getNearestDayOfWeek(Day.WEDNESDAY));
		assertEquals(d(19, APRIL, 2006),
				d(21, APRIL, 2006).getNearestDayOfWeek(Day.WEDNESDAY));
		assertEquals(d(19, APRIL, 2006),
				d(22, APRIL, 2006).getNearestDayOfWeek(Day.WEDNESDAY));

		// assertEquals(d(13, APRIL, 2006), getNearestDayOfWeek(Day.THURSDAY, d(16,
		// APRIL, 2006)));
		// assertEquals(d(20, APRIL, 2006), getNearestDayOfWeek(Day.THURSDAY, d(17,
		// APRIL, 2006)));
		// assertEquals(d(20, APRIL, 2006), getNearestDayOfWeek(Day.THURSDAY, d(18,
		// APRIL, 2006)));
		// assertEquals(d(20, APRIL, 2006), getNearestDayOfWeek(Day.THURSDAY, d(19,
		// APRIL, 2006)));
		assertEquals(d(20, APRIL, 2006),
				d(20, APRIL, 2006).getNearestDayOfWeek(Day.THURSDAY));
		assertEquals(d(20, APRIL, 2006),
				d(21, APRIL, 2006).getNearestDayOfWeek(Day.THURSDAY));
		assertEquals(d(20, APRIL, 2006),
				d(22, APRIL, 2006).getNearestDayOfWeek(Day.THURSDAY));

		// assertEquals(d(14, APRIL, 2006), getNearestDayOfWeek(Day.FRIDAY, d(16,
		// APRIL, 2006)));
		// assertEquals(d(14, APRIL, 2006), getNearestDayOfWeek(Day.FRIDAY, d(17,
		// APRIL, 2006)));
		// assertEquals(d(21, APRIL, 2006), getNearestDayOfWeek(Day.FRIDAY, d(18,
		// APRIL, 2006)));
		// assertEquals(d(21, APRIL, 2006), getNearestDayOfWeek(Day.FRIDAY, d(19,
		// APRIL, 2006)));
		// assertEquals(d(21, APRIL, 2006), getNearestDayOfWeek(Day.FRIDAY, d(20,
		// APRIL, 2006)));
		assertEquals(d(21, APRIL, 2006),
				d(21, APRIL, 2006).getNearestDayOfWeek(Day.FRIDAY));
		assertEquals(d(21, APRIL, 2006),
				d(22, APRIL, 2006).getNearestDayOfWeek(Day.FRIDAY));

		// assertEquals(d(15, APRIL, 2006), getNearestDayOfWeek(Day.SATURDAY, d(16,
		// APRIL, 2006)));
		// assertEquals(d(15, APRIL, 2006), getNearestDayOfWeek(Day.SATURDAY, d(17,
		// APRIL, 2006)));
		// assertEquals(d(15, APRIL, 2006), getNearestDayOfWeek(Day.SATURDAY, d(18,
		// APRIL, 2006)));
		// assertEquals(d(22, APRIL, 2006), getNearestDayOfWeek(Day.SATURDAY, d(19,
		// APRIL, 2006)));
		// assertEquals(d(22, APRIL, 2006), getNearestDayOfWeek(Day.SATURDAY, d(20,
		// APRIL, 2006)));
		// assertEquals(d(22, APRIL, 2006), getNearestDayOfWeek(Day.SATURDAY, d(21,
		// APRIL, 2006)));
		assertEquals(d(22, APRIL, 2006),
				d(22, APRIL, 2006).getNearestDayOfWeek(Day.SATURDAY));

		try {
			d(1, JANUARY, 2006).getNearestDayOfWeek(Day.fromInt(-1));
			fail("Invalid day of week code should throw exception");
		} catch (IllegalArgumentException e) {
		}
	}

	public void testEndOfCurrentMonth() throws Exception {
		SerialDate d = DayDateFactory.makeDate(2);
		assertEquals(d(31, JANUARY, 2006), d(1, JANUARY, 2006).getEndOfMonth());
		assertEquals(d(28, FEBRUARY, 2006), d(1, FEBRUARY, 2006).getEndOfMonth());
		assertEquals(d(31, MARCH, 2006), d(1, MARCH, 2006).getEndOfMonth());
		assertEquals(d(30, APRIL, 2006), d(1, APRIL, 2006).getEndOfMonth());
		assertEquals(d(31, MAY, 2006), d(1, MAY, 2006).getEndOfMonth());
		assertEquals(d(30, JUNE, 2006), d(1, JUNE, 2006).getEndOfMonth());
		assertEquals(d(31, JULY, 2006), d(1, JULY, 2006).getEndOfMonth());
		assertEquals(d(31, AUGUST, 2006), d(1, AUGUST, 2006).getEndOfMonth());
		assertEquals(d(30, SEPTEMBER, 2006), d(1, SEPTEMBER, 2006).getEndOfMonth());
		assertEquals(d(31, OCTOBER, 2006), d(1, OCTOBER, 2006).getEndOfMonth());
		assertEquals(d(30, NOVEMBER, 2006), d(1, NOVEMBER, 2006).getEndOfMonth());
		assertEquals(d(31, DECEMBER, 2006), d(1, DECEMBER, 2006).getEndOfMonth());
		assertEquals(d(29, FEBRUARY, 2008), d(1, FEBRUARY, 2008).getEndOfMonth());
	}

	public void testWeekInMonthToString() throws Exception {
		assertEquals("First", WeekInMonth.FIRST.toString());
		assertEquals("Second", WeekInMonth.SECOND.toString());
		assertEquals("Third", WeekInMonth.THIRD.toString());
		assertEquals("Fourth", WeekInMonth.FOURTH.toString());
		assertEquals("Last", WeekInMonth.LAST.toString());

		// todo try {
		// weekInMonthToString(-1);
		// fail("Invalid week code should throw exception");
		// } catch (IllegalArgumentException e) {
		// }
	}

	/*public void testRelativeToString() throws Exception {
		assertEquals("Last", relativeToString(WeekdayRange.LAST.getIndex()));
		assertEquals("Nearest", relativeToString(WeekdayRange.NEAREST.getIndex()));
		assertEquals("Next", relativeToString(WeekdayRange.NEXT.getIndex()));

		// todo try {
		// relativeToString(-1000);
		// fail("Invalid relative code should throw exception");
		// } catch (IllegalArgumentException e) {
		// }
	}*/

	public void testCreateInstanceFromDDMMYYY() throws Exception {
		SerialDate date = DayDateFactory.makeDate(1, JANUARY, 1900);
		assertEquals(1, date.getDayOfMonth());
		assertEquals(JANUARY, date.getMonth());
		assertEquals(1900, date.getYear());
		assertEquals(2, date.getOrdinalDay());
	}

	public void testCreateInstanceFromSerial() throws Exception {
		assertEquals(d(1, JANUARY, 1900), DayDateFactory.makeDate(2));
		assertEquals(d(1, JANUARY, 1901), DayDateFactory.makeDate(367));
	}

	public void testCreateInstanceFromJavaDate() throws Exception {
		assertEquals(d(1, JANUARY, 1900), DayDateFactory.makeDate(new GregorianCalendar(
				1900, 0, 1).getTime()));
		assertEquals(d(1, JANUARY, 2006), DayDateFactory.makeDate(new GregorianCalendar(
				2006, 0, 1).getTime()));
	}
	
	//Write tests for daysSince

	public static void main(String[] args) {
		junit.textui.TestRunner.run(BobsSerialDateTest.class);
	}
}
