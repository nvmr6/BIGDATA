package com.lec.ex4_account;

public class Main {
	public static void main(String[] args) {
		Account ac1 = new Account("11-11", "홍길동");
		Account ac2 = new Account("12-12", "이길동", 20000);
		
		ac1.deposit(10000);
		ac2.deposit(10000);
		try {
			ac1.withdraw(15000);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
 	}
}
