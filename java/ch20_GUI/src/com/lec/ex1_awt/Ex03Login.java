package com.lec.ex1_awt;

import java.awt.Button;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;

public class Ex03Login extends Frame{
	private TextField txtId, txtPw;
	private Label lbl1, lbl2;
	private Button btnLogin;
	
	public Ex03Login() {}
	public Ex03Login(String title) {
		super(title);
		setLayout(new FlowLayout());
		lbl1 = new Label("ID");
		txtId = new TextField("ID", 20);//사이즈까지
		lbl2 = new Label("PW");
		txtPw = new TextField(20);
		txtPw.setEchoChar('*');
		btnLogin = new Button("Login");
		
		add(lbl1);
		add(txtId);
		add(lbl2);
		add(txtPw);
		add(btnLogin);
		
		setVisible(true);
		setSize(new Dimension(250,150));
		setResizable(false);//사이즈 조절 불가
		setLocation(100,100);
	}
	
	public static void main(String[] args) {
		new Ex03Login("Login GUI");
	}
}
