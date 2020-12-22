package com.lec.ex1_swing;

public class Customer {
	private String tel;
	private String name;
	private int point;
	public Customer(String tel, String name, int point) {
		this.tel = tel;
		this.name = name;
		this.point = point;
	}
	@Override
	public String toString() {
		return name+"("+tel+")  : " + point;
	}
	public String getTel() {
		return tel;
	}
	public String getName() {
		return name;
	}
	public int getPoint() {
		return point;
	}
}
