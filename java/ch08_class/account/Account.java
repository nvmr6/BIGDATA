package com.lec.account;
/*�������Ŭ���� = 
 *  ������: ���� ��ȣ accountNo, ������ owenerName, �ܾ� balance
 *  �޼ҵ�: ���� (void deposit(int money)) ���� (int withdraw(int money))
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
				System.out.println("�ܰ� �����մϴ�.");
			}
		}
		public void info(){
			System.out.println("����: "+ownerName+"\n���¹�ȣ: "+accountNo+"\n�ܰ�: "+balance);
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

