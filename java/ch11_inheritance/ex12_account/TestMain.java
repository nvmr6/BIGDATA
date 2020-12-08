package com.lex.ex12_account;

public class TestMain {
	public static void main(String[] args) {
		Account a1 = new Account("111-1111", "홍길동");
		CheckingAccount a2 = new CheckingAccount("222-2222", "성춘향", 2000, "1234-1234-1234-1323");
		CheckingAccount a3 = new CreditLineAccount("222-2222", "성춘향", 2000, "1234-1234-1234-1323", 2000);
		a1.deposit(3000);
		a2.withdraw(200);
		a3.deposit(3000);
		a1.printAccount();
		a2.pay("1234-1234-1234-1323", 200);
		a3.pay("1234-1234-1234-1323", 5000);
		}
}

