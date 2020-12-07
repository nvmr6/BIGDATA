package com.lec.ex11_store;

public class storeNum1 extends HeadQuarterStore {
	public storeNum1(String name) {
		super(name);
	}
	
	@Override
	public void bood() {
		System.out.println("부대찌개 5,000원");
	}
	@Override
	public void soon() {
		System.out.println("순대국 팔지 않습니다.");
	}
}
