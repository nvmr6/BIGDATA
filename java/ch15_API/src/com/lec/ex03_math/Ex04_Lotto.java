package com.lec.ex03_math;

import java.util.Random;

public class Ex04_Lotto {
	public static void main(String[] args) {
		int[] lotto = new int[6];
		Random random = new Random();
		for(int a = 0;a<5;a++) {
			for(int i=0;i<6;i++) {
				int temp = (random.nextInt(45)+1);
				int j;
				for(j=0; j<i;j++) {
					if(temp == lotto[j]) {
						i--;//인덱스 뒤로
						break; //첫 for문으로, j반복문 밖으로
					}
				}//for 중복확인
				if(i==j) {
					lotto[i] = temp;
				}
			}
			for(int i=0;i<lotto.length;i++ ) {
				System.out.print(lotto[i]+"\t");
			}
			System.out.println();
		}
	}
}
