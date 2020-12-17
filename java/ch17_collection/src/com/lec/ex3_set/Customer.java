package com.lec.ex3_set;

public class Customer {
	private String name;
	private String phone;
	private String address;

	public Customer(String name, String phone, String address) {
		this.name = name;
		this.phone = phone;
		this.address = address;
	}
	
	@Override
	public String toString() {
		return name+" "+phone+" "+address;
	}
	@Override
	public boolean equals(Object obj) { //같은 문자열 중복 방지
		if(this==obj) {
			return true;
		}
		if(obj!=null && obj instanceof Customer) {
			boolean nameChk = name.equals(((Customer)obj).name);
			boolean phoneChk = phone.equals(((Customer)obj).phone);
			boolean addressChk = address.equals(((Customer)obj).address);
			return nameChk && phoneChk && addressChk;
		}
		return false;
	}
	@Override
	public int hashCode() {
		return toString().hashCode(); // 결과 문자열의 해쉬코드 출력 
	}
}
