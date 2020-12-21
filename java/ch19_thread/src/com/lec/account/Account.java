package com.lec.account;

public class Account {
	private int balance;
	public Account() {}
	public Account(int balance) {
		this.balance = balance;
	}
	public synchronized void deposit(int amount, String name) {
		System.out.println(name+"가 입금 시작");
		System.out.println("입금 전 잔액: "+balance);
		balance += amount;
		System.out.println("입금 후 잔액: "+balance);
		System.out.println(name+"가 입금 종료");
	}
	
	public synchronized void withdraw(int amount, String name) {
		System.out.println(name+"가 줄금 시작");
		System.out.println("출금 전 잔액: "+balance);
		if(balance<amount) {
			System.out.println("잔액 부족");
		}else {
			balance -= amount;
			System.out.println("출금 후 잔액: "+balance);
		}
		System.out.println(name+"가 출금 종료");
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
}
