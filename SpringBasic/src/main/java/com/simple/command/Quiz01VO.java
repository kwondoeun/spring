package com.simple.command;

import java.util.List;

public class Quiz01VO {
	
	private String year;
	private String month;
	private String day;
	
	public Quiz01VO() {}

	@Override
	public String toString() {
		return "Quiz01VO [year=" + year + ", month=" + month + ", day=" + day + "]";
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}
	
	
	

}
