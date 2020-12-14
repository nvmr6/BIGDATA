package com.lec.ex02_date;

public class Ex09_Employee {
	public static void main(String[] args) {
		Employee s1 = new Employee("a01", "홍길동", PartType.COMPUTER);
		Employee s2 = new Employee("a02", "김길동", PartType.ACCOUNTING, 2016,04,05);
		System.out.println(s1);
		System.out.println(s2);
	}
}
