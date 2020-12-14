package com.lec.ex02_date;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Ex04_CalSimpleFormat {
	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		//2020년 12월 14일 3시 03분 24초
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 E요일 a hh시 mm분 ss초 SS"); // SDF
		String today = sdf.format(cal.getTime());// String으로 변경
		System.out.println(today);
	}
}
