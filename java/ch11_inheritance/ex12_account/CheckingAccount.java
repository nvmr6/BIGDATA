package com.lex.ex12_account;

public class CheckingAccount extends Account {
	private String cardNo;
	
	public CheckingAccount(String accountNo, String ownerName,String cardNo) {
		super(accountNo,ownerName);
		this.cardNo = cardNo;
	}
	public CheckingAccount(String accountNo, String ownerName, int balance,String cardNo) {
		super(accountNo,ownerName,balance);
		this.cardNo = cardNo;
	}
	
	void pay(String cardNo, int amount) {
		if(this.cardNo.equals(cardNo)) {
			if(amount <= getBalance()) {
				setBalance((getBalance()-amount));
				System.out.println(amount+"원 사용해서 잔고는 "+getBalance()+"입니다.");
			}else {
				System.out.println("잔고가 부족합니다..");
			}
		}else {
			System.out.println("카드번호가 일치하지 않습니다.");
		}
	}
	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
}
