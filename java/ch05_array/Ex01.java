package com.lec.ex;

public class Ex01 {
	public static void main(String[] args) {
		int[] iArr = {10,20,30,40,50}; // 1. 배열 선언과 초기화
		iArr[0] = 90; // 인덱스로 값 변경
		
		for(int idx=0;idx<5;idx++) {
			System.out.println(iArr[idx]);
		}//for문으로 출력
		System.out.println("");
		int[] jArr = new int[5]; // 2. 배열 변수 선언과 메모리 할당
		for(int idx=0;idx<jArr.length;idx++) {
			System.out.println("idx번째: " +jArr[idx]);
		}
		System.out.println("");
		int[] score; // 3. 배열 변수 선언
		score = new int[5];// 메모리 할당
		for(int idx=0;idx<score.length;idx++) {
			score[idx] = idx+1;// for문을 이용한 값 변경
			System.out.println((idx+1)+"번째: " +score[idx]);
		}
		
		for(int temp:score) {
			System.out.println(temp);
		}//확장 for문: 임시 변수가 배열의 값들을 순서대로 가져온다. / 인덱스 수정이 없을 때 사용한다.
		System.out.println("");
	}
}
