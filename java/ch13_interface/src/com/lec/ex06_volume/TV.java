package com.lec.ex06_volume;

public class TV implements IVolume{
	private int volume=50;
	private final int MAXVOLUME=100;
	private final int MINVOLUME=0;
	
	@Override
	public void volumeUp() {
		volume+=2;
		if(volume<MAXVOLUME) {
			System.out.println("볼륨을 2만큼 올려");
			System.out.println("현재 볼륨: "+volume);
		}else {
			System.out.println("볼륨이 최대치입니다.");
		}
	}

	@Override
	public void volumeUp(int level) {
		volume += level;
		if(volume>=MAXVOLUME) {
			volume = MAXVOLUME;
			System.out.println("볼륨이 최대치입니다.");
		}else {
			System.out.println("볼륨을"+level+"만큼 올립니다.");
			System.out.println("현재 볼륨: "+volume);
			
		}
	}

	@Override
	public void volumeDown() {
		volume-=2;
		if(volume>MINVOLUME) {
			System.out.println("볼륨을 2만큼 내려");
			System.out.println("현재 볼륨: "+volume);
		}else {
			System.out.println("볼륨이 최소치입니다.");
		}
	}

	@Override
	public void volumeDown(int level) {
		volume -= level;
		if(volume<=MINVOLUME) {
			volume = MINVOLUME;
			System.out.println("볼륨이 최소치입니다.");
		}else {
			System.out.println("볼륨을"+level+"만큼 내립니다.");
			System.out.println("현재 볼륨: "+volume);
		}
	}

}
