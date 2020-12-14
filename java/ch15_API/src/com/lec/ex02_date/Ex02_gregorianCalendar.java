package com.lec.ex02_date;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Ex02_gregorianCalendar {
	public static void main(String[] args) {
		GregorianCalendar cal = new GregorianCalendar(); //싱글톤이 아님

		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH);
		int day = cal.get(Calendar.DAY_OF_MONTH);
		int week = cal.get(Calendar.DAY_OF_WEEK);
		int hour24 = cal.get(Calendar.HOUR_OF_DAY);
		int hour12 = cal.get(Calendar.HOUR);
		int ampm = cal.get(Calendar.AM_PM);
		int minute = cal.get(Calendar.MINUTE);
		int second = cal.get(Calendar.SECOND);
		int millisec = cal.get(Calendar.MILLISECOND);
		
		System.out.printf("%d년 %d월 %d일  ", year, month, day);
		switch(week) {
		case 1:
			System.out.println("일요일");
			break;
		case 2:
			System.out.println("월요일");
			break;
		case 3:
			System.out.println("화요일");
			break;
		case 4:
			System.out.println("수요일");
			break;
		case 5:
			System.out.println("목요일");
			break;
		case 6:
			System.out.println("금요일");
			break;
		case 7:
			System.out.println("토요일");
			break;
		}
		System.out.printf("%d시 %d분 %d초 %d \n", hour24, minute,second,millisec);
		System.out.printf("%tY년 %tm년 %td일 %ta요일 %tH시 %tM분 %tS초 \n",cal, cal, cal, cal, cal, cal, cal);
		System.out.printf("%1$tY년 %1$tm년 %1$td일 %1$ta요일 %1$tH시 %1$tM분 %1$tS초 \n",cal);
		System.out.print((ampm==0)? "오전":"오후");
		System.out.printf("%d시%d분%d초 \n", hour12, minute, second);
	}
}
