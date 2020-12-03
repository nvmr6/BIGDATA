package com.lec.account;
/*은행계좌클래스 = 
 *  데이터: 게좌 번호 accountNo, 예금주 owenerName, 잔액 balance
 *  메소도: 예금 (void deposit(int money)) 인출 (int withdraw(int money))
 */
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
				System.out.println("잔고가 부족합니다.");
			}
		}
		public void info(){
			System.out.println("성함: "+ownerName+"\n계좌번호: "+accountNo+"\n잔고: "+balance);
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

