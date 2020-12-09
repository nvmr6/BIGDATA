package com.lec.ex06_volume;

public interface IVolume {
	public void volumeUp();
	public void volumeUp(int level);
	public void volumeDown();
	public void volumeDown(int level);
	public default void mute() { //디폴트 메소드
		System.out.println("무음");
	}
}
