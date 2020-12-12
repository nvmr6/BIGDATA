package strategy1.step3;

public class LowRobot extends Robot{
	public LowRobot() {}
	
	public void actionFly() {
		System.out.println("can not fly");
	}
	public void actionMissile() {
		System.out.println("has not missile");
	}
	public void actionKnife() {
		System.out.println("has not knife");
	}
}
