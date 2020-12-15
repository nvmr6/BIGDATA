package com.lec.ex04_object;

public class Customer {
	private String tel;
	private String name;
	private int point;
	private int amount;
	public Customer(String tel, String name) {
		this.tel = tel;
		this.name = name;
		point = 1000;
	}
	@Override
	public String toString() {
		return name+"("+tel.substring((tel.lastIndexOf("-")+1))+")"+"님의 포인트: "+point+" 누적금액: "+amount;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj!=null && obj instanceof Customer) {
			return (tel == ((Customer)obj).tel);
		}
		return false;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
}
