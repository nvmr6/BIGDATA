package strategy1.step4.modularization;

import strategy1.step4.component.CannotFly;
import strategy1.step4.component.IFly;
import strategy1.step4.component.IKnife;
import strategy1.step4.component.IMissile;
import strategy1.step4.component.NoKnife;
import strategy1.step4.component.NoMissile;

public class LowRobot extends Robot {
	//부품 변수 선언
	private IFly fly;
	private IMissile missile;
	private IKnife knife;
	
	public LowRobot() { //생성자
		//부품들 생성
		fly = new CannotFly();
		missile = new NoMissile();
		knife = new NoKnife();
//		setFly(new CannotFly());
//		setMissile(new NoMissile());
//		setKnife(new NoKnife());
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
