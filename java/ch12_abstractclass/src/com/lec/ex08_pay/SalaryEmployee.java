package com.lec.ex08_pay;

public class SalaryEmployee extends Employee {
	private int annualSalary;
	public SalaryEmployee(String name, int annualSalary) {
		super(name);
		this.annualSalary = annualSalary;
	}

	@Override
	public int computePay() {
		return annualSalary/14;
	}

	public int getAnnualSalary() {
		return annualSalary;
	}

	public void setAnnualSalary(int annualSalary) {
		this.annualSalary = annualSalary;
	}
	
}
