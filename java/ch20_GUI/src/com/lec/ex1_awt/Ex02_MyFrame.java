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
	private Label lbl1; //�߰��� ������Ʈ ����
	private Button btnExit;
	
	public Ex02_MyFrame() {	
		//�����ӿ� �󺧰� ��ư �߰��� set
		setLayout(new FlowLayout());//�������
//		setLayout(new BorderLayout(300, 200));//�⺻
//		setLayout(new GridLayout(2,2));//2�� 2�� ¥��
		lbl1 = new Label("��ſ� ������");
		lbl1.setPreferredSize(new Dimension(150,200));//������ ����(������Ʈ)
		btnExit = new Button("����");
		btnExit.setPreferredSize(new Dimension(200,200));
		add(lbl1); //�߰�
		add(btnExit);
		
		setVisible(true);
		setSize(new Dimension(500,300));
		setLocation(100,100);
		//btnExit Ŭ�� �̺�Ʈ
		btnExit.addActionListener(this);// ��ư ������ �� > �߻��� this.actionPerformed ȣ��
		
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
		// ��ư ������ �� > �߻��� this.actionPerformed ȣ��
		if(e.getSource()==btnExit) {
			setVisible(false);
			dispose();
			System.exit(0);
		}
	}
	
	public static void main(String[] args) {
		new Ex02_MyFrame("�ι�° GUI");
	}
}
