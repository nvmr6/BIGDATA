package strategy1.step4.modularization;

import strategy1.step4.component.CanFly;
import strategy1.step4.component.IFly;
import strategy1.step4.component.IKnife;
import strategy1.step4.component.IMissile;
import strategy1.step4.component.LazerKnife;
import strategy1.step4.component.Missile;

public class SuperRobot extends Robot {
	//부품 변수 선언
	private IFly fly;
	private IMissile missile;
	private IKnife knife;
	
	public SuperRobot() { //생성자
		//부품들 생성
		fly = new CanFly();
		missile = new Missile();
		knife = new LazerKnife();
//		setFly(new CanFly());
//		setMissile(new Missile());
//		setKnife(new LazerKnife());
	}
	
	@Override
	public void actionFly() {
		//부품호출
		fly.fly();
	}

	@Override
	public void actionMissile() {
		missile.missile();
	}

	@Override
	public void actionKnife() {
		knife.knife();
	}
	
	public void setFly(IFly fly) {
		this.fly = fly;
	}
	public void setMissile(IMissile missile) {
		this.missile = missile;
	}
	public void setKnife(IKnife knife) {
		this.knife = knife;
	}

}
