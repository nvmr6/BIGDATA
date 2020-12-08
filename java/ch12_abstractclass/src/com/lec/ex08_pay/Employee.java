package com.lec.ex08_pay;

public abstract class Employee {
	private String name;

	public Employee(String name) {
		this.name = name;
	}
	public final int computeIncentive() {
		if(computePay()>2000000) {
			return computePay()/10;
		}else {
			return 0;
		}
	}
	
	public abstract int computePay();
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
