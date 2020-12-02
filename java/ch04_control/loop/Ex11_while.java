package com.lec.loop;

public class Ex11_while {
	public static void main(String[] args) {
		int i=1;
		int sum = 0;
		while(i<=10) {
			sum+=i;
			System.out.println("i가 "+i+"일 때 누적합은  "+sum+"이다");
			i++;
		}
	}
}
