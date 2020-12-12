package strategy1.step3;

public class TestMain {
	public static void main(String[] args) {
		Robot[] robots = { new SuperRobot(), new StandardRobot(), new LowRobot()};
		
		for(Robot temp: robots) {
			temp.shape();
			temp.actionWalk();
			temp.actionRun();
			temp.actionFly();
			temp.actionMissile();
			temp.actionKnife();
		}
	}
}
