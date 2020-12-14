package com.lec.ex01_string;

import java.util.StringTokenizer;

public class Ex11_Tokenizer {
	public static void main(String[] args) {
		String str1 = "정해인 유준상 강동원 김윤석 하정우";
		String str2 = "2020-12-14";
		//space, \t, \n단위로 나눈다.
		StringTokenizer token1 = new StringTokenizer(str1);
		StringTokenizer token2 = new StringTokenizer(str2, "-");
		
		System.out.println("str1의 문자열수: "+token1.countTokens());
		System.out.println("str2의 문자열수: "+token2.countTokens());
		
		while(token1.hasMoreTokens()) {
			System.out.println(token1.nextToken());
		}
		while(token2.hasMoreTokens()) {
			System.out.println(token2.nextToken());
		}
	}
}
