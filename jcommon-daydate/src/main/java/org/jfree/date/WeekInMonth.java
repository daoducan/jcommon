package org.jfree.date;

public enum WeekInMonth {
	FIRST(1),
	SECOND(2),
	THIRD(3),
	FOURTH(4),
	LAST(0);
	
	public static WeekInMonth fromInt(int weekInMonthIndex) {
		for (WeekInMonth wm : WeekInMonth.values()) {
			if (wm.index == weekInMonthIndex) {
				return wm;
			}
		}
		throw new IllegalArgumentException("Invalid week in month index " + weekInMonthIndex); 
	}
	
	public final int index;
	
	WeekInMonth(int index) {
		this.index = index;
	}
	
	public int getIndex() {
		return this.index;
	}
	
	public String toString() {
		
        switch (this) {
            case FIRST : return "First";
            case SECOND : return "Second";
            case THIRD : return "Third";
            case FOURTH : return "Fourth";
            case LAST : return "Last";
            default :
                return "SerialDate.weekInMonthToString(): invalid code.";
        }
        
    }
}