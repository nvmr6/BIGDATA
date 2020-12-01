package com.lec.question;

public class Q5 {
	public static void main(String[] args) {
		int kor = 92, eng = 89, math = 72;
		System.out.printf("±¹¾î: %d\t¿µ¾î: %d\t¼öÇÐ: %d\t \n",kor,eng,math);
		int sum = kor+eng+math;
		double avg = sum/3.0;
		System.out.printf("ÃÑÁ¡: %d Æò±Õ: %.2f",sum,avg);
	}
}
