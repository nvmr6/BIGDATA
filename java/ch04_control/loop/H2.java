package com.lec.loop;

public class H2 {
	public static void main(String[] args) {
		for(int i=1;i<=6;i++) {
			for(int j=1;j<=6;j++) {
				int sum=i+j;
				if(sum==6) {
					System.out.printf("ù��° �ֻ���: %d, �ι�° �ֻ���: %d\n",i,j);
				}
			}
		}
	}
}
