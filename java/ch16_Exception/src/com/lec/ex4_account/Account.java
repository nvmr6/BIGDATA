package com.lec.ex4_account;

public class Account {
	private String accountNo;
	private String name;
	private int balance;
	
	public Account() {}
	public Account(String accountNo, String name) {
		this.accountNo = accountNo;
		this.name = name;
	}
	public Account(String accountNo, String name, int balance) {
		this.accountNo = accountNo;
		this.name = name;
		this.balance = balance;
	}
	//예금 메소드
	public void deposit(int amount) {
		System.out.println("예금 전 잔액: "+this);
		balance += amount;
		System.out.println("예금 후 잔액: "+this);
	}
	//출금 메소드
	public void withdraw(int amount) throws Exception{// 선언한 메소드
		if(balance<amount) {//강제 예외 발생
			throw new Exception(amount+"원 출금하기엔 잔액 ("+(amount-balance)+"원)이 부족합니다."); 
		}
		System.out.println("출금 전 잔액: "+this);
		balance -= amount;
		System.out.println("출금 후 잔액: "+this);
	}
	
	@Override
	public String toString() {
		String result = "계좌번호"+accountNo+" 예금주: "+name+" 잔액: "+balance;
		return result;
	}
}
