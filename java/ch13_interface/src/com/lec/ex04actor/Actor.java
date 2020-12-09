package com.lec.ex04actor;

public class Actor implements PoliceMan, FireFighter, Chef {
	private String name;
	public Actor(String name) {
		this.name = name; //생성자
	}
	@Override
	public void makePizza() {
		System.out.println(name+"의 피자 요리");
	}

	@Override
	public void makeSpaghetti() {
		System.out.println(name+"의 스파게티 요리");
	}

	@Override
	public void outFire() {
		System.out.println(name+"의 화재 진압");
	}

	@Override
	public void saveMan() {
		System.out.println(name+"의 인명 구조");
	}

	@Override
	public void canCatchCriminal() {
		System.out.println(name+"의 범인 체포");
	}

	@Override
	public void serach() {
		System.out.println(name+"의 물건 수색");
	}

}
