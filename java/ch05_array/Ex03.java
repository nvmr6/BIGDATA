package com.lec.ex;

public class Ex03 {
	public static void main(String[] args) {
		int[] score = {10,20,30,40,50};
		int[] s = new int[score.length]; //s���� �����ʹ� ���� score�� ���� �޸� ũ�⸸ �Ҵ�
//		for(int i=0;i<score.length;i++) {
//			s[i] = score[i]; //�迭�� �������� �ּҴ� �ٸ� �ּ�
//		}
		System.arraycopy(score, 0, s, 0, 5); //API ���
		s[0] = 1000;
		for(int i=0;i<score.length;i++) {
			System.out.println(i+1+"��°: " +score[i]+" / "+s[i]);//�迭�� ����
		}
	}
}
