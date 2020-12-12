package strategy1.step5.modularization;

import strategy1.step4.component.CanFly;
import strategy1.step4.component.FlyHi;

public class TestMain {
	public static void main(String[] args) {
		Robot superRobot = new SuperRobot();
		Robot stanardRobot = new StandardRobot();
		Robot lowRobot = new LowRobot();
		Robot[] robots = {superRobot,stanardRobot,lowRobot};

		for(Robot temp: robots) {
			temp.shape();
			temp.actionWalk();
			temp.actionRun();
			temp.actionFly();
			temp.actionMissile();
			temp.actionKnife();
			System.out.println("");
		}
		System.out.println("");
//		//요구사항: lowrobot을 날 수 있게 업그레이드, 임포트
		lowRobot.setFly(new CanFly());
		superRobot.setFly(new FlyHi());
		
		for(Robot temp: robots) {
			temp.shape();
			temp.actionWalk();
			temp.actionRun();
			temp.actionFly();
			temp.actionMissile();
			temp.actionKnife();
			System.out.println("");
		}
	}
}
