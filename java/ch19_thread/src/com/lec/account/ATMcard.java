package com.lec.account;
//Account acc = new Account();
//Runnable target1 = new ATMcard(acc);
//Runnable target2 = new ATMcard(acc);

public class ATMcard implements Runnable{
	private boolean flag = false;
	private Account obj;
	
	public ATMcard(Account obj) {
		this.obj = obj;
	}

	@Override
	public void run() {
		for(int i=0;i<10;i++) {
			if(flag) {
				obj.withdraw(1000, Thread.currentThread().getName());
				flag = false;
			}else {
				obj.deposit(1000, Thread.currentThread().getName());
				flag = false;
			}
		}
	}
	
}
