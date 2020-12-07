package com.lec.ex11_store;

public class storeNum2 extends HeadQuarterStore {
	public storeNum2(String name) {
		super(name);
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
	public void kong() {
		System.out.println("공기밥 무료입니다.");
	}
}
