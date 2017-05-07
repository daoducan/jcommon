package org.jfree.date;

import java.util.Calendar;

public enum Weekday {
	MONDAY(Calendar.MONDAY),
	TUESDAY(Calendar.TUESDAY),
	WEDNESDAY(Calendar.WEDNESDAY),
	THURSDAY(Calendar.THURSDAY),
	FRIDAY(Calendar.FRIDAY),
	SATURDAY(Calendar.SATURDAY),
	SUNDAY(Calendar.SUNDAY);
	
	Weekday(int index) {
		this.index = index;
	}
	
	public static Weekday make(int weekDayIndex) {
		for (Weekday m : Weekday.values()) {
			if (m.index == weekDayIndex) {
				return m;
			}
		}
		throw new IllegalArgumentException("Invalid weekday index " + weekDayIndex); 
	}
	public int getIndex() {
		return this.index;
	}
	public final int index;
}