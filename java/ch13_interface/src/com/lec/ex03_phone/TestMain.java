package com.lec.ex03_phone;

public class TestMain {
	public static void main(String[] args) {
//		IAcor a = new AModel();
//		IAcor b = new BModel();
//		IAcor c = new CModel();
		IAcor[] phones = {new AModel(), new BModel(), new CModel()};
//		IAcor[] phones = {a,b,c};
		for(IAcor temp: phones) {
			System.out.println(temp.getClass());
			temp.dmbReceive();
			temp.lte();
			temp.tvremoteControl();
			System.out.println("");
		}
	}
}
