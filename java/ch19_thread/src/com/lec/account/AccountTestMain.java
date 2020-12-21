package com.lec.account;

public class AccountTestMain {
	public static void main(String[] args) {
		Account account = new Account(5000);
		Runnable target = new ATMcard(account);
		
		Thread mom = new Thread(target,"mom");
		Thread dad = new Thread(target,"dad");
		
		mom.start();
		dad.start();
	}
}
