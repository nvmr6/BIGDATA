package com.lec.condition;

public class Ex05_if {
    public static void main(String[] args) {
		int num1 = 27;
		int num2 = 32;
		int max; //if문 밖에서 선언해야 모든 메인 안에서 사용가능
		if(num1>num2){
			max = num1;
		} else {
			max = num2;
		}
		System.out.println(max);
    }
}
