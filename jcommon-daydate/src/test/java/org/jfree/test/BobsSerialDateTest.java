package org.jfree.test;

import junit.framework.TestCase;
import org.jfree.date.*;
import static org.jfree.date.SerialDate.*;

import java.util.*;

public class BobsSerialDateTest extends TestCase implements MonthConstants {
	
	/*public void testIsValidWeekdayCode() throws Exception {
		for (int day = 1; day <= 7; day++) {
			assertTrue(isValidWeekdayCode(day));
		}
		assertFalse(isValidWeekdayCode(0));
		assertFalse(isValidWeekdayCode(8));
	}*/

	public void testStringToWeekdayCode() throws Exception {

		assertEquals(-1, stringToWeekdayCode("Hello"));
		assertEquals(Weekday.MONDAY.index, stringToWeekdayCode("Monday"));
		assertEquals(Weekday.MONDAY.index, stringToWeekdayCode("Mon"));
		// todo 
		assertEquals(Weekday.MONDAY.index,stringToWeekdayCode("monday"));
		assertEquals(Weekday.MONDAY.index,stringToWeekdayCode("MONDAY"));
		assertEquals(Weekday.MONDAY.index, stringToWeekdayCode("mon"));

		assertEquals(Weekday.TUESDAY.index, stringToWeekdayCode("Tuesday"));
		assertEquals(Weekday.TUESDAY.index, stringToWeekdayCode("Tue"));
		// assertEquals(Weekday.TUESDAY.index,stringToWeekdayCode("tuesday"));
		// assertEquals(Weekday.TUESDAY.index,stringToWeekdayCode("TUESDAY"));
		// assertEquals(Weekday.TUESDAY.index, stringToWeekdayCode("tue"));
		// assertEquals(Weekday.TUESDAY.index, stringToWeekdayCode("tues"));

		assertEquals(Weekday.WEDNESDAY.index, stringToWeekdayCode("Wednesday"));
		assertEquals(Weekday.WEDNESDAY.index, stringToWeekdayCode("Wed"));
		// assertEquals(Weekday.WEDNESDAY.index,stringToWeekdayCode("wednesday"));
		// assertEquals(Weekday.WEDNESDAY.index,stringToWeekdayCode("WEDNESDAY"));
		// assertEquals(Weekday.WEDNESDAY.index, stringToWeekdayCode("wed"));

		assertEquals(Weekday.THURSDAY.getIndex(), stringToWeekdayCode("Thursday"));
		assertEquals(Weekday.THURSDAY.getIndex(), stringToWeekdayCode("Thu"));
		// assertEquals(Weekday.THURSDAY.getIndex(),stringToWeekdayCode("thursday"));
		// assertEquals(Weekday.THURSDAY.getIndex(),stringToWeekdayCode("THURSDAY"));
		// assertEquals(Weekday.THURSDAY.getIndex(), stringToWeekdayCode("thu"));
		// assertEquals(Weekday.THURSDAY.getIndex(), stringToWeekdayCode("thurs"));

		assertEquals(Weekday.FRIDAY.getIndex(), stringToWeekdayCode("Friday"));
		assertEquals(Weekday.FRIDAY.getIndex(), stringToWeekdayCode("Fri"));
		// assertEquals(Weekday.FRIDAY.getIndex(),stringToWeekdayCode("friday"));
		// assertEquals(Weekday.FRIDAY.getIndex(),stringToWeekdayCode("FRIDAY"));
		// assertEquals(Weekday.FRIDAY.getIndex(), stringToWeekdayCode("fri"));

		assertEquals(Weekday.SATURDAY.getIndex(), stringToWeekdayCode("Saturday"));
		assertEquals(Weekday.SATURDAY.getIndex(), stringToWeekdayCode("Sat"));
		// assertEquals(Weekday.SATURDAY.getIndex(),stringToWeekdayCode("saturday"));
		// assertEquals(Weekday.SATURDAY.getIndex(),stringToWeekdayCode("SATURDAY"));
		// assertEquals(Weekday.SATURDAY.getIndex(), stringToWeekdayCode("sat"));

		assertEquals(Weekday.SUNDAY.getIndex(), stringToWeekdayCode("Sunday"));
		assertEquals(Weekday.SUNDAY.getIndex(), stringToWeekdayCode("Sun"));
		// assertEquals(Weekday.SUNDAY.getIndex(),stringToWeekdayCode("sunday"));
		// assertEquals(Weekday.SUNDAY.getIndex(),stringToWeekdayCode("SUNDAY"));
		// assertEquals(Weekday.SUNDAY.getIndex(), stringToWeekdayCode("sun"));
	}

	public void testWeekdayCodeToString() throws Exception {
		assertEquals("Sunday", SerialDate.weekdayCodeToString(Weekday.SUNDAY.getIndex()));
		assertEquals("Monday", SerialDate.weekdayCodeToString(Weekday.MONDAY.getIndex()));
		assertEquals("Tuesday", SerialDate.weekdayCodeToString(Weekday.TUESDAY.getIndex()));
		assertEquals("Wednesday", SerialDate.weekdayCodeToString(Weekday.WEDNESDAY.getIndex()));
		assertEquals("Thursday", SerialDate.weekdayCodeToString(Weekday.THURSDAY.getIndex()));
		assertEquals("Friday", SerialDate.weekdayCodeToString(Weekday.FRIDAY.getIndex()));
		assertEquals("Saturday", SerialDate.weekdayCodeToString(Weekday.SATURDAY.getIndex()));
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
			Month.make(-1);
			fail("Invalid Month Code should throw exception");
		} catch (IllegalArgumentException e) {
		}
	}

	public void testMonthCodeToString() throws Exception {
		assertEquals("January", monthCodeToString(JANUARY));
		assertEquals("February", monthCodeToString(FEBRUARY));
		assertEquals("March", monthCodeToString(MARCH));
		assertEquals("April", monthCodeToString(APRIL));
		assertEquals("May", monthCodeToString(MAY));
		assertEquals("June", monthCodeToString(JUNE));
		assertEquals("July", monthCodeToString(JULY));
		assertEquals("August", monthCodeToString(AUGUST));
		assertEquals("September", monthCodeToString(SEPTEMBER));
		assertEquals("October", monthCodeToString(OCTOBER));
		assertEquals("November", monthCodeToString(NOVEMBER));
		assertEquals("December", monthCodeToString(DECEMBER));

		assertEquals("Jan", monthCodeToString(JANUARY, true));
		assertEquals("Feb", monthCodeToString(FEBRUARY, true));
		assertEquals("Mar", monthCodeToString(MARCH, true));
		assertEquals("Apr", monthCodeToString(APRIL, true));
		assertEquals("May", monthCodeToString(MAY, true));
		assertEquals("Jun", monthCodeToString(JUNE, true));
		assertEquals("Jul", monthCodeToString(JULY, true));
		assertEquals("Aug", monthCodeToString(AUGUST, true));
		assertEquals("Sep", monthCodeToString(SEPTEMBER, true));
		assertEquals("Oct", monthCodeToString(OCTOBER, true));
		assertEquals("Nov", monthCodeToString(NOVEMBER, true));
		assertEquals("Dec", monthCodeToString(DECEMBER, true));

		try {
			monthCodeToString(-1);
			fail("Invalid month code should throw exception");
		} catch (IllegalArgumentException e) {
		}

	}

	public void testStringToMonthCode() throws Exception {
		assertEquals(JANUARY, stringToMonthCode("1"));
		assertEquals(FEBRUARY, stringToMonthCode("2"));
		assertEquals(MARCH, stringToMonthCode("3"));
		assertEquals(APRIL, stringToMonthCode("4"));
		assertEquals(MAY, stringToMonthCode("5"));
		assertEquals(JUNE, stringToMonthCode("6"));
		assertEquals(JULY, stringToMonthCode("7"));
		assertEquals(AUGUST, stringToMonthCode("8"));
		assertEquals(SEPTEMBER, stringToMonthCode("9"));
		assertEquals(OCTOBER, stringToMonthCode("10"));
		assertEquals(NOVEMBER, stringToMonthCode("11"));
		assertEquals(DECEMBER, stringToMonthCode("12"));

		// todo assertEquals(-1, stringToMonthCode("0"));
		// assertEquals(-1, stringToMonthCode("13"));

		assertEquals(-1, stringToMonthCode("Hello"));

		for (int m = 1; m <= 12; m++) {
			assertEquals(m, stringToMonthCode(monthCodeToString(m, false)));
			assertEquals(m, stringToMonthCode(monthCodeToString(m, true)));
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
			assertTrue(isValidWeekInMonthCode(w));
		}
		assertFalse(isValidWeekInMonthCode(5));
	}

	public void testIsLeapYear() throws Exception {
		assertFalse(isLeapYear(1900));
		assertFalse(isLeapYear(1901));
		assertFalse(isLeapYear(1902));
		assertFalse(isLeapYear(1903));
		assertTrue(isLeapYear(1904));
		assertTrue(isLeapYear(1908));
		assertFalse(isLeapYear(1955));
		assertTrue(isLeapYear(1964));
		assertTrue(isLeapYear(1980));
		assertTrue(isLeapYear(2000));
		assertFalse(isLeapYear(2001));
		assertFalse(isLeapYear(2100));
	}

	public void testLeapYearCount() throws Exception {
		assertEquals(0, leapYearCount(1900));
		assertEquals(0, leapYearCount(1901));
		assertEquals(0, leapYearCount(1902));
		assertEquals(0, leapYearCount(1903));
		assertEquals(1, leapYearCount(1904));
		assertEquals(1, leapYearCount(1905));
		assertEquals(1, leapYearCount(1906));
		assertEquals(1, leapYearCount(1907));
		assertEquals(2, leapYearCount(1908));
		assertEquals(24, leapYearCount(1999));
		assertEquals(25, leapYearCount(2001));
		assertEquals(49, leapYearCount(2101));
		assertEquals(73, leapYearCount(2201));
		assertEquals(97, leapYearCount(2301));
		assertEquals(122, leapYearCount(2401));
	}

	public void testLastDayOfMonth() throws Exception {
		assertEquals(31, lastDayOfMonth(JANUARY, 1901));
		assertEquals(28, lastDayOfMonth(FEBRUARY, 1901));
		assertEquals(31, lastDayOfMonth(MARCH, 1901));
		assertEquals(30, lastDayOfMonth(APRIL, 1901));
		assertEquals(31, lastDayOfMonth(MAY, 1901));
		assertEquals(30, lastDayOfMonth(JUNE, 1901));
		assertEquals(31, lastDayOfMonth(JULY, 1901));
		assertEquals(31, lastDayOfMonth(AUGUST, 1901));
		assertEquals(30, lastDayOfMonth(SEPTEMBER, 1901));
		assertEquals(31, lastDayOfMonth(OCTOBER, 1901));
		assertEquals(30, lastDayOfMonth(NOVEMBER, 1901));
		assertEquals(31, lastDayOfMonth(DECEMBER, 1901));
		assertEquals(29, lastDayOfMonth(FEBRUARY, 1904));
	}

	public void testAddDays() throws Exception {
		SerialDate newYears = d(1, JANUARY, 1900);
		assertEquals(d(2, JANUARY, 1900), addDays(1, newYears));
		assertEquals(d(1, FEBRUARY, 1900), addDays(31, newYears));
		assertEquals(d(1, JANUARY, 1901), addDays(365, newYears));
		assertEquals(d(31, DECEMBER, 1904), addDays(5 * 365, newYears));
	}

	private static SpreadsheetDate d(int day, int month, int year) {
		return new SpreadsheetDate(day, month, year);
	}

	public void testAddMonths() throws Exception {
		assertEquals(d(1, FEBRUARY, 1900), addMonths(1, d(1, JANUARY, 1900)));
		assertEquals(d(28, FEBRUARY, 1900), addMonths(1, d(31, JANUARY, 1900)));
		assertEquals(d(28, FEBRUARY, 1900), addMonths(1, d(30, JANUARY, 1900)));
		assertEquals(d(28, FEBRUARY, 1900), addMonths(1, d(29, JANUARY, 1900)));
		assertEquals(d(28, FEBRUARY, 1900), addMonths(1, d(28, JANUARY, 1900)));
		assertEquals(d(27, FEBRUARY, 1900), addMonths(1, d(27, JANUARY, 1900)));

		assertEquals(d(30, JUNE, 1900), addMonths(5, d(31, JANUARY, 1900)));
		assertEquals(d(30, JUNE, 1901), addMonths(17, d(31, JANUARY, 1900)));

		assertEquals(d(29, FEBRUARY, 1904), addMonths(49, d(31, JANUARY, 1900)));

	}

	public void testAddYears() throws Exception {
		assertEquals(d(1, JANUARY, 1901), addYears(1, d(1, JANUARY, 1900)));
		assertEquals(d(28, FEBRUARY, 1905), addYears(1, d(29, FEBRUARY, 1904)));
		assertEquals(d(28, FEBRUARY, 1905), addYears(1, d(28, FEBRUARY, 1904)));
		assertEquals(d(28, FEBRUARY, 1904), addYears(1, d(28, FEBRUARY, 1903)));
	}

	public void testGetPreviousDayOfWeek() throws Exception {
		assertEquals(d(24, FEBRUARY, 2006),
				getPreviousDayOfWeek(Weekday.FRIDAY.getIndex(), d(1, MARCH, 2006)));
		assertEquals(d(22, FEBRUARY, 2006),
				getPreviousDayOfWeek(Weekday.WEDNESDAY.getIndex(), d(1, MARCH, 2006)));
		assertEquals(d(29, FEBRUARY, 2004),
				getPreviousDayOfWeek(Weekday.SUNDAY.getIndex(), d(3, MARCH, 2004)));
		assertEquals(d(29, DECEMBER, 2004),
				getPreviousDayOfWeek(Weekday.WEDNESDAY.getIndex(), d(5, JANUARY, 2005)));

		try {
			getPreviousDayOfWeek(-1, d(1, JANUARY, 2006));
		} catch (IllegalArgumentException e) {
		}
	}

	public void testGetFollowingDayOfWeek() throws Exception {
		// assertEquals(d(1, JANUARY, 2005),getFollowingDayOfWeek(Weekday.SATURDAY.getIndex(),
		// d(25, DECEMBER, 2004)));
		assertEquals(d(1, JANUARY, 2005),
				getFollowingDayOfWeek(Weekday.SATURDAY.getIndex(), d(26, DECEMBER, 2004)));
		assertEquals(d(3, MARCH, 2004),
				getFollowingDayOfWeek(Weekday.WEDNESDAY.getIndex(), d(28, FEBRUARY, 2004)));

		try {
			getFollowingDayOfWeek(-1, d(1, JANUARY, 2006));
			fail("Invalid day of week code should throw exception");
		} catch (IllegalArgumentException e) {
		}
	}

	public void testGetNearestDayOfWeek() throws Exception {
		assertEquals(d(16, APRIL, 2006),
				getNearestDayOfWeek(Weekday.SUNDAY.getIndex(), d(16, APRIL, 2006)));
		assertEquals(d(16, APRIL, 2006),
				getNearestDayOfWeek(Weekday.SUNDAY.getIndex(), d(17, APRIL, 2006)));
		assertEquals(d(16, APRIL, 2006),
				getNearestDayOfWeek(Weekday.SUNDAY.getIndex(), d(18, APRIL, 2006)));
		assertEquals(d(16, APRIL, 2006),
				getNearestDayOfWeek(Weekday.SUNDAY.getIndex(), d(19, APRIL, 2006)));
		assertEquals(d(23, APRIL, 2006),
				getNearestDayOfWeek(Weekday.SUNDAY.getIndex(), d(20, APRIL, 2006)));
		assertEquals(d(23, APRIL, 2006),
				getNearestDayOfWeek(Weekday.SUNDAY.getIndex(), d(21, APRIL, 2006)));
		assertEquals(d(23, APRIL, 2006),
				getNearestDayOfWeek(Weekday.SUNDAY.getIndex(), d(22, APRIL, 2006)));

		// todo assertEquals(d(17, APRIL, 2006), getNearestDayOfWeek(Weekday.MONDAY.getIndex(),
		// d(16, APRIL, 2006)));
		assertEquals(d(17, APRIL, 2006),
				getNearestDayOfWeek(Weekday.MONDAY.getIndex(), d(17, APRIL, 2006)));
		assertEquals(d(17, APRIL, 2006),
				getNearestDayOfWeek(Weekday.MONDAY.getIndex(), d(18, APRIL, 2006)));
		assertEquals(d(17, APRIL, 2006),
				getNearestDayOfWeek(Weekday.MONDAY.getIndex(), d(19, APRIL, 2006)));
		assertEquals(d(17, APRIL, 2006),
				getNearestDayOfWeek(Weekday.MONDAY.getIndex(), d(20, APRIL, 2006)));
		assertEquals(d(24, APRIL, 2006),
				getNearestDayOfWeek(Weekday.MONDAY.getIndex(), d(21, APRIL, 2006)));
		assertEquals(d(24, APRIL, 2006),
				getNearestDayOfWeek(Weekday.MONDAY.getIndex(), d(22, APRIL, 2006)));

		// assertEquals(d(18, APRIL, 2006), getNearestDayOfWeek(Weekday.TUESDAY.getIndex(), d(16,
		// APRIL, 2006)));
		// assertEquals(d(18, APRIL, 2006), getNearestDayOfWeek(Weekday.TUESDAY.getIndex(), d(17,
		// APRIL, 2006)));
		assertEquals(d(18, APRIL, 2006),
				getNearestDayOfWeek(Weekday.TUESDAY.getIndex(), d(18, APRIL, 2006)));
		assertEquals(d(18, APRIL, 2006),
				getNearestDayOfWeek(Weekday.TUESDAY.getIndex(), d(19, APRIL, 2006)));
		assertEquals(d(18, APRIL, 2006),
				getNearestDayOfWeek(Weekday.TUESDAY.getIndex(), d(20, APRIL, 2006)));
		assertEquals(d(18, APRIL, 2006),
				getNearestDayOfWeek(Weekday.TUESDAY.getIndex(), d(21, APRIL, 2006)));
		assertEquals(d(25, APRIL, 2006),
				getNearestDayOfWeek(Weekday.TUESDAY.getIndex(), d(22, APRIL, 2006)));

		// assertEquals(d(19, APRIL, 2006), getNearestDayOfWeek(Weekday.WEDNESDAY.getIndex(), d(16,
		// APRIL, 2006)));
		// assertEquals(d(19, APRIL, 2006), getNearestDayOfWeek(Weekday.WEDNESDAY.getIndex(), d(17,
		// APRIL, 2006)));
		// assertEquals(d(19, APRIL, 2006), getNearestDayOfWeek(Weekday.WEDNESDAY.getIndex(), d(18,
		// APRIL, 2006)));
		assertEquals(d(19, APRIL, 2006),
				getNearestDayOfWeek(Weekday.WEDNESDAY.getIndex(), d(19, APRIL, 2006)));
		assertEquals(d(19, APRIL, 2006),
				getNearestDayOfWeek(Weekday.WEDNESDAY.getIndex(), d(20, APRIL, 2006)));
		assertEquals(d(19, APRIL, 2006),
				getNearestDayOfWeek(Weekday.WEDNESDAY.getIndex(), d(21, APRIL, 2006)));
		assertEquals(d(19, APRIL, 2006),
				getNearestDayOfWeek(Weekday.WEDNESDAY.getIndex(), d(22, APRIL, 2006)));

		// assertEquals(d(13, APRIL, 2006), getNearestDayOfWeek(Weekday.THURSDAY.getIndex(), d(16,
		// APRIL, 2006)));
		// assertEquals(d(20, APRIL, 2006), getNearestDayOfWeek(Weekday.THURSDAY.getIndex(), d(17,
		// APRIL, 2006)));
		// assertEquals(d(20, APRIL, 2006), getNearestDayOfWeek(Weekday.THURSDAY.getIndex(), d(18,
		// APRIL, 2006)));
		// assertEquals(d(20, APRIL, 2006), getNearestDayOfWeek(Weekday.THURSDAY.getIndex(), d(19,
		// APRIL, 2006)));
		assertEquals(d(20, APRIL, 2006),
				getNearestDayOfWeek(Weekday.THURSDAY.getIndex(), d(20, APRIL, 2006)));
		assertEquals(d(20, APRIL, 2006),
				getNearestDayOfWeek(Weekday.THURSDAY.getIndex(), d(21, APRIL, 2006)));
		assertEquals(d(20, APRIL, 2006),
				getNearestDayOfWeek(Weekday.THURSDAY.getIndex(), d(22, APRIL, 2006)));

		// assertEquals(d(14, APRIL, 2006), getNearestDayOfWeek(Weekday.FRIDAY.getIndex(), d(16,
		// APRIL, 2006)));
		// assertEquals(d(14, APRIL, 2006), getNearestDayOfWeek(Weekday.FRIDAY.getIndex(), d(17,
		// APRIL, 2006)));
		// assertEquals(d(21, APRIL, 2006), getNearestDayOfWeek(Weekday.FRIDAY.getIndex(), d(18,
		// APRIL, 2006)));
		// assertEquals(d(21, APRIL, 2006), getNearestDayOfWeek(Weekday.FRIDAY.getIndex(), d(19,
		// APRIL, 2006)));
		// assertEquals(d(21, APRIL, 2006), getNearestDayOfWeek(Weekday.FRIDAY.getIndex(), d(20,
		// APRIL, 2006)));
		assertEquals(d(21, APRIL, 2006),
				getNearestDayOfWeek(Weekday.FRIDAY.getIndex(), d(21, APRIL, 2006)));
		assertEquals(d(21, APRIL, 2006),
				getNearestDayOfWeek(Weekday.FRIDAY.getIndex(), d(22, APRIL, 2006)));

		// assertEquals(d(15, APRIL, 2006), getNearestDayOfWeek(Weekday.SATURDAY.getIndex(), d(16,
		// APRIL, 2006)));
		// assertEquals(d(15, APRIL, 2006), getNearestDayOfWeek(Weekday.SATURDAY.getIndex(), d(17,
		// APRIL, 2006)));
		// assertEquals(d(15, APRIL, 2006), getNearestDayOfWeek(Weekday.SATURDAY.getIndex(), d(18,
		// APRIL, 2006)));
		// assertEquals(d(22, APRIL, 2006), getNearestDayOfWeek(Weekday.SATURDAY.getIndex(), d(19,
		// APRIL, 2006)));
		// assertEquals(d(22, APRIL, 2006), getNearestDayOfWeek(Weekday.SATURDAY.getIndex(), d(20,
		// APRIL, 2006)));
		// assertEquals(d(22, APRIL, 2006), getNearestDayOfWeek(Weekday.SATURDAY.getIndex(), d(21,
		// APRIL, 2006)));
		assertEquals(d(22, APRIL, 2006),
				getNearestDayOfWeek(Weekday.SATURDAY.getIndex(), d(22, APRIL, 2006)));

		try {
			getNearestDayOfWeek(-1, d(1, JANUARY, 2006));
			fail("Invalid day of week code should throw exception");
		} catch (IllegalArgumentException e) {
		}
	}

	public void testEndOfCurrentMonth() throws Exception {
		SerialDate d = DayDateFactory.makeDate(2);
		assertEquals(d(31, JANUARY, 2006),
				d.getEndOfCurrentMonth(d(1, JANUARY, 2006)));
		assertEquals(d(28, FEBRUARY, 2006), d.getEndOfCurrentMonth(d(1, FEBRUARY, 2006)));
		assertEquals(d(31, MARCH, 2006),
				d.getEndOfCurrentMonth(d(1, MARCH, 2006)));
		assertEquals(d(30, APRIL, 2006),
				d.getEndOfCurrentMonth(d(1, APRIL, 2006)));
		assertEquals(d(31, MAY, 2006), d.getEndOfCurrentMonth(d(1, MAY, 2006)));
		assertEquals(d(30, JUNE, 2006),
				d.getEndOfCurrentMonth(d(1, JUNE, 2006)));
		assertEquals(d(31, JULY, 2006),
				d.getEndOfCurrentMonth(d(1, JULY, 2006)));
		assertEquals(d(31, AUGUST, 2006),
				d.getEndOfCurrentMonth(d(1, AUGUST, 2006)));
		assertEquals(d(30, SEPTEMBER, 2006),
				d.getEndOfCurrentMonth(d(1, SEPTEMBER, 2006)));
		assertEquals(d(31, OCTOBER, 2006),
				d.getEndOfCurrentMonth(d(1, OCTOBER, 2006)));
		assertEquals(d(30, NOVEMBER, 2006),
				d.getEndOfCurrentMonth(d(1, NOVEMBER, 2006)));
		assertEquals(d(31, DECEMBER, 2006),
				d.getEndOfCurrentMonth(d(1, DECEMBER, 2006)));
		assertEquals(d(29, FEBRUARY, 2008),
				d.getEndOfCurrentMonth(d(1, FEBRUARY, 2008)));
	}

	public void testWeekInMonthToString() throws Exception {
		assertEquals("First", weekInMonthToString(WeekInMonth.FIRST.getIndex()));
		assertEquals("Second", weekInMonthToString(WeekInMonth.SECOND.getIndex()));
		assertEquals("Third", weekInMonthToString(WeekInMonth.THIRD.getIndex()));
		assertEquals("Fourth", weekInMonthToString(WeekInMonth.FOURTH.getIndex()));
		assertEquals("Last", weekInMonthToString(WeekInMonth.LAST.getIndex()));

		// todo try {
		// weekInMonthToString(-1);
		// fail("Invalid week code should throw exception");
		// } catch (IllegalArgumentException e) {
		// }
	}

	public void testRelativeToString() throws Exception {
		assertEquals("Last", relativeToString(WeekdayRange.LAST.getIndex()));
		assertEquals("Nearest", relativeToString(WeekdayRange.NEAREST.getIndex()));
		assertEquals("Next", relativeToString(WeekdayRange.NEXT.getIndex()));

		// todo try {
		// relativeToString(-1000);
		// fail("Invalid relative code should throw exception");
		// } catch (IllegalArgumentException e) {
		// }
	}

	public void testCreateInstanceFromDDMMYYY() throws Exception {
		SerialDate date = DayDateFactory.makeDate(1, JANUARY, 1900);
		assertEquals(1, date.getDayOfMonth());
		assertEquals(JANUARY, date.getMonth());
		assertEquals(1900, date.getYYYY());
		assertEquals(2, date.toSerial());
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

	public static void main(String[] args) {
		junit.textui.TestRunner.run(BobsSerialDateTest.class);
	}
}
