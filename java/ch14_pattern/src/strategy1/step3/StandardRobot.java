package strategy1.step3;

public class StandardRobot extends Robot{
	public StandardRobot() {}
	
	public void actionFly() {
		System.out.println("can not fly");
	}
	public void actionMissile() {
		System.out.println("has missile");
	}
	public void actionKnife() {
		System.out.println("has wood knife");
	}
}
