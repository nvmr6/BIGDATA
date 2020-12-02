package com.lec.condition;

public class Ex02_if {
	public static void main(String[] args) {
		int seoulLunchPrice = 7000;
		if(seoulLunchPrice>7000) {
			System.out.println("ºñ½Î³×");
		}else if(seoulLunchPrice >= 6000) {
			System.out.println("±×³É±×·¯³×");
		}else if(seoulLunchPrice >=4000) {
			System.out.println("±¦Âú³×");
		}else {
			System.out.println("Àú·ÅÇÏ³×");
		}
	}
}
