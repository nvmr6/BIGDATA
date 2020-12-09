package com.lec.ex06_volume;

public class Main {
	public static void main(String[] args) {
		IVolume[] device = {new TV(), new Radio()};
		
		for(IVolume temp: device) {
			temp.volumeUp();
			temp.volumeDown();
		}
		System.out.println("");
		for(IVolume temp: device) {
			temp.volumeUp(10);
			temp.volumeDown(10);
		}
	}
}
