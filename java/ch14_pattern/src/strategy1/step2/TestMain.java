package strategy1.step2;

public class TestMain {
	public static void main(String[] args) {
		Robot[] robots = { new SuperRobot(), new StandardRobot(), new LowRobot()};
		
		for(Robot temp: robots) {
			temp.shape();
			temp.actionWalk();
			temp.actionRun();
			if(temp instanceof SuperRobot) {
				SuperRobot sup = (SuperRobot) temp;//객체의 형변환 
				sup.actionFly();
				sup.actionMissile();
				sup.actionKnife();
			}else if(temp instanceof StandardRobot) {
				StandardRobot std = (StandardRobot) temp;//객체의 형변환 
				std.actionFly();
				std.actionMissile();
				std.actionKnife();
			}else if(temp instanceof LowRobot) {
				LowRobot low = (LowRobot) temp;//객체의 형변환 
				low.actionFly();
				low.actionMissile();
				low.actionKnife();
			}
		}
	}
}
