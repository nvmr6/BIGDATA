package com.lec.ex06_lunch;

public class Child1 extends LunchMenu {
	public Child1(int rice, int bulgogi, int soup, int milk, int banana, int almond) {
		super( rice, bulgogi, soup, milk, banana, almond);
	}
	
	@Override
	public int calculate() {
		return getRice()+getBulgogi()+getSoup()+getBanana()+getAlmond();
	}

}
