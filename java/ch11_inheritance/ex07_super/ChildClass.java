package com.lec.ex07_super;

public class ChildClass extends ParentClass{
	private String cStr = "자식 클래스";
	public ChildClass() {
		System.out.println("자식 생성자");
	}
	@Override
	public void getMamaName() {
		//this 내 객체의
		//this() 현 클래스의 생성자 함수
		//super. 부모 클래스의 (위치의 제약이 없다)
		//super() 부모 클래스 생성자 (반드시 맨 윗줄 작성)
		System.out.println("AAA");
		super.getMamaName(); // 
	}
	public String getcStr() {
		return cStr;
	}
	public void setcStr(String cStr) {
		this.cStr = cStr;
	}
	
}
