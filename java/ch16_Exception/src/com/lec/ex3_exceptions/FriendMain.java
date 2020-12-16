package com.lec.ex3_exceptions;

public class FriendMain {
	public static void main(String[] args) {
		Friend f1 = new Friend();
		Friend f2 = new Friend("홍길동", "010-7986-3345");
		System.out.println(f2);
		System.out.println(f1); //nullpointexception
	}
}
