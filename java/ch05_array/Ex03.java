package com.lec.ex;

public class Ex03 {
	public static void main(String[] args) {
		int[] score = {10,20,30,40,50};
		int[] s = new int[score.length]; //s에는 데이터는 없고 score와 같은 메모리 크기만 할당
//		for(int i=0;i<score.length;i++) {
//			s[i] = score[i]; //배열은 같아지나 주소는 다른 주소
//		}
		System.arraycopy(score, 0, s, 0, 5); //API 사용
		s[0] = 1000;
		for(int i=0;i<score.length;i++) {
			System.out.println(i+1+"번째: " +score[i]+" / "+s[i]);//배열의 복사
		}
	}
}
