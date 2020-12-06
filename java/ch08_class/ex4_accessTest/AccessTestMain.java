package com.lec.ex4_accessTest;

import com.lec.ex3_accessTest.AccessTest; //import로 사용가능

public class AccessTestMain {
	public static void main(String[] args) {
		AccessTest obj = new AccessTest();
		//System.out.println(obj.privatemember);
		//System.out.println(obj.defaultmember); //다른 패키지 패키지
		//System.out.println(obj.protectedmember);//상속받지 않음
		System.out.println(obj.publicmember);//전체
		
		//obj.privatemethod();
		//obj.defaultmethod();
		//obj.protectedmethod();
		obj.publicmethod();
	}
}
