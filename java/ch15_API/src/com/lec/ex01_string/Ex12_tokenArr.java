package com.lec.ex01_string;

import java.util.StringTokenizer;

public class Ex12_tokenArr {
	public static void main(String[] args) {
		String str = "정해인 유준상 강동원 김윤석 하정우";
		String[] names;
		StringTokenizer token = new StringTokenizer(str);
		names = new String[token.countTokens()]; //배열크기를 잡음
		int idx = 0;
		while(token.hasMoreTokens()) {
			names[idx++] = token.nextToken();
		}
		for(String temp:names) {
			System.out.println(temp);
		}
	}
}
