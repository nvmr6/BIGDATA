package com.lec.account;

public class accountMain {
	public static void main(String[] args) {
		Account hong = new Account("110-11","ȫ�浿",10000);
		Account jung = new Account("110-12","���⼺");
		Account sung = new Account();
		
		jung.setAccountNo("110-9");
		jung.setOwnerName("���⼺");
		
		hong.deposit(10000);
		hong.info();
		jung.withdraw(10000);
		jung.info();
		sung.deposit(10000);
		sung.withdraw(2000);
		sung.info();
	}
}
