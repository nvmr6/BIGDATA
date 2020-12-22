package com.lec.ex1_awt;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Ex04_Login extends Frame {
	private Panel panel;
	private TextField txtId, txtPw;
	private Button btnLogin;
	
	public Ex04_Login(String title) {
		super(title);
		
		panel = new Panel(new GridLayout(2,2));
		txtId = new TextField("ID", 20);
		txtPw = new TextField(20);
		txtPw.setEchoChar('*');
		btnLogin = new Button("Log in");
		
		panel.add(new Label("ID", (int)CENTER_ALIGNMENT));
		panel.add(txtId);
		panel.add(new Label("PW", (int)CENTER_ALIGNMENT));
		panel.add(txtPw);
		add(panel, BorderLayout.NORTH);
		add(btnLogin, BorderLayout.SOUTH);
		
		setSize(new Dimension(400,300));
		setResizable(false);
		setLocation(100,100);
		setVisible(true);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				setVisible(false);
				dispose();
				System.exit(0);
			}
		});
	}
	
	public static void main(String[] args) {
		new Ex04_Login("Login GUI");
	}
}
