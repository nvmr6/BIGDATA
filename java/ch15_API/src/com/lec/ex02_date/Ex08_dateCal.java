package com.lec.ex02_date;

import java.util.Date;
import java.util.GregorianCalendar;

public class Ex08_dateCal {
	public static void main(String[] args) {
		GregorianCalendar now = new GregorianCalendar();
		long nowMillis = now.getTimeInMillis();//1970부터
		GregorianCalendar then = new GregorianCalendar(2020,10,30,9,30,0); //0월부터 시작
		long thenMillis = then.getTimeInMillis();//1970부터
		int day = (int)(nowMillis - thenMillis)/(1000*60*60*24);
		System.out.println(day);
		
		Date thatDay = new Date(new GregorianCalendar(2020,10,30,9,30,0).getTimeInMillis());
	}
}
