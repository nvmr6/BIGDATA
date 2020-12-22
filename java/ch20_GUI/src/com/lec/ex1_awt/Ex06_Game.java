package com.lec.ex1_awt;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.List;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Ex06_Game extends Frame implements ActionListener{
	private Panel panel;
	private Button btnR, btnS, btnP, btnExit;
	private List list;
	int computer, temp;
	
	public Ex06_Game() {}
	public Ex06_Game(String title) {
		super(title);
		panel = new Panel();
		btnR = new Button("가위");
		btnS = new Button("바위");
		btnP = new Button("보");
		list = new List();
		btnExit = new Button("종료");
		
		panel.add(btnR);
		panel.add(btnS);
		panel.add(btnP);
		add(panel,BorderLayout.NORTH);
		add(list, BorderLayout.CENTER);
		add(btnExit,BorderLayout.SOUTH);
		
		setSize(new Dimension(400,300));
		setResizable(false);
		setLocation(300,300);
		setVisible(true);
		
		btnR.addActionListener(this);
		btnS.addActionListener(this);
		btnP.addActionListener(this);
		btnExit.addActionListener(this);
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				setVisible(false);
				dispose();
				System.exit(0);
			}
		});
	}
	
	public String game() {
		computer = (int)(Math.random()*3); 
		if(temp==computer) {
			return "비겼습니다.";
		}else if((temp+1)%3==computer) {
			return "졌습니다.";
		}else {
			return "이겼습니다.";
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnR) {
			temp = 0;
			list.add(game());
		}else if(e.getSource()==btnS) {
			temp = 1;
			list.add(game());
		}else if(e.getSource()==btnP) {
			temp = 2;
			list.add(game());
		}else if(e.getSource()==btnExit) {
			setVisible(false);
			dispose();
			System.exit(0);
		}
	}
	public static void main(String[] args) {
		new Ex06_Game("Game GUI");
	}
}
