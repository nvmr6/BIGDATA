package com.lec.ex1_swing;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MyFrame extends JFrame implements ActionListener {
	private Container container;
	private JPanel panel;
	private JTextField txtName, txtTel, txtAge;
	private ImageIcon icon1, icon2;
	private JButton btnIn;
	private JButton btnOut;
	Writer writer = null;
	ArrayList<Person> people = new ArrayList<Person>();
	public MyFrame(String title) {
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		container = getContentPane();
		panel = new JPanel(new GridLayout(4,2));
		txtName = new JTextField();
		txtTel = new JTextField();
		txtAge = new JTextField();
		icon1 = new ImageIcon("icon/join.png");
		icon2 = new ImageIcon("icon/search.png");
		btnIn = new JButton("입력",icon1);
		btnOut = new JButton("출력",icon2);
		
		panel.add(new JLabel("이름",(int)CENTER_ALIGNMENT));
		panel.add(txtName);
		panel.add(new JLabel("전화번호",(int)CENTER_ALIGNMENT));
		panel.add(txtTel);
		panel.add(new JLabel("나이",(int)CENTER_ALIGNMENT));
		panel.add(txtAge);
		panel.add(btnIn);
		panel.add(btnOut);
		container.add(panel,BorderLayout.CENTER);
		
		setVisible(true);
		setBounds(100, 100, 400, 300);
		
		btnIn.addActionListener(this);
		btnOut.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnIn) {
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
				if(age>0 && age<=130) {
					people.add(new Person(name,tel,age));
				}else {
					people.add(new Person(name,tel,0));
				}
				txtName.setText("");
				txtTel.setText("");
				txtAge.setText("");
			}
		}else if(e.getSource()==btnOut) {
			System.out.println("고객 명단을 출력합니다.");
			for(Person temp: people) {
				System.out.println(temp);
			}
			try {
				writer = new FileWriter("icon/person.txt");
//				String str = people.toString();
//				char[] st = str.toCharArray();
//				writer.write(str);
//				System.out.println("complete");
				for(Person temp: people) {
					writer.write(temp.toString()+"\r\n");
				}
			} catch (FileNotFoundException e1) {
				System.out.println(e1.getMessage());
			} catch (IOException e2) {
				System.out.println(e2.getMessage());
			}finally {
				try {
					if(writer!=null)
						writer.close();
				} catch (Exception e3) {
					System.out.println(e3.getMessage());
				}
			}
		}
	}
	public static void main(String[] args) {
		new MyFrame("PersonMain GUI");
	}
}
