package com.lec.ex;

public class Ex02 {
	public static void main(String[] args) {
		int[] score = {10,20,30,40,50};
		int[] s = score; //���� �ּҸ� ����Ų��
		s[0] = 100;//����Ű�� �ּҰ� ���� ������ ����Ų �迭�� ���� �����ϸ� ����ȴ�.
		for(int idx=0;idx<score.length;idx++) {
			System.out.println(idx+1+"��°: " +score[idx]);
			System.out.println(idx+1+"��°: " +s[idx]);
			System.out.println("");
		}
	}
	
}
