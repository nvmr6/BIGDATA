package com.lec.ex3_exceptions;

public class Friend {
	private String name;
	private String tel;
	public Friend() {}
	public Friend(String name, String tel) {
		this.name = name;
		this.tel = tel;
	}
	@Override
	public String toString() {
		String post = tel.substring(tel.lastIndexOf("-")+1);
		return "Friend [name=" + name + ", tel= 010-****-" + post + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
}
