package com.lec.ex02_store;

public class storeNum2 implements HeadQuarterStore {
	private String name;
	public storeNum2(String name) {
		this.name = name;
	}
	
	@Override
	public void kimchi() {
		System.out.println("부대찌개 5,000원");
	}
	@Override
	public void bood() {
		System.out.println("부대찌개 5,000원");
	}
	@Override
	public void bibim() {
		System.out.println("비빔밥 5,000원");
	}
	@Override
	public void soon() {
		System.out.println("순대국 5,000원");
	}
	@Override
	public void kong() {
		System.out.println("공기밥 무료입니다.");
	}
	public String getName() {
		return name;
	}//오버라이드
	
}
