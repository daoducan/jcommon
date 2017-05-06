package org.jfree.date;

public abstract class DayDateFactory {
	private static DayDateFactory factory = new SpreadsheetDateFactory();

	public static void setInstance(DayDateFactory factory) {
		DayDateFactory.factory = factory;
	}

	protected abstract SerialDate _makeDate(int ordinal);

	protected abstract SerialDate _makeDate(int day, Month month, int year);

	protected abstract SerialDate _makeDate(int day, int month, int year);

	protected abstract SerialDate _makeDate(java.util.Date date);

	protected abstract int _getMinimumYear();

	protected abstract int _getMaximumYear();

	public static SerialDate makeDate(int ordinal) {
		return factory._makeDate(ordinal);
	}

	public static SerialDate makeDate(int day, Month month, int year) {
		return factory._makeDate(day, month, year);
	}

	public static SerialDate makeDate(int day, int month, int year) {
		return factory._makeDate(day, month, year);
	}

	public static SerialDate makeDate(java.util.Date date) {
		return factory._makeDate(date);
	}

	public static int getMinimumYear() {
		return factory._getMinimumYear();
	}

	public static int getMaximumYear() {
		return factory._getMaximumYear();
	}
}
