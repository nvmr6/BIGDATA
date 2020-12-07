package com.lec.ex09_person;

public class Baby extends Person {
	public Baby() {
		
	}
	public Baby(String name, String character) {
		super(name, character); //부모간의 생성자, 매개변수 없는 생성자 호출되지 않음, 항상 위로, 매개변수 있는 생성자쪽으로 유도
		System.out.println("매개변수 없는 Person 생성자");
//		setName(name);
//		setCharacter(character);
	}
	public void cry() {
		System.out.println("cry");
	}
	@Override
	public void intro() {
		System.out.println(getName()+"은 대신 소개");
		super.intro();
	}

}
