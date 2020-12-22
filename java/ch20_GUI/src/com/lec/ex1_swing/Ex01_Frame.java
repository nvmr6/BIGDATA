package com.lec.ex1_swing;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Ex01_Frame extends JFrame implements ActionListener{
	private JPanel panel;
	private JLabel label;
	private JButton btn;
	public Ex01_Frame(String title) {
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);//x버튼 종료
		panel = (JPanel)getContentPane(); //전체 프레임을 얻어와서 형변환
		setLayout(new FlowLayout());//기본 flowLayout
		label = new JLabel("monday", (int)CENTER_ALIGNMENT);
		label.setPreferredSize(new Dimension(150,200));
		btn = new JButton("종료");
		btn.setPreferredSize(new Dimension(200,200));
		
		panel.add(label);//프레임 자체
		panel.add(btn);
		setSize(new Dimension(500,300));
		setVisible(true);
//		pack();//최소한의 사이즈
		
		btn.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btn) {
			setVisible(false);
			dispose();
			System.exit(0);
		}
	}
	public static void main(String[] args) {
		new Ex01_Frame("swing GUI");
	}
}
