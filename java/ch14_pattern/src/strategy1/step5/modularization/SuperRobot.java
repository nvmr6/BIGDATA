package strategy1.step5.modularization;

import strategy1.step4.component.CanFly;
import strategy1.step4.component.LazerKnife;
import strategy1.step4.component.Missile;

public class SuperRobot extends Robot {
	public SuperRobot() { //생성자
		//부품들 생성
//		fly = new CanFly();
//		missile = new Missile();
//		knife = new LazerKnife();
		setFly(new CanFly());
		setMissile(new Missile());
		setKnife(new LazerKnife());
	}
}
