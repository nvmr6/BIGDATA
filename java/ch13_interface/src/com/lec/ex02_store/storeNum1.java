package com.lec.ex02_store;

public class storeNum1 implements HeadQuarterStore {
	private String name; //클래스에서 초기화
	public storeNum1(String name) {
		this.name = name;
	}
	@Override
	public void kimchi() {
		System.out.println("부대찌개 4,500원");
	}
	@Override
	public void bood() {
		System.out.println("부대찌개 5,000원");
	}
	@Override
	public void bibim() {
		System.out.println("비빔밥 6,000원");
	}
	@Override
	public void soon() {
		System.out.println("순대국 팔지 않습니다.");
	}
	@Override
	public void kong() {
		System.out.println("공기밥 1,000원");
	}
	public String getName() {
		return name;
	}//오버라이드
	
}
