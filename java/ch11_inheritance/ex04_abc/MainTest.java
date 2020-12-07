package com.lec.ex04_abc;

public class MainTest {
	public static void main(String[] args) {
		S a = new A(); //A a = new A(); 와 같다 / 타입 통일화 / 다형성
		S b = new B(); //B b = new B();
		S c = new C(); //C c = new C();
		//아래에서 위로는 가능
		//A s = new S(); 반대로는 불가능
		S[] objArr = {a, b, c};
		for(S obj : objArr) {
			System.out.println(obj.s);// a.s, b.s, c.s
		}
	}
}
