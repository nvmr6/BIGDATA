package com.lec.ex02_date;

import java.util.Date;

public class Ex03_Date {
	public static void main(String[] args) {
		Date date = new Date();
		
		int year = date.getYear()+1900;
		int month = date.getMonth()+1;
		int day = date.getDate();
		int hour = date.getHours();
		int minute = date.getMinutes();
		int second = date.getSeconds();
		System.out.printf("%d.%d.%d %d:%d:%d", year, month,day, hour, minute,second);
	}
}
