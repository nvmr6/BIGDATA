package strategy1.step5.modularization;

import strategy1.step4.component.CannotFly;
import strategy1.step4.component.Missile;
import strategy1.step4.component.WoodKnife;

public class StandardRobot extends Robot {
	public StandardRobot() { //생성자
		//부품들 생성
//		fly = new CannotFly();
//		missile = new Missile();
//		knife = new WoodKnife();
		setFly(new CannotFly());
		setMissile(new Missile());
		setKnife(new WoodKnife());
	}
}
