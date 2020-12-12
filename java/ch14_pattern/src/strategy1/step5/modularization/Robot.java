package strategy1.step5.modularization;

import strategy1.step4.component.IFly;
import strategy1.step4.component.IKnife;
import strategy1.step4.component.IMissile;

public class Robot {
	private IFly fly;
	private IMissile missile;
	private IKnife knife;
	
	public void shape() {
		System.out.println(getClass().getName()+"은 팔, 다리, 머리, 몸통으로 이루어져 있다.");
	}
	public void actionWalk() {
		System.out.println("can walk");
	}
	public void actionRun() {
		System.out.println("can run");
	}
	public void actionFly() {
		//부품호출
		fly.fly();
	}

	public void actionMissile() {
		missile.missile();
	}

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
