package strategy1.step5.modularization;

import strategy1.step4.component.CannotFly;
import strategy1.step4.component.NoKnife;
import strategy1.step4.component.NoMissile;

public class LowRobot extends Robot {
	public LowRobot() { //생성자
		//부품들 생성
//		fly = new CannotFly();
//		missile = new NoMissile();
//		knife = new NoKnife();
		setFly(new CannotFly());
		setMissile(new NoMissile());
		setKnife(new NoKnife());
	}
}
