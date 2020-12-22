package com.lec.ex1_awt;

import java.awt.Button;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Ex02_MyFrame extends Frame implements ActionListener{
	private Label lbl1; //추가할 컴포넌트 변수
	private Button btnExit;
	
	public Ex02_MyFrame() {	
		//프레임에 라벨과 버튼 추가후 set
		setLayout(new FlowLayout());//순서대로
//		setLayout(new BorderLayout(300, 200));//기본
//		setLayout(new GridLayout(2,2));//2행 2열 짜리
		lbl1 = new Label("즐거운 월요일");
		lbl1.setPreferredSize(new Dimension(150,200));//사이즈 조절(컴포넌트)
		btnExit = new Button("종료");
		btnExit.setPreferredSize(new Dimension(200,200));
		add(lbl1); //추가
		add(btnExit);
		
		setVisible(true);
		setSize(new Dimension(500,300));
		setLocation(100,100);
		//btnExit 클릭 이벤트
		btnExit.addActionListener(this);// 버튼 리스닝 중 > 발생시 this.actionPerformed 호출
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				setVisible(false);
				dispose();
				System.exit(0);
			}
		});
	}
	public Ex02_MyFrame(String title) {
		this();
		setTitle(title);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// 버튼 리스닝 중 > 발생시 this.actionPerformed 호출
		if(e.getSource()==btnExit) {
			setVisible(false);
			dispose();
			System.exit(0);
		}
	}
	
	public static void main(String[] args) {
		new Ex02_MyFrame("두번째 GUI");
	}
}
