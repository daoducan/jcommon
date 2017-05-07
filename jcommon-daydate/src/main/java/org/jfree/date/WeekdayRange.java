package org.jfree.date;

public enum WeekdayRange {
	LAST(-1),
	NEAREST(0),
	NEXT(1);
	
	public static WeekdayRange make(int weekdayRangeIndex) {
		for (WeekdayRange wr : WeekdayRange.values()) {
			if (wr.index == weekdayRangeIndex) {
				return wr;
			}
		}
		throw new IllegalArgumentException("Invalid week in month index " + weekdayRangeIndex); 
	}
	
	WeekdayRange(int index) {
		this.index = index;
	}
	
	public final int index;
	
	public int getIndex() {
		return this.index;
	}
}