package com.lec.ex1_swing;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Ex02_Frame extends JFrame implements ActionListener{
	private JPanel panel;
//	private Container container;
	private JLabel lbl;
	private ImageIcon icon;
	private JButton btnWrite;
	private JTextField txt;
	private Vector<String> item;
	private String[] items = {"A", "B", "C"};
	private JComboBox<String> combo;
	private JCheckBox chk;
	private JLabel lbl0;
	private JButton btnExit;
	
	public Ex02_Frame(String title) {
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		panel = (JPanel)getContentPane();
		panel.setLayout(new FlowLayout());
		lbl = new JLabel("Label");
		icon = new ImageIcon("icon/search.png");
		btnWrite = new JButton("Button", icon);//이미지 아이콘
		txt = new JTextField(20);
		item = new Vector<String>();
		item.add("A"); item.add("B"); item.add("C");//콤보박스의 리스트
		combo = new JComboBox<String>(item);
		chk = new JCheckBox("check");
		lbl0 = new JLabel("");
		btnExit = new JButton("Exit");
		//크기조정
		lbl.setPreferredSize(new Dimension(50,50));
		btnWrite.setPreferredSize(new Dimension(200,50));
		txt.setPreferredSize(new Dimension(300,50));
		combo.setPreferredSize(new Dimension(100,50));
		chk.setPreferredSize(new Dimension(100,50));
		lbl0.setPreferredSize(new Dimension(200,50));
		btnExit.setPreferredSize(new Dimension(100,50));
		
		panel.add(lbl);
		panel.add(btnWrite);
		panel.add(txt);
		panel.add(combo);
		panel.add(chk);
		panel.add(lbl0);
		panel.add(btnExit);
		setVisible(true);
		pack();
		
		btnWrite.addActionListener(this);
		combo.addActionListener(this);
		chk.addActionListener(this);
		btnExit.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnWrite) {
			String temp = txt.getText().trim();
			if(!temp.equals("")) {
				lbl0.setText(temp);
				combo.addItem(temp);
				System.out.println(item);
				txt.setText("");
				String name = JOptionPane.showInputDialog("이름은? ");
				if(name!=null) {
					chk.setText(name);
				}
			}
		}else if(e.getSource()==combo) {
			lbl0.setText(combo.getSelectedItem().toString());
		}else if(e.getSource()==chk) {
			if(chk.isSelected()) {
				lbl0.setText(chk.getText());
			}else {
				System.out.println("uncheck");
			}
		}else if(e.getSource()==btnExit) {
			setVisible(false);
			dispose();
			System.exit(0);
		}
	}
	public static void main(String[] args) {
		new Ex02_Frame("Frame2 GUI");
	}
}
