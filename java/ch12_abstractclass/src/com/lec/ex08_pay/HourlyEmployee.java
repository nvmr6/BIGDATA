package com.lec.ex08_pay;

public class HourlyEmployee extends Employee {
	private int HoursWorked;
	private int moneyperHour;
	public HourlyEmployee(String name, int HoursWorked, int moneyperHour) {
		super(name);
		this.HoursWorked = HoursWorked;
		this.moneyperHour = moneyperHour;
	}

	@Override
	public int computePay() {
		return HoursWorked*moneyperHour;
	}

	public int getHoursWorked() {
		return HoursWorked;
	}

	public void setHoursWorked(int hoursWorked) {
		HoursWorked = hoursWorked;
	}

	public int getMoneyperHour() {
		return moneyperHour;
	}

	public void setMoneyperHour(int moneyperHour) {
		this.moneyperHour = moneyperHour;
	}
}
