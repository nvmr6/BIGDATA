package com.lec.ex11_store;

public class HeadQuarterStore {
	private String name;
	public HeadQuarterStore(String name) {
		this.name = name;
	}
	public void kimchi() {
		System.out.println("김치찌개 5,000원");
	}
	public void bood() {
		System.out.println("부대찌개 6,000원");
	}
	public void bibim() {
		System.out.println("비빔밥 6,000원");
	}
	public void soon() {
		System.out.println("순대국 5,000원");
	}
	public void kong() {
		System.out.println("공기밥 1,000원");
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
