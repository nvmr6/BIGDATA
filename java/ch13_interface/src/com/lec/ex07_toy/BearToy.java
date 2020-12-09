package com.lec.ex07_toy;

public class BearToy implements IMove{
	public BearToy() { //생성자
		System.out.println("곰 인형");
		moveArmLeg();
		System.out.println("");
	}
	
	@Override
	public void moveArmLeg() {
		System.out.println("팔 다리 구동");
	}
	@Override
	public String toString() {
		return "팔다리 구동 가능한 곰 인형";
	}
}
