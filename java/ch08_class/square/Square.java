package com.lec.square;
//Square s1 =new Square();
//Square s2 =new Square(10);

public class Square {
	private int side;
	public Square() { // > s1 > ������ �����ε�
		System.out.println("�Ű����� ���� ������ ȣ��");
	}// (�Ű����� ����)������ �Լ� / Ŭ���� �̸��� ����
	public Square(int side) { // > s2 �Ű����� �ִ� �����ڸ� ����� ���� �����ڵ� �����
		this.side/*��ü�� side*/ = side;//�Ű����� side
		System.out.println("�Ű����� �ִ� ������ ȣ��");
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
