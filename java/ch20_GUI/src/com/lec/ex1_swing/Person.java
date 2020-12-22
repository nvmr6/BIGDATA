package com.lec.ex1_swing;

public class Person {
	private String name;
	private String tel;
	private int age;
	public Person(String name, String tel, int age) {
		super();
		this.name = name;
		this.tel = tel;
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "[�̸�] "+name+"\t[��ȭ��ȣ] "+tel+"\t[����] "+age+"\n";
	}

	public String getName() {
		return name;
	}

	public String getTel() {
		return tel;
	}

	public int getAge() {
		return age;
	}
	
}
