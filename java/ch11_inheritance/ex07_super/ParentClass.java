package com.lec.ex07_super;

public class ParentClass {
	private String pStr = "부모 클래스";
	public ParentClass() {
		System.out.println("부모 생성자");
	}
	public void getPapaName() {
		System.out.println("아빠 홍길동");
	}
	public void getMamaName() {
		System.out.println("엄마 김인자");
	}
	public String getpStr() {
		return pStr;
	}
	public void setpStr(String pStr) {
		this.pStr = pStr;
	}
}
