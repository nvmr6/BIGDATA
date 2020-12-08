package com.lex.ex12_account;

public class CreditLineAccount extends CheckingAccount {
	private long creditLine;
	public CreditLineAccount(String accountNo, String ownerName, String cardNo, long creditLine) {
		super(accountNo, ownerName, cardNo);
		this.creditLine = creditLine;
	}
	public CreditLineAccount(String accountNo, String ownerName, int balance, String cardNo, long creditLine) {
		super(accountNo, ownerName, balance, cardNo);
		this.creditLine = creditLine;
	}
	
	@Override
	void pay(String cardNo, int amount) {
		if(getCardNo().equals(cardNo)) {
			if(amount<=creditLine) {
				creditLine-=amount;
				System.out.println("결제 금액: "+amount);
			}else {
				System.out.println("한도 초과입니다.");
			}
		}else {
			System.out.println("카드번호가 일치하지 않습니다.");
		}
	}
	@Override
	public void printAccount() {
		super.printAccount();
		System.out.println("카드 한도액: "+creditLine);
	}

	public long getCreditLine() {
		return creditLine;
	}

	public void setCreditLine(long creditLine) {
		this.creditLine = creditLine;
	}
}

