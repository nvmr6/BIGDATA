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
		btnSNoSearch = new JButton("학번검색");
		btnSNameSearch = new JButton("이름검색");
		btnMNameSearch = new JButton("전공검색");

		btnInput = new JButton("학생입력");
		btnUpdate = new JButton("학생수정");
		btnStudentOut = new JButton("학생출력");
		btnExpelOut = new JButton("제적자출력");
		btnExpel = new JButton("제적처리");
		btnExit = new JButton("종료");

		txtpool = new JTextArea(10, 50);
		scrollpane = new JScrollPane(txtpool);

		jpup.add(new JLabel(("학번"), (int) CENTER_ALIGNMENT));
		jpup.add(txtSNo);
		jpup.add(btnSNoSearch);
		jpup.add(new JLabel(("이름"), (int) CENTER_ALIGNMENT));
		jpup.add(txtSName);
		jpup.add(btnSNameSearch);
		jpup.add(new JLabel(("전공"), (int) CENTER_ALIGNMENT));
		jpup.add(comMname);
		jpup.add(btnMNameSearch);
		jpup.add(new JLabel(("점수"), (int) CENTER_ALIGNMENT));
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
				txtpool.setText("학번 입력");
				return;
			}
			ReportDto dto = dao.selectSno(sno);
			if (dto != null) {
				System.out.println(txtpool.getText() + sno + "검색완료");
				txtSNo.setText(sno);
				txtSName.setText(dto.getSname());
				comMname.setSelectedItem(dto.getMname());
				txtScore.setText(String.valueOf(dto.getScore()));
			} else {
				txtSNo.setText("");
				txtSName.setText("");
				comMname.setSelectedIndex(0);
				txtScore.setText("");
				System.out.println(txtpool.getText() + "유효하지 않은 학번입니다.");
			}
		} else if (e.getSource() == btnSNameSearch) {
			String sname = txtSName.getText().trim();
			if (sname.length() == 0) {
				txtSNo.setText("");
				txtSName.setText("");
				comMname.setSelectedIndex(0);
				txtScore.setText("");
				txtpool.setText("이름 입력");
				return;
			}
			ArrayList<ReportDto> student = dao.selectSname(sname);
			if (student.size() > 1) {
				txtpool.setText("학번\t이름\t학과\t점수\n");
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
				txtpool.setText("해당 이름의 학생이 없습니다");
			}
		} else if (e.getSource() == btnMNameSearch) {
			String mname = comMname.getSelectedItem().toString().trim();
			if (mname.equals("")) {
				txtpool.setText("전공 선택");
				return;
			}
			person = dao.selectMname(mname);
			txtpool.setText("등수\t이름\t\t학과\t점수\n");
			if (person.isEmpty()) {
				System.out.println(txtpool.getText() + "해당 전공에 포함된 학생이 없습니다.");
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
				txtpool.setText("이름, 전공, 점수 모두 입력");
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
				txtpool.setText("이름, 전공, 점수 모두 입력");
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
			txtpool.setText("등수\t이름\t\t학과\t점수\n");
			if (person.isEmpty()) {
				txtpool.setText(txtpool.getText() + "출력할 학생이 존재하지 않습니다.");
			} else {
				for (ReportDto temp : person) {
					txtpool.append(temp.toString() + "\n");
				}
			}
		} else if (e.getSource() == btnExpelOut) {
			person = dao.selectExpel();
			txtpool.setText("등수\t이름\t\t학과\t점수\n");
			if (person.isEmpty()) {
				txtpool.setText(txtpool.getText() + "출력할 학생이 존재하지 않습니다.");
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
				txtpool.setText("학번 입력");
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
				System.out.println(txtpool.getText() + "유효하지 않은 학번입니다.");
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
		new ReportGUI("학사 관리");
	}
}
