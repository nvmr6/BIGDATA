package strategy1.step3;

public abstract class Robot {
	public void shape() {
		System.out.println(getClass().getName()+"은 팔, 다리, 머리, 몸통으로 이루어져 있다.");
	}
	public void actionWalk() {
		System.out.println("can walk");
	}
	public void actionRun() {
		System.out.println("can run");
	}
	public abstract void actionFly();
	public abstract void actionMissile();
	public abstract void actionKnife();

}
