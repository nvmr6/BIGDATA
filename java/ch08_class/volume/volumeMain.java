package com.lec.volume;

public class volumeMain {
	public static void main(String[] args) {
		Volume box = new Volume(10,20,30);
		Volume rect = new Volume(10,20);
		
		box.calNsetVolume();
		rect.calNsetVolume();
		
		System.out.println("�ڽ��� ����: " + box.getVolume());
		System.out.println("���簢���� ����: " + box.getArea());
	}
}
