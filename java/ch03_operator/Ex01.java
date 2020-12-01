package com.lec.ex;

public class Ex01 {
	public static void main(String[] args) {
		//산술 연산자
		int n1 = 33, n2 = 10;
		int result;
		double resultDouble;
		
		result = n1 + n2;
		System.out.printf("%d %c %d = %d\n\n",  n1, '+', n2, result);
		result = n1 - n2;
		System.out.printf("%d %c %d = %d\n\n",  n1, '-', n2, result);
		result = n1 * n2;
		System.out.printf("%d %c %d = %d\n\n",  n1, '*', n2, result);
		
		resultDouble = (double)n1 / n2; //명시적 형변환 4바이트 > 8바이트
		System.out.printf("%d %c %d = %.1f\n\n",  n1, '/', n2, resultDouble);
		result = n1 % n2;
		System.out.printf("%d %c %d = %d\n\n",  n1, '%', n2, result);
		
		//나머지 연산자의 쓰임새
		if((n1%2)==0)
			System.out.println("짝수");
		else
			System.out.println("홀수");
	}
}
