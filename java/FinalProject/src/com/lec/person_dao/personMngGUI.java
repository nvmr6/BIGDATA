package com.lec.person_dao;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class personMngGUI extends JFrame implements ActionListener{
	private Container contenPane;
	private JPanel jpup, jpbtn;
	private JTextField txtName, txtKor, txtEng, txtMat;
	private Vector<String> jnames;
	private JComboBox<String> comjob;
	private JButton btnInput, btnSearch, btnOutput, btnExit;
	private JTextArea txtpool;
	private JScrollPane scrollpane;
	
	private personDao dao = personDao.getInstance();
	private ArrayList<personDto> person;
	
	public personMngGUI(String title) {
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		contenPane = getContentPane();
		contenPane.setLayout(new FlowLayout());
		jpup = new JPanel(new GridLayout(5,2));
		jpbtn = new JPanel(new FlowLayout());
		txtName = new JTextField(20);
		jnames = dao.jnameList();
		comjob = new JComboBox<String>(jnames);//�޺��ڽ� �ȿ� �������� �ҷ��ͼ� ����
		txtKor = new JTextField(20);
		txtEng = new JTextField(20);
		txtMat = new JTextField(20);
		ImageIcon icon1 = new ImageIcon("icon/write.gif");
		btnInput = new JButton("�Է�", icon1);
		ImageIcon icon2 = new ImageIcon("icon/hot.gif");
		btnSearch = new JButton("��ȸ", icon2);
		btnOutput = new JButton("��ü ���");
		btnExit = new JButton("����");
		txtpool = new JTextArea(10,60);
		scrollpane = new JScrollPane(txtpool);
		
		jpup.add(new JLabel("�̸�", (int)CENTER_ALIGNMENT));
		jpup.add(txtName);
		jpup.add(new JLabel("����", (int)CENTER_ALIGNMENT));
		jpup.add(comjob);
		jpup.add(new JLabel("����", (int)CENTER_ALIGNMENT));
		jpup.add(txtKor);
		jpup.add(new JLabel("����", (int)CENTER_ALIGNMENT));
		jpup.add(txtEng);
		jpup.add(new JLabel("����", (int)CENTER_ALIGNMENT));
		jpup.add(txtMat);
		
		jpbtn.add(btnInput);
		jpbtn.add(btnSearch);
		jpbtn.add(btnOutput);
		jpbtn.add(btnExit);
		
		contenPane.add(jpup);
		contenPane.add(jpbtn);
		contenPane.add(scrollpane);
		
		setSize(new Dimension(700, 450));
		setLocation(200,150);
		setVisible(true);
		
		btnInput.addActionListener(this);
		btnSearch.addActionListener(this);
		btnOutput.addActionListener(this);
		btnExit.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnInput) {
			String name = txtName.getText().trim();
			String jname = comjob.getSelectedItem().toString().trim();
			String korStr = txtKor.getText().trim();
			String engStr = txtEng.getText().trim();
			String matStr = txtMat.getText().trim();
			if(name.equals("")||jname.equals("")||korStr.equals("")||engStr.equals("")||matStr.equals("")) {
				txtpool.setText("�̸�, ����, ����, ����, ���� ���� ��� �Է�");
				return;
			}
			int kor = Integer.parseInt(korStr);
			int eng = Integer.parseInt(engStr);
			int mat = Integer.parseInt(matStr);
			personDto newPerson = new personDto(name, jname, kor, eng, mat);
			int result = dao.insertPerson(newPerson);
			if(result == personDao.SUCCESS) {
				txtpool.setText(name+" insert success");
				txtName.setText("");
				comjob.setSelectedItem(0);
				txtKor.setText("");
				txtEng.setText("");
				txtMat.setText("");
			}
		}else if(e.getSource()==btnSearch) {
			String jname = comjob.getSelectedItem().toString().trim();
			if(jname.equals("")) {
				txtpool.setText("���� �Է�");
				return;
			}
			person = dao.selectJname(jname);
			txtpool.setText("���\t�̸�\t����\t����\t����\t����\t����\n");
			if(person.isEmpty()) {
				txtpool.setText(txtpool.getText()+"�ش� ������ ���Ե� �ο��� �����ϴ�.");
			}else {
				for(personDto temp: person) {
					txtpool.append(temp.toString()+"\n");
				}
			}
		}else if(e.getSource()==btnOutput) {
			person = dao.selectAll();
			txtpool.setText("���\t�̸�\t����\t����\t����\t����\t����\n");
			if(person.isEmpty()) {
				txtpool.setText(txtpool.getText()+"�ش� ������ ���Ե� �ο��� �����ϴ�.");
			}else {
				for(personDto temp: person) {
					txtpool.append(temp.toString()+"\n");
				}
			}
		}else if(e.getSource()==btnExit){
			setVisible(false);
			dispose();
			System.exit(0);
		}
	}
	
	public static void main(String[] args) {
		new personMngGUI("���� ����");
	}

}
