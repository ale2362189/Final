package com.promineotech.storeApp.util;

public enum Percentage {

	FIVE(.05),
	TEN(.10);
	
private double percent;
	
	Percentage(double percent) {
		this.percent = percent;
	}
	
	public double getPercent() {
		return percent;
	}
}
