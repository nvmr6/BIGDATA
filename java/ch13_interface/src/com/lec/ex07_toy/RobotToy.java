package com.lec.ex07_toy;

public class RobotToy implements IMissile, IMove{

	public RobotToy() {
		System.out.println("로봇 장난감");
		canMissile();
		moveArmLeg();
		System.out.println("");
	}

	@Override
	public void moveArmLeg() {
		System.out.println("팔 다리 구동");
	}

	@Override
	public void canMissile() {
		System.out.println("미사일 발사");
	}
	
	@Override
	public String toString() {
		return "미사일 발사와 팔다리 구동 가능한 로봇 장난감";
	}

}
