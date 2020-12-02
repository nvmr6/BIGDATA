package com.lec.loop;

public class Ex09_for {
	public static void main(String[] args) {
		for(int i=1;i<=9;i++) {
			for(int j=2;j<=9;j++) {
				System.out.printf("%d x %d = %d\t",j,i,i*j);
			}
		System.out.println("");
		}
	}
}
