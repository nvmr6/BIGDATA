package strategy1.step1;

public class StandardRobot {
	public void shape() {
		System.out.println("StandardRobot은 팔, 다리, 머리, 몸통으로 이루어져 있다.");
	}
	public void actionWalk() {
		System.out.println("can walk");
	}
	public void actionRun() {
		System.out.println("can run");
	}
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
