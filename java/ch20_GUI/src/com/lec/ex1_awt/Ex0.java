package com.lec.ex1_awt;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.Frame;

public class Ex0 {
	public static void main(String[] args) {
		Frame frame = new Frame("title");
		Button button = new Button("button");
		Button button1 = new Button("normal button");
		
		frame.add(button, BorderLayout.NORTH);
		frame.add(button1, BorderLayout.CENTER);//���� �߰��� ǥ��
		
		frame.setSize(new Dimension(300,200));
		frame.setLocation(100,50);
		frame.setVisible(true);
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {}
		frame.setVisible(false);
		frame.dispose();// �������� ��� �ڿ� ����
		System.exit(0);//���� ����
	}
}
