package com.lec.ex01_store;

public class storeNum3 extends HeadQuarterStore {
	public storeNum3(String name) {
		super(name);
	}
	@Override
	public void kimchi() {
		System.out.println("부대찌개 6,000원");
	}
	@Override
	public void bood() {
		System.out.println("부대찌개 7,000원");
	}
	@Override
	public void bibim() {
		System.out.println("비빔밥 7,000원");
	}
	@Override
	public void soon() {
		System.out.println("순대국 6,000원");
	}
	@Override
	public void kong() {
		System.out.println("공기밥 1,000원");
	}
}
