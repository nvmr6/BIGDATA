package com.lec.ex02_date;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Ex06_DateSimpleFormat {
	public static void main(String[] args) {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd일 E요일 a hh:mm:ss.SS");
		System.out.println(sdf.format(date));
	}
}
