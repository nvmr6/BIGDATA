package com.lec.ex02_date;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class Employee {
	private String num;
	private String name;
	private PartType part; //데이터의 무결성
	private Date enterDate;
	
	public Employee(String num, String name, PartType part) {
		this.num = num;
		this.name = name;
		this.part = part;
		enterDate = new Date();
	}
	public Employee(String num, String name, PartType part, int year, int month, int day) {
		this.num = num;
		this.name = name;
		this.part = part;
		enterDate = new Date(new GregorianCalendar(year, month-1, day).getTimeInMillis());
	}
	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
//		String result = String.format("[사번]%s [이름]%s [부서]%s [입사일]%s",
//				                num, name, part, sdf.format(enterDate));
//		return result;
		String result ="[사번]"+num  + " [이름]" +name +
				      " [부서]"+part + " [입사일]"+sdf.format(enterDate);
		return result;
	}
}
