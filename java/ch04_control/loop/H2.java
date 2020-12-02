package com.lec.loop;

public class H2 {
	public static void main(String[] args) {
		for(int i=1;i<=6;i++) {
			for(int j=1;j<=6;j++) {
				int sum=i+j;
				if(sum==6) {
					System.out.printf("첫번째 주사위: %d, 두번째 주사위: %d\n",i,j);
				}
			}
		}
	}
}
