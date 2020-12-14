package com.lec.ex02_date;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class Ex05_GreSimpleFormat {
	public static void main(String[] args) {
		GregorianCalendar gc = new GregorianCalendar();
		SimpleDateFormat sdf = new SimpleDateFormat("a hh시 mm분 ss초 SS"); // SDF
		System.out.println(sdf.format(gc.getTime()));
		
	}
}
