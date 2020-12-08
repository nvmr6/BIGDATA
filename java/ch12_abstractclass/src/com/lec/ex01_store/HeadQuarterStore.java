package com.lec.ex01_store;

public abstract class HeadQuarterStore { //클래스에도 abstract 표기 > abstract 클래스
	private String name;
	public HeadQuarterStore(String name) {
		this.name = name;
	}
	//abstract > 반드시 오버라이드, 추상 메소드
	public abstract void kimchi();
	public abstract void bood();
	public abstract void bibim();
	public abstract void soon();
	public abstract void kong();
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
