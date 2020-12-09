package com.lec.ex10_library;

public class TestMain {
	public static void main(String[] args) {
		Book book1 = new Book("1q2w3e4r", "자바", "홍길동");
		Book book2 = new Book("5t6y7u8i", "하둡", "최길동");
		
		book1.checkin();
		book1.checkOut("김인정", "20201021");
		book1.checkOut("김인정", "20201021");
		book1.printState();
	}
}
