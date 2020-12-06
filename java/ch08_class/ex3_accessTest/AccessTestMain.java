package com.lec.ex3_accessTest;

public class AccessTestMain {
	public static void main(String[] args) {
		AccessTest obj = new AccessTest();
		//System.out.println(obj.privatemember);
		System.out.println(obj.defaultmember); //같은 패키지
		System.out.println(obj.protectedmember);//같은 패키지나 상속 클래스
		System.out.println(obj.publicmember);//전체
		
		//obj.privatemethod();
		obj.defaultmethod();
		obj.protectedmethod();
		obj.publicmethod();
	}
}
