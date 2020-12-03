package com.lec.account;

public class accountMain {
	public static void main(String[] args) {
		Account hong = new Account("110-11","홍길동",10000);
		Account jung = new Account("110-12","정기성");
		Account sung = new Account();
		
		jung.setAccountNo("110-9");
		jung.setOwnerName("정기성");
		
		hong.deposit(10000);
		hong.info();
		jung.withdraw(10000);
		jung.info();
		sung.deposit(10000);
		sung.withdraw(2000);
		sung.info();
	}
}
