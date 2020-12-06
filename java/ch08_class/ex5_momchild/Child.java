package com.lec.ex5_momchild;

public class Child {
	private String name;
	static MomPouch momPouch; //클래스내의 static은 객체를 공유하게 된다. 
	
	public Child(String name) { //child객체가 만들어질때 momPouch가 생성되면서 2000원 갖고 있는다.
		this.name = name;
		momPouch = new MomPouch();
	}
	public void takeMoney(int money) {
		if(momPouch.money >= money) {
			momPouch.money -= money;
			System.out.println(name+"가"+money+"만큼 가져가서 엄마 지갑안에는 "+momPouch.money+"가 있다.");
		}else {
			System.out.println(name+"가 돈을 받지 못한다. 현재 엄마 지갑안에는 "+momPouch.money+"원이 있다.");
		}
	}
}
