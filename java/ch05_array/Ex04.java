package com.lec.ex;

public class Ex04 {
	public static void main(String[] args) {
		int[][] test = {{10,20,30},{40,50,60},{70,80,90}};
		System.out.println(test[1][1]);
		test[2][1] = 1000;
		System.out.println(test[2][1]);
		
		for(int i=0;i<test.length;i++) {
			for(int j=0;j<test[i].length;j++) {
				System.out.print(test[i][j]+"\t");
			}
			System.out.println("");
		}
	}
}
