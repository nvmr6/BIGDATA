package com.lec.ex06_this;

public class Friend {
	private String name;
	private String tel;
	public Friend() {
		System.out.println("매개변수 0개");
	}
	public Friend(String name) {
		this(); // 현 클래스의 생성자 함수
		this.name = name;
		System.out.println("매개변수 1개");
	}
	public Friend(String name, String tel) {
		this(name); //매개변수 1개짜리를 호출 및 초기화
		this.tel = tel;
		System.out.println("매개변수 3개");
	}
}
