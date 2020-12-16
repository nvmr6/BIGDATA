package com.lec.ex3_exceptions;

public class Ex2_numberFormat {
	public static void main(String[] args) {
		int i = 0;
		String str = "";
		try {
			i = Integer.parseInt(str.trim());
		}catch(NumberFormatException e) {
			System.out.println(e.getMessage());
		}
		System.out.println(i);
	}
	
}
