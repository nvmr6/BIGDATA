package com.lec.ex;

public class Ex03 {
	public static void main(String[] args){
		//관계연산자: == / != / <,>,=<,>=
		int n1 = 10, n2 = 5;
		boolean result;
		
		result = n1 > n2;
		System.out.printf("%d %s %d는 %b \n", n1, ">", n2, result);
		result = n1 < n2;
		System.out.printf("%d %s %d는 %b \n", n1, "<", n2, result);
		result = n1 >= n2;
		System.out.printf("%d %s %d는 %b \n", n1, ">=", n2, result);
		result = n1 <= n2;
		System.out.printf("%d %s %d는 %b \n", n1, "<=", n2, result);
		result = n1 == n2;
		System.out.printf("%d %s %d는 %b \n", n1, "==", n2, result);
		result = n1 != n2;
		System.out.printf("%d %s %d는 %b \n", n1, "!=", n2, result);
	}
}
