package com.lec.ex01_string;
//이름 전화번호 생일
//print method
public class Friend {
	private String name;
	private String tel;
	private String birth;
		
	public Friend(String name, String tel, String birth) {
		this.name = name;
		this.tel = tel;
		this.birth = birth;
	}
	public void print() {
		System.out.printf("[이름]%s[전화번호]%s[생일]%s\n", name, tel, birth);
	}
	public String getName() {
		return name;
	}
	public String getTel() {
		return tel;
	}
	public String getBirth() {
		return birth;
	}
	@Override
	public String toString() {
		return "[이름]"+name+"[전화번호]"+tel+"[생일]"+birth;
	}
	
}
