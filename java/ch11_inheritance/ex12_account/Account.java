package com.lex.ex12_account;

public class Account {
	private String accountNo;
	private String ownerName;
	private int balance;
	
	public Account() {}
	public Account(String accountNo, String ownerName, int balance) {
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		this.balance = balance;
	}
	public Account(String accountNo, String ownerName) {
		this.accountNo = accountNo;
		this.ownerName = ownerName;
	}
	
		public void deposit(int money) {
			balance += money;
		}
		public void withdraw(int money) {
			if(money <= balance) {
				balance -= money;
			}else {
				System.out.println("잔고가 부족합니다..");
			}
		}
		public void printAccount(){
			System.out.println("성함: "+ownerName+" 계좌번호: "+accountNo+" 잔고: "+balance);
		}
		
		public String getAccountNo() {
			return accountNo;
		}
		
		public void setAccountNo(String accountNo) {
			 this.accountNo =accountNo;
		}
		public String getOwnerName() {
			return ownerName;
		}
		
		public void setOwnerName(String ownerName) {
			 this.ownerName = ownerName;
		}
		public int getBalance() {
			return balance;
		}
		
		public void setBalance(int balance) {
			 this.balance =balance;
		}
}
