package org.jfree.date;

public enum DateInterval {

	OPEN {
		@Override
		public boolean isIn(int d, int left, int right) {
			return false;
		}
	},
	CLOSED_LEFT {
		@Override
		public boolean isIn(int d, int left, int right) {
			return false;
		}
	},
	CLOSED_RIGHT {
		@Override
		public boolean isIn(int d, int left, int right) {
			return false;
		}
	},
	CLOSED {
		@Override
		public boolean isIn(int d, int left, int right) {
			return false;
		}
	};

	public abstract boolean isIn(int d, int left, int right);
}