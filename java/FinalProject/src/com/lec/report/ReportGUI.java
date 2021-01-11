package com.lec.report;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ReportGUI extends JFrame implements ActionListener {
	private Container contenpane;
	private JPanel jpup, jpbtn;
	private JTextField txtSNo, txtSName, txtScore;
	private Vector<String> mnames;
	private JComboBox<String> comMname;
	private JButton btnSNoSearch, btnSNameSearch, btnMNameSearch, btnInput, btnUpdate, btnStudentOut, btnExpelOut,
			btnExpel, btnExit;
	private JTextArea txtpool;
	private JScrollPane scrollpane;

	private ReportDao dao = ReportDao.getInstance();
	private ArrayList<ReportDto> person;

	public ReportGUI(String title) {
		super();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		contenpane = getContentPane();
		contenpane.setLayout(new FlowLayout());
		jpup = new JPanel(new GridLayout(4, 3));
		jpbtn = new JPanel(new FlowLayout());

		txtSNo = new JTextField(10);
		txtSName = new JTextField(10);
		mnames = dao.mnameList();
		comMname = new JComboBox<String>(mnames);
		txtScore = new JTextField(10);
		btnSNoSearch = new JButton("�й��˻�");
		btnSNameSearch = new JButton("�̸��˻�");
		btnMNameSearch = new JButton("�����˻�");

		btnInput = new JButton("�л��Է�");
		btnUpdate = new JButton("�л�����");
		btnStudentOut = new JButton("�л����");
		btnExpelOut = new JButton("���������");
		btnExpel = new JButton("����ó��");
		btnExit = new JButton("����");

		txtpool = new JTextArea(10, 50);
		scrollpane = new JScrollPane(txtpool);

		jpup.add(new JLabel(("�й�"), (int) CENTER_ALIGNMENT));
		jpup.add(txtSNo);
		jpup.add(btnSNoSearch);
		jpup.add(new JLabel(("�̸�"), (int) CENTER_ALIGNMENT));
		jpup.add(txtSName);
		jpup.add(btnSNameSearch);
		jpup.add(new JLabel(("����"), (int) CENTER_ALIGNMENT));
		jpup.add(comMname);
		jpup.add(btnMNameSearch);
		jpup.add(new JLabel(("����"), (int) CENTER_ALIGNMENT));
		jpup.add(txtScore);

		jpbtn.add(btnInput);
		jpbtn.add(btnUpdate);
		jpbtn.add(btnStudentOut);
		jpbtn.add(btnExpelOut);
		jpbtn.add(btnExpel);
		jpbtn.add(btnExit);

		contenpane.add(jpup);
		contenpane.add(jpbtn);
		contenpane.add(scrollpane);

		setSize(new Dimension(600, 450));
		setLocation(500, 200);
		setVisible(true);

		btnSNoSearch.addActionListener(this);
		btnSNameSearch.addActionListener(this);
		btnMNameSearch.addActionListener(this);
		btnInput.addActionListener(this);
		btnUpdate.addActionListener(this);
		btnStudentOut.addActionListener(this);
		btnExpelOut.addActionListener(this);
		btnExpel.addActionListener(this);
		btnExit.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSNoSearch) {
			String sno = txtSNo.getText().toString().trim();
			if (sno.equals("")) {
				txtSNo.setText("");
				txtSName.setText("");
				comMname.setSelectedIndex(0);
				txtScore.setText("");
				txtpool.setText("�й� �Է�");
				return;
			}
			ReportDto dto = dao.selectSno(sno);
			if (dto != null) {
				System.out.println(txtpool.getText() + sno + "�˻��Ϸ�");
				txtSNo.setText(sno);
				txtSName.setText(dto.getSname());
				comMname.setSelectedItem(dto.getMname());
				txtScore.setText(String.valueOf(dto.getScore()));
			} else {
				txtSNo.setText("");
				txtSName.setText("");
				comMname.setSelectedIndex(0);
				txtScore.setText("");
				System.out.println(txtpool.getText() + "��ȿ���� ���� �й��Դϴ�.");
			}
		} else if (e.getSource() == btnSNameSearch) {
			String sname = txtSName.getText().trim();
			if (sname.length() == 0) {
				txtSNo.setText("");
				txtSName.setText("");
				comMname.setSelectedIndex(0);
				txtScore.setText("");
				txtpool.setText("�̸� �Է�");
				return;
			}
			ArrayList<ReportDto> student = dao.selectSname(sname);
			if (student.size() > 1) {
				txtpool.setText("�й�\t�̸�\t�а�\t����\n");
				for (ReportDto temp : student) {
					txtpool.append(temp.toString() + "\n");
					txtSNo.setText(temp.getSno());
					comMname.setSelectedItem(temp.getMname());
					txtScore.setText(String.valueOf(temp.getScore()));
				}
			} else if (student.size() == 1) {
				txtSNo.setText(student.get(0).getSno());
				comMname.setSelectedItem(student.get(0).getMname());
				txtScore.setText(String.valueOf(student.get(0).getScore()));
			} else {
				txtSNo.setText("");
				comMname.setSelectedItem("");
				txtScore.setText("");
				txtpool.setText("�ش� �̸��� �л��� �����ϴ�");
			}
		} else if (e.getSource() == btnMNameSearch) {
			String mname = comMname.getSelectedItem().toString().trim();
			if (mname.equals("")) {
				txtpool.setText("���� ����");
				return;
			}
			person = dao.selectMname(mname);
			txtpool.setText("���\t�̸�\t\t�а�\t����\n");
			if (person.isEmpty()) {
				System.out.println(txtpool.getText() + "�ش� ������ ���Ե� �л��� �����ϴ�.");
			} else {
				for (ReportDto temp : person) {
					txtpool.append(temp.toString() + "\n");
				}
			}
		} else if (e.getSource() == btnInput) {
			String sname = txtSName.getText().trim();
			String mname = comMname.getSelectedItem().toString().trim();
			String scoreStr = txtScore.getText().trim();
			if (sname.equals("") || mname.equals("") || scoreStr.equals("")) {
				txtpool.setText("�̸�, ����, ���� ��� �Է�");
				return;
			}
			int score = Integer.parseInt(scoreStr);
			int sexpel = 0;
			ReportDto newPerson = new ReportDto(sname, mname, score, sexpel);
			int result = dao.insertReport(newPerson);
			if (result == ReportDao.SUCCESS) {
				txtpool.setText(sname + " insert success");
				txtSName.setText("");
				comMname.setSelectedItem(0);
				txtScore.setText("");
			}
		} else if (e.getSource() == btnUpdate) {
			String sno = txtSNo.getText().trim();
			String sname = txtSName.getText().trim();
			String mname = comMname.getSelectedItem().toString().trim();
			String scoreStr = txtScore.getText().trim();
			if (sname.equals("") || mname.equals("") || scoreStr.equals("")) {
				txtpool.setText("�̸�, ����, ���� ��� �Է�");
				return;
			}
			int score = Integer.parseInt(scoreStr);
			int result = dao.updateReport(sno, sname, mname, score);
			if (result == ReportDao.SUCCESS) {
				txtpool.setText(sname + " update success");
				txtSName.setText("");
				comMname.setSelectedItem(0);
				txtScore.setText("");
			}
		} else if (e.getSource() == btnStudentOut) {
			person = dao.selectUnexpel();
			txtpool.setText("���\t�̸�\t\t�а�\t����\n");
			if (person.isEmpty()) {
				txtpool.setText(txtpool.getText() + "����� �л��� �������� �ʽ��ϴ�.");
			} else {
				for (ReportDto temp : person) {
					txtpool.append(temp.toString() + "\n");
				}
			}
		} else if (e.getSource() == btnExpelOut) {
			person = dao.selectExpel();
			txtpool.setText("���\t�̸�\t\t�а�\t����\n");
			if (person.isEmpty()) {
				txtpool.setText(txtpool.getText() + "����� �л��� �������� �ʽ��ϴ�.");
			} else {
				for (ReportDto temp : person) {
					txtpool.append(temp.toString() + "\n");
				}
			}
		} else if (e.getSource() == btnExpel) {
			String sno = txtSNo.getText().trim();
			if (sno.equals("")) {
				txtSNo.setText("");
				txtSName.setText("");
				comMname.setSelectedIndex(0);
				txtScore.setText("");
				txtpool.setText("�й� �Է�");
				return;
			}
			ReportDto dto = dao.selectSno(sno);
			if (dto != null) {
				txtSName.setText(dto.getSname());
				comMname.setSelectedItem(dto.getMname());
				txtScore.setText(String.valueOf(dto.getScore()));
			} else {
				txtSNo.setText("");
				txtSName.setText("");
				comMname.setSelectedIndex(0);
				txtScore.setText("");
				System.out.println(txtpool.getText() + "��ȿ���� ���� �й��Դϴ�.");
			}
			int result = dao.updateExpel(sno);
			if (result == ReportDao.SUCCESS) {
				txtpool.setText(txtpool.getText() + sno + " expel success");
				txtSName.setText(dto.getSname());
				comMname.setSelectedItem(dto.getMname());
				txtScore.setText(String.valueOf(dto.getScore()));
			}
		} else if (e.getSource() == btnExit) {
			setVisible(false);
			dispose();
			System.exit(0);
		}
	}

	public static void main(String[] args) {
		new ReportGUI("�л� ����");
	}
}
