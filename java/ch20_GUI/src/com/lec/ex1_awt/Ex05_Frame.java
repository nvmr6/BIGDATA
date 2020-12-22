package com.lec.ex1_awt;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.List;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Ex05_Frame extends Frame implements ActionListener{
	private Panel panel;
	private TextField txt;
	private Button btnOk, btnExit;
	private List list;
	
	public Ex05_Frame() {}
	public Ex05_Frame(String title) {
		super(title);
		setLayout(new BorderLayout());
		panel = new Panel(new FlowLayout());//flow가 기본값
		txt = new TextField(20);
		btnOk = new Button("확인");
		btnExit = new Button("종료");
		list = new List();
		
		panel.add(new Label("Write"));
		panel.add(txt);
		panel.add(btnOk);
		panel.add(btnExit);
		add(panel,BorderLayout.NORTH);
		add(list,BorderLayout.CENTER);
		
		setSize(new Dimension(400,300));
		setResizable(false);
		setLocation(300,300);
		setVisible(true);
		//이벤트 리스너
		btnOk.addActionListener(this);
		btnExit.addActionListener(this);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				setVisible(false);
				dispose();
				System.exit(0);
			}
		});
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnOk) {
			//리스트에 추가후 텍스트 필드 비우기
			list.add(txt.getText());
			txt.setText("");
		}else if(e.getSource()==btnExit){
			setVisible(false);
			dispose();
			System.exit(0);
		}
	}
	public static void main(String[] args) {
		new Ex05_Frame("Login GUI");
	}
}
