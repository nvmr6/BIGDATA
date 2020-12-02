package com.lec.ex;

public class Ex02 {
	public static void main(String[] args) {
		int[] score = {10,20,30,40,50};
		int[] s = score; //같은 주소를 가르킨다
		s[0] = 100;//가르키는 주소가 같기 때문에 가르킨 배열의 값을 변경하면 변경된다.
		for(int idx=0;idx<score.length;idx++) {
			System.out.println(idx+1+"번째: " +score[idx]);
			System.out.println(idx+1+"번째: " +s[idx]);
			System.out.println("");
		}
	}
	
}
