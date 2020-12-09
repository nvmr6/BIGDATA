package com.lec.ex04actor;

public class TestMain {
	public static void main(String[] args) {
		Actor park = new Actor("박보검");
		park.canCatchCriminal();
		//모두 할 수 있다.
		
		FireFighter firepark = park; //다형성 객체
		firepark.outFire();
		firepark.saveMan();// 다른건 할 수 없다.
		
		Chef chefpark = park;
		chefpark.makePizza();
		chefpark.makeSpaghetti();
		
		PoliceMan policepark = park;
		policepark.canCatchCriminal();
		policepark.serach();
	}
}
