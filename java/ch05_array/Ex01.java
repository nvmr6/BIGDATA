package com.lec.ex;

public class Ex01 {
	public static void main(String[] args) {
		int[] iArr = {10,20,30,40,50}; // 1. �迭 ����� �ʱ�ȭ
		iArr[0] = 90; // �ε����� �� ����
		
		for(int idx=0;idx<5;idx++) {
			System.out.println(iArr[idx]);
		}//for������ ���
		System.out.println("");
		int[] jArr = new int[5]; // 2. �迭 ���� ����� �޸� �Ҵ�
		for(int idx=0;idx<jArr.length;idx++) {
			System.out.println("idx��°: " +jArr[idx]);
		}
		System.out.println("");
		int[] score; // 3. �迭 ���� ����
		score = new int[5];// �޸� �Ҵ�
		for(int idx=0;idx<score.length;idx++) {
			score[idx] = idx+1;// for���� �̿��� �� ����
			System.out.println((idx+1)+"��°: " +score[idx]);
		}
		
		for(int temp:score) {
			System.out.println(temp);
		}//Ȯ�� for��: �ӽ� ������ �迭�� ������ ������� �����´�. / �ε��� ������ ���� �� ����Ѵ�.
		System.out.println("");
	}
}
