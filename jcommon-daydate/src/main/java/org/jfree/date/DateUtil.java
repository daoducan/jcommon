package org.jfree.date;

import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;

public class DateUtil {

	/** Date format symbols. */
	public static final DateFormatSymbols
		DATE_FORMAT_SYMBOLS = new SimpleDateFormat().getDateFormatSymbols();
	
	/**
     * Returns a string representing the supplied day-of-the-week.
     * <P>
     * Need to find a better approach.
     *
     * @param weekday  the day of the week.
     *
     * @return a string representing the supplied day-of-the-week.
     */
    public static String weekdayCodeToString(final int weekday) {

        final String[] weekdays = DATE_FORMAT_SYMBOLS.getWeekdays();
        return weekdays[weekday];

    }

    /**
     * Returns an array of month names.
     *
     * @return an array of month names.
     */
    public static String[] getMonthNames() {

        return DATE_FORMAT_SYMBOLS.getMonths();

    }

    /**
     * Returns true if the supplied integer code represents a valid 
     * week-in-the-month, and false otherwise.
     *
     * @param code  the code being checked for validity.
     * @return <code>true</code> if the supplied integer code represents a 
     *         valid week-in-the-month.
     */
    public static boolean isValidWeekInMonthCode(final int code) {
    	
    	try {
    		WeekInMonth.fromInt(code);
    		return true;
    	} catch(IllegalArgumentException e) {
    		return false;
    	}

    }

    /**
     * Determines whether or not the specified year is a leap year.
     *
     * @param yyyy  the year (in the range 1900 to 9999).
     *
     * @return <code>true</code> if the specified year is a leap year.
     */
    public static boolean isLeapYear(final int yyyy) {
    	
    	boolean fourth = yyyy % 4 == 0;
    	boolean hundredth = yyyy % 100 == 0;
    	boolean fourHundredth = yyyy % 400 == 0;
    	return fourth && (!hundredth || fourHundredth);
    	
    }

    /**
     * Returns the number of the last day of the month, taking into account 
     * leap years.
     *
     * @param month  the month.
     * @param yyyy  the year (in the range 1900 to 9999).
     *
     * @return the number of the last day of the month.
     */
    public static int lastDayOfMonth(Month month, int yyyy) {
    	
        if (month == Month.FEBRUARY && isLeapYear(yyyy)) {
        	return month.lastDay() + 1;
        } else {
        	return month.lastDay();
        }
        
    }
}
