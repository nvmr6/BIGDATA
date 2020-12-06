package com.lec.ex5_momchild;

public class ChildTestMain {
	public static void main(String[] args) {
		Child child1 = new Child("Los");
		Child child2 = new Child("Joe");
		Child child3 = new Child("Monica");
		
//		child1.takeMoney(1000);
//		child1.takeMoney(1000);
//		
//		child2.takeMoney(1000);//객체가 바뀌면 잔고가 초기화된다.
//		child3.takeMoney(1000);
		
		child1.takeMoney(1000);
		child2.takeMoney(1000);
		child3.takeMoney(1000); // momPouch를 공유한다.
		
//		System.out.println("첫째 엄마 지갑"+child1.momPouch.money);
//		System.out.println("둘째 엄마 지갑"+child2.momPouch.money);
//		System.out.println("셋째 엄마 지갑"+child3.momPouch.money);
		
		System.out.println("static엄마 지갑: "+Child.momPouch.money);
	}
}
