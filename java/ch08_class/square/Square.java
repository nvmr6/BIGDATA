package com.lec.square;
//Square s1 =new Square();
//Square s2 =new Square(10);

public class Square {
	private int side;
	public Square() { // > s1 > 생성자 오버로딩
		System.out.println("매개변수 없는 생성자 호출");
	}// (매개변수 없는)생성자 함수 / 클래스 이름과 같게
	public Square(int side) { // > s2 매개변수 있는 생성자를 만들면 없는 생성자도 생긴다
		this.side/*객체의 side*/ = side;//매개변수 side
		System.out.println("매개변수 있는 생성자 호출");
	}
	public int area() {
		return side*side;
	}
	
	public int getSide() {
		return side;
	}
	
	public void setSide(int side) {
		 this.side =side;
	}
}
