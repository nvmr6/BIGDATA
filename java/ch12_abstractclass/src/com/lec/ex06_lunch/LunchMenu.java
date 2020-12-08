package com.lec.ex06_lunch;

public abstract class LunchMenu {
	private String typeString;
	private int rice;
	private int bulgogi;
	private int soup;
	private int milk;
	private int banana;
	private int almond;
	
	public LunchMenu(int rice, int bulgogi, int soup, int milk, int banana, int almond) {
		this.rice = rice;
		this.bulgogi = bulgogi;
		this.soup = soup;
		this.milk = milk;
		this.banana = banana;
		this.almond = almond;
	}
	
	public abstract int calculate(); //추상 메소드

	public String getTypeString() {
		return typeString;
	}

	public void setTypeString(String typeString) {
		this.typeString = typeString;
	}

	public int getRice() {
		return rice;
	}

	public void setRice(int rice) {
		this.rice = rice;
	}

	public int getBulgogi() {
		return bulgogi;
	}

	public void setBulgogi(int bulgogi) {
		this.bulgogi = bulgogi;
	}

	public int getSoup() {
		return soup;
	}

	public void setSoup(int soup) {
		this.soup = soup;
	}

	public int getMilk() {
		return milk;
	}

	public void setMilk(int milk) {
		this.milk = milk;
	}

	public int getBanana() {
		return banana;
	}

	public void setBanana(int banana) {
		this.banana = banana;
	}

	public int getAlmond() {
		return almond;
	}

	public void setAlmond(int almond) {
		this.almond = almond;
	}
}
