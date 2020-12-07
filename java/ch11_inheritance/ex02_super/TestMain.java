package com.lec.ex02_super;

public class TestMain {
	public static void main(String[] args) {
		Child2 child = new Child2(10,20);//클래스에 매개변수 있는 생성자를 만들면 객체에서 변수 사용 가능
		System.out.println("i값 출력: "+child.getI()); //변수가 private이면 get으로 사용
		System.out.println("j값 출력: "+child.getJ());
		
		child.setI(10);
		child.setJ(20);
		System.out.println("i값 출력: "+child.getI());
		System.out.println("j값 출력: "+child.getJ());
		child.sum();
	}
}
