/* ========================================================================
 * JCommon : a free general purpose class library for the Java(tm) platform
 * ========================================================================
 *
 * (C) Copyright 2000-2006, by Object Refinery Limited and Contributors.
 * 
 * Project Info:  http://www.jfree.org/jcommon/index.html
 *
 * This library is free software; you can redistribute it and/or modify it 
 * under the terms of the GNU Lesser General Public License as published by 
 * the Free Software Foundation; either version 2.1 of the License, or 
 * (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY 
 * or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public 
 * License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, 
 * USA.  
 *
 * [Java is a trademark or registered trademark of Sun Microsystems, Inc. 
 * in the United States and other countries.]
 *
 * ---------------
 * SerialDate.java
 * ---------------
 * (C) Copyright 2001-2006, by Object Refinery Limited.
 *
 * Original Author:  David Gilbert (for Object Refinery Limited);
 * Contributor(s):   -;
 *
 * $Id: SerialDate.java,v 1.9 2011/10/17 20:08:22 mungady Exp $
 *
 * Changes (from 11-Oct-2001)
 * --------------------------
 * 11-Oct-2001 : Re-organised the class and moved it to new package 
 *               com.jrefinery.date (DG);
 * 05-Nov-2001 : Added a getDescription() method, and eliminated NotableDate 
 *               class (DG);
 * 12-Nov-2001 : IBD requires setDescription() method, now that NotableDate 
 *               class is gone (DG);  Changed getPreviousDayOfWeek(), 
 *               getFollowingDayOfWeek() and getNearestDayOfWeek() to correct 
 *               bugs (DG);
 * 05-Dec-2001 : Fixed bug in SpreadsheetDate class (DG);
 * 29-May-2002 : Moved the month constants into a separate interface 
 *               (MonthConstants) (DG);
 * 27-Aug-2002 : Fixed bug in addMonths() method, thanks to N???levka Petr (DG);
 * 03-Oct-2002 : Fixed errors reported by Checkstyle (DG);
 * 13-Mar-2003 : Implemented Serializable (DG);
 * 29-May-2003 : Fixed bug in addMonths method (DG);
 * 04-Sep-2003 : Implemented Comparable.  Updated the isInRange javadocs (DG);
 * 05-Jan-2005 : Fixed bug in addYears() method (1096282) (DG);
 * 
 */

package org.jfree.date;

import java.io.Serializable;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *  An abstract class that defines our requirements for manipulating dates,
 *  without tying down a particular implementation.
 *  <P>
 *  Requirement 1 : match at least what Excel does for dates;
 *  Requirement 2 : the date represented by the class is immutable;
 *  <P>
 *  Why not just use java.util.Date?  We will, when it makes sense.  At times,
 *  java.util.Date can be *too* precise - it represents an instant in time,
 *  accurate to 1/1000th of a second (with the date itself depending on the
 *  time-zone).  Sometimes we just want to represent a particular day (e.g. 21
 *  January 2015) without concerning ourselves about the time of day, or the
 *  time-zone, or anything else.  That's what we've defined SerialDate for.
 *  <P>
 *  You can call getInstance() to get a concrete subclass of SerialDate,
 *  without worrying about the exact implementation.
 *
 * @author David Gilbert
 */
public abstract class SerialDate implements Comparable,
                                            Serializable {

    /** For serialization. */
    private static final long serialVersionUID = -293716040467423637L;
    
    /** Date format symbols. */
    public static final DateFormatSymbols
        DATE_FORMAT_SYMBOLS = new SimpleDateFormat().getDateFormatSymbols();

    /** The number of days in a year up to the end of the preceding month. */
    static final int[] AGGREGATE_DAYS_TO_END_OF_PRECEDING_MONTH =
        {0, 0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334, 365};

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
    		WeekInMonth.make(code);
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

    /**
     * Creates a new date by adding the specified number of days to the base 
     * date.
     *
     * @param days  the number of days to add (can be negative).
     * @param base  the base date.
     *
     * @return a new date.
     */
    public SerialDate plusDays(final int days) {
    	
        return DayDateFactory.makeDate(getOrdinalDay() + days);
        
    }

    /**
     * Creates a new date by adding the specified number of months to the base 
     * date.
     * <P>
     * If the base date is close to the end of the month, the day on the result
     * may be adjusted slightly:  31 May + 1 month = 30 June.
     *
     * @param months  the number of months to add (can be negative).
     * @param base  the base date.
     *
     * @return a new date.
     */
    public SerialDate plusMonths(final int months) {

    	int thisMonthAsOrdinal = 12 * getYear() + getMonth() - 1;
    	int resultMonthAsOrdinal = thisMonthAsOrdinal + months;
    	int resultYear = resultMonthAsOrdinal / 12;
    	Month resultMonth = Month.make(resultMonthAsOrdinal % 12 + 1);
    	int lastDayOfResultMonth = lastDayOfMonth(resultMonth, resultYear);
    	int resultDay = Math.min(getDayOfMonth(), lastDayOfResultMonth);
    	return DayDateFactory.makeDate(resultDay, resultMonth, resultYear);
    	
    }

    /**
     * Creates a new date by adding the specified number of years to the base 
     * date.
     *
     * @param years  the number of years to add (can be negative).
     * @param base  the base date.
     *
     * @return A new date.
     */
    public SerialDate plusYears(final int years) {
	
    	int resultYear = getYear() + years;
    	int lastDayOfMonthInResultYear = lastDayOfMonth(Month.make(getMonth()), resultYear);
    	int resultDay = Math.min(getDayOfMonth(), lastDayOfMonthInResultYear);
    	return DayDateFactory.makeDate(resultDay, getMonth(), resultYear);
    	
    }

    /**
     * Returns the latest date that falls on the specified day-of-the-week and 
     * is BEFORE the base date.
     *
     * @param targetWeekday  a code for the target day-of-the-week.
     * @param base  the base date.
     *
     * @return the latest date that falls on the specified day-of-the-week and 
     *         is BEFORE the base date.
     */
    public SerialDate getPreviousDayOfWeek(Day targetDayOfWeek) {

    	int offsetToTarget = targetDayOfWeek.index - getDayOfWeek().index;
    	if (offsetToTarget >= 0) {
    		offsetToTarget -= 7;
    	}
    	return plusDays(offsetToTarget);

    }

    /**
     * Returns the earliest date that falls on the specified day-of-the-week
     * and is AFTER the base date.
     *
     * @param targetWeekday  a code for the target day-of-the-week.
     * @param base  the base date.
     *
     * @return the earliest date that falls on the specified day-of-the-week 
     *         and is AFTER the base date.
     */
    public SerialDate getFollowingDayOfWeek(Day targetDayOfWeek) {
    	
    	int offsetToTarget = targetDayOfWeek.index - getDayOfWeek().index;
    	if (offsetToTarget <= 0)
    		offsetToTarget += 7;
    	return plusDays(offsetToTarget);
    }

    /**
     * Returns the date that falls on the specified day-of-the-week and is
     * CLOSEST to the base date.
     *
     * @param targetDOW  a code for the target day-of-the-week.
     * @param base  the base date.
     *
     * @return the date that falls on the specified day-of-the-week and is 
     *         CLOSEST to the base date.
     */
    public SerialDate getNearestDayOfWeek(final Day targetDay) {

    	int offsetToThisWeeksTarget = targetDay.index - getDayOfWeek().index;
    	int offsetToFutureTarget = (offsetToThisWeeksTarget + 7) % 7;
    	int offsetToPreviousTarget = offsetToFutureTarget - 7;
    	if (offsetToFutureTarget > 3) {
    		return plusDays(offsetToPreviousTarget);
    	} else {
    		return plusDays(offsetToFutureTarget);
    	}
    	
    }

    /**
     * Rolls the date forward to the last day of the month.
     *
     * @param base  the base date.
     *
     * @return a new serial date.
     */
    public SerialDate getEndOfMonth() {
    	
    	Month month = Month.make(getMonth());
    	int year = getYear();
    	int lastDay = lastDayOfMonth(month, year);
    	return DayDateFactory.makeDate(lastDay, month, year);
    	
    }

    /**
     * Returns the serial number for the date, where 1 January 1900 = 2 (this
     * corresponds, almost, to the numbering system used in Microsoft Excel for
     * Windows and Lotus 1-2-3).
     *
     * @return the serial number for the date.
     */
    public abstract int getOrdinalDay();

    /**
     * Converts the date to a string.
     *
     * @return  a string representation of the date.
     */
    public String toString() {
        return getDayOfMonth() + "-" + Month.make(getMonth()).toString()
                               + "-" + getYear();
    }

    /**
     * Returns the year (assume a valid range of 1900 to 9999).
     *
     * @return the year.
     */
    public abstract int getYear();

    /**
     * Returns the month (January = 1, February = 2, March = 3).
     *
     * @return the month of the year.
     */
    public abstract int getMonth();

    /**
     * Returns the day of the month.
     *
     * @return the day of the month.
     */
    public abstract int getDayOfMonth();

    public abstract Day getDayOfWeekForOrdinalZero();
    
    /**
     * Returns the difference (in days) between this date and the specified 
     * 'other' date.
     *
     * @param other  the date being compared to.
     *
     * @return The difference (in days) between this date and the specified 
     *         'other' date.
     */
    public int daysSince(final SerialDate other) {
        return this.getOrdinalDay() - other.getOrdinalDay();
    }
    
    /**
     * Returns true if this SerialDate represents the same date as the
     * specified SerialDate.
     *
     * @param other  the date being compared to.
     *
     * @return <code>true</code> if this SerialDate represents the same date as
     *         the specified SerialDate.
     */
    public boolean isOn(final SerialDate other) {
        return (this.getOrdinalDay() == other.getOrdinalDay());
    }
    
    /**
     * Returns true if this SerialDate represents an earlier date compared to
     * the specified SerialDate.
     *
     * @param other  the date being compared to.
     *
     * @return <code>true</code> if this SerialDate represents an earlier date
     *         compared to the specified SerialDate.
     */
    public boolean isBefore(final SerialDate other) {
        return (this.getOrdinalDay() < other.getOrdinalDay());
    }
    
    /**
     * Returns true if this SerialDate represents the same date as the
     * specified SerialDate.
     *
     * @param other  the date being compared to.
     *
     * @return <code>true</code> if this SerialDate represents the same date
     *         as the specified SerialDate.
     */
    public boolean isOnOrBefore(final SerialDate other) {
        return (this.getOrdinalDay() <= other.getOrdinalDay());
    }
    
    /**
     * Returns true if this SerialDate represents the same date as the
     * specified SerialDate.
     *
     * @param other  the date being compared to.
     *
     * @return <code>true</code> if this SerialDate represents the same date
     *         as the specified SerialDate.
     */
    public boolean isAfter(final SerialDate other) {
        return (this.getOrdinalDay() > other.getOrdinalDay());
    }
    
    /**
     * Returns true if this SerialDate represents the same date as the
     * specified SerialDate.
     *
     * @param other  the date being compared to.
     *
     * @return <code>true</code> if this SerialDate represents the same date as
     *         the specified SerialDate.
     */
    public boolean isOnOrAfter(final SerialDate other) {
        return (this.getOrdinalDay() >= other.getOrdinalDay());
    }
    
    /**
     * Returns <code>true</code> if this {@link SerialDate} is within the 
     * specified range (caller specifies whether or not the end-points are 
     * included).  The date order of d1 and d2 is not important.
     *
     * @param d1  a boundary date for the range.
     * @param d2  the other boundary date for the range.
     * @param include  a code that controls whether or not the start and end 
     *                 dates are included in the range.
     *
     * @return A boolean.
     */
    /*public abstract boolean isInRange(SerialDate d1, SerialDate d2, 
                                      int include);*/
    public boolean isInRange(SerialDate d1, SerialDate d2, DateInterval interval) {
		int left = Math.min(d1.getOrdinalDay(), d2.getOrdinalDay());
		int right = Math.max(d1.getOrdinalDay(), d2.getOrdinalDay());
		return interval.isIn(getOrdinalDay(), left, right);
	}
    
    /**
     * Returns <code>true</code> if this {@link SerialDate} is within the 
     * specified range (INCLUSIVE).  The date order of d1 and d2 is not 
     * important.
     *
     * @param d1  a boundary date for the range.
     * @param d2  the other boundary date for the range.
     *
     * @return A boolean.
     */
    public boolean isInRange(SerialDate d1, SerialDate d2) {
    	return this.isInRange(d1, d2, DateInterval.CLOSED);
    }
    
    /**
     * Returns a java.util.Date.  Since java.util.Date has more precision than
     * SerialDate, we need to define a convention for the 'time of day'.
     *
     * @return this as <code>java.util.Date</code>.
     */
    public Date toDate() {
        final Calendar calendar = Calendar.getInstance();
        calendar.set(getYear(), getMonth() - 1, getDayOfMonth(), 0, 0, 0);
        return calendar.getTime();
    }
    
    public Day getDayOfWeek() {
    	Day startingDay = getDayOfWeekForOrdinalZero();
    	int startingOffset = startingDay.index - Day.SUNDAY.index;
    	return Day.make((getOrdinalDay() + startingOffset) % 7 + 1);
    }
    
}
