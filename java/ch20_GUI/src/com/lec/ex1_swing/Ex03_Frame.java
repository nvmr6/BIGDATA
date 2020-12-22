package com.lec.ex1_swing;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Ex03_Frame extends JFrame implements ActionListener {
	private Container container;
	private JPanel panel;
	private JTextField txtName, txtTel, txtAge;
	private ImageIcon icon;
	private JButton btn;
	private JTextArea txtArea;
	private JScrollPane scroll;
	
	public Ex03_Frame(String title) {
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		container = getContentPane();
		panel = new JPanel(new GridLayout(3,2));
		txtName = new JTextField();
		txtTel = new JTextField();
		txtAge = new JTextField();
		icon = new ImageIcon("icon/hot.gif");
		btn = new JButton("join",icon);
		txtArea = new JTextArea(5,30);
		scroll = new JScrollPane(txtArea);
		
		panel.add(new JLabel("이름",(int)CENTER_ALIGNMENT));
		panel.add(txtName);
		panel.add(new JLabel("전화번호",(int)CENTER_ALIGNMENT));
		panel.add(txtTel);
		panel.add(new JLabel("나이",(int)CENTER_ALIGNMENT));
		panel.add(txtAge);
		container.add(panel,BorderLayout.NORTH);
		container.add(btn,BorderLayout.CENTER);
		container.add(scroll,BorderLayout.SOUTH);
		setVisible(true);
//		setSize(new Dimension(400,300));
//		setLocation(100,100);
		setBounds(100, 100, 400, 300);
		
		btn.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btn) {
			String name = txtName.getText().trim();
			String tel = txtTel.getText().trim();
			if(name.equals("") || tel.equals("")) {
				System.out.println("이름과 전화번호는 반드시 입력");
			}else {
				int age;
				try {
					age = Integer.parseInt(txtAge.getText());
				} catch (NumberFormatException ex) {
					age = 0;
				}
				String result = "[이믈] "+name+"\t[전화번호] "+tel;
				if(age>=0 && age<=130) {
					result += "\t[나이] "+age;
				}else {
					result += "유효하지 않은 나이 입력";
				}
				System.out.println(result);
				txtArea.append(result+"\r\n");// 추가 입력
				txtName.setText("");
				txtTel.setText("");
				txtAge.setText("");
			}
		}
	}
	public static void main(String[] args) {
		new Ex03_Frame("Frame3 GUI");
	}
}
