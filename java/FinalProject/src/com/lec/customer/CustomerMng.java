package com.lec.customer;

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

public class CustomerMng extends JFrame implements ActionListener {
	private Container container;
	private JPanel jpup, jpbtn;
	private JTextField jtxtId, jtxtTel, jtxtName, jtxtPoint, jtxtAmount;
	private Vector<String> levels;
	private JComboBox<String> jcomLevel;
	private JButton jbtnIdSearch, jbtnTelSearch, jbtnNameSearch, jbtnPoint, jbtnReset;
	private JButton jbtnBuy, jbtnLevelOutput, jbtnAllOutput, jbtnInsert, jbtnTelUpdate, jbtnDelete, jbtnExit;
	private JTextArea jtxtPool;
	private JScrollPane scrollPane;

	private CustomerDao dao = CustomerDao.getInstance();
	private ArrayList<CustomerDto> person;

	public CustomerMng(String title) {
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		container = getContentPane();
		container.setLayout(new FlowLayout());
		jpup = new JPanel(new GridLayout(6, 3));
		jpbtn = new JPanel();

		jtxtId = new JTextField(20);
		jtxtTel = new JTextField(20);
		jtxtName = new JTextField(20);
		jtxtPoint = new JTextField(20);
		jtxtAmount = new JTextField(20);
		levels = dao.levels();
		jcomLevel = new JComboBox<String>(levels);
		jbtnIdSearch = new JButton("아이디 검색");
		jbtnTelSearch = new JButton("폰4자리(FULL) 검색");
		jbtnNameSearch = new JButton("고객 이름 검색");
		jbtnPoint = new JButton("포인트로만 구매");
		jbtnReset = new JButton("리셋");

		jpup.add(new JLabel(" 아 이 디 ", (int) CENTER_ALIGNMENT));
		jpup.add(jtxtId);
		jpup.add(jbtnIdSearch);
		jpup.add(new JLabel("고 객 전 화", (int) CENTER_ALIGNMENT));
		jpup.add(jtxtTel);
		jpup.add(jbtnTelSearch);
		jpup.add(new JLabel("고 객 이 름", (int) CENTER_ALIGNMENT));
		jpup.add(jtxtName);
		jpup.add(jbtnNameSearch);
		jpup.add(new JLabel("포  인  트", (int) CENTER_ALIGNMENT));
		jpup.add(jtxtPoint);
		jpup.add(jbtnPoint);
		jpup.add(new JLabel("구 매 금 액", (int) CENTER_ALIGNMENT));
		jpup.add(jtxtAmount);
		jpup.add(new JLabel(""));// 빈 라벨 추가하는 부분
		jpup.add(new JLabel("고 객 등 급", (int) CENTER_ALIGNMENT));
		jpup.add(jcomLevel);
		jpup.add(jbtnReset);

		jbtnBuy = new JButton("물품 구매");
		jbtnLevelOutput = new JButton("등급별출력");
		jbtnAllOutput = new JButton("전체출력");
		jbtnInsert = new JButton("회원가입");
		jbtnTelUpdate = new JButton("번호수정");
		jbtnDelete = new JButton("회원탈퇴");
		jbtnExit = new JButton("나가기");

		jpbtn.add(jbtnBuy);
		jpbtn.add(jbtnLevelOutput);
		jpbtn.add(jbtnAllOutput);
		jpbtn.add(jbtnInsert);
		jpbtn.add(jbtnTelUpdate);
		jpbtn.add(jbtnDelete);
		jpbtn.add(jbtnExit);
		jtxtPool = new JTextArea(10, 70);
		scrollPane = new JScrollPane(jtxtPool);

		container.add(jpup);
		container.add(jpbtn);
		container.add(scrollPane);
		setSize(new Dimension(800, 500));
		setLocation(200, 200);
		setVisible(true);
		jtxtPool.setText("\t★ ★ ★ 고객검색 후 구매하세요 ★ ★ ★");

		jbtnIdSearch.addActionListener(this);
		jbtnTelSearch.addActionListener(this);
		jbtnNameSearch.addActionListener(this);
		jbtnPoint.addActionListener(this);
		jbtnBuy.addActionListener(this);
		jbtnLevelOutput.addActionListener(this);
		jbtnAllOutput.addActionListener(this);
		jbtnInsert.addActionListener(this);
		jbtnTelUpdate.addActionListener(this);
		jbtnDelete.addActionListener(this);
		jbtnExit.addActionListener(this);
		jbtnReset.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == jbtnIdSearch) {
			String cId = jtxtId.getText().toString().trim();
			if (cId.length() == 0) {
				jtxtTel.setText("");
				jtxtName.setText("");
				jtxtPoint.setText("");
				jtxtAmount.setText("");
				jcomLevel.setSelectedIndex(0);
				jtxtPool.setText("아이디 필수 입력");
				return;
			}
			CustomerDto dto = dao.cIdGetCustomers(Integer.parseInt(cId));
			if (dto != null) {
				System.out.println(jtxtPool.getText() + cId + "검색완료");
				jtxtId.setText(cId);
				jtxtTel.setText(dto.getcTel());
				jtxtName.setText(dto.getcName());
				jtxtPoint.setText(String.valueOf(dto.getcPoint()));
				jtxtAmount.setText(String.valueOf(dto.getcAmount()));
				jcomLevel.setSelectedItem(dto.getLevelName());
			} else {
				jtxtTel.setText("");
				jtxtName.setText("");
				jtxtPoint.setText("");
				jtxtAmount.setText("");
				jcomLevel.setSelectedIndex(0);
				System.out.println(jtxtPool.getText() + "유효하지 않은 아이디입니다.");
			}
		} else if (e.getSource() == jbtnTelSearch) {
			String cTel = jtxtTel.getText().toString().trim();
			if (cTel.length() == 0) {
				jtxtId.setText("");
				jtxtName.setText("");
				jtxtPoint.setText("");
				jtxtAmount.setText("");
				jcomLevel.setSelectedIndex(0);
				jtxtPool.setText("전화번호 필수 입력");
				return;
			}
			ArrayList<CustomerDto> dto = dao.cTelGetCustomers(cTel);
			if (dto.size() > 1) {
				jtxtPool.setText("ID\t전화번호\t이름\t포인트\t구매 누적액\t고객레벨\t다음 레벨까지 필요금액\n"
						+ "----------------------------------------------------------------------------------"
						+ "-------------------------------------------------------------------------------\n");
				for (CustomerDto temp : dto) {
					jtxtPool.append(temp.toString() + "\n");
					jtxtId.setText(String.valueOf(temp.getcId()));
					jtxtTel.setText(temp.getcTel());
					jtxtName.setText(temp.getcName());
					jtxtPoint.setText(String.valueOf(temp.getcPoint()));
					jtxtAmount.setText(String.valueOf(temp.getcAmount()));
					jcomLevel.setSelectedItem(temp.getLevelName());
				}
			} else if (dto.size() == 1) {
				jtxtId.setText(String.valueOf(dto.get(0).getcId()));
				jtxtTel.setText(dto.get(0).getcTel());
				jtxtName.setText(dto.get(0).getcName());
				jtxtPoint.setText(String.valueOf(dto.get(0).getcPoint()));
				jtxtAmount.setText(String.valueOf(dto.get(0).getcAmount()));
				jcomLevel.setSelectedItem(dto.get(0).getLevelName());
			} else {
				jtxtId.setText("");
				jtxtTel.setText("");
				jtxtName.setText("");
				jtxtPoint.setText("");
				jtxtAmount.setText("");
				jcomLevel.setSelectedIndex(0);
				jtxtPool.setText("해당 번호에 해당되는 고객이 없습니다.");
			}
		} else if (e.getSource() == jbtnNameSearch) {
			String cName = jtxtName.getText().toString().trim();
			if (cName.length() == 0) {
				jtxtId.setText("");
				jtxtTel.setText("");
				jtxtPoint.setText("");
				jtxtAmount.setText("");
				jcomLevel.setSelectedIndex(0);
				jtxtPool.setText("이름 필수 입력");
				return;
			}
			ArrayList<CustomerDto> dto = dao.cNameGetCustomers(cName);
			if (dto.size() >= 1) {
				jtxtPool.setText("ID\t전화번호\t이름\t포인트\t구매 누적액\t고객레벨\t다음 레벨까지 필요금액\n"
						+ "----------------------------------------------------------------------------------"
						+ "-------------------------------------------------------------------------------\n");
				for (CustomerDto temp : dto) {
					jtxtPool.append(temp.toString() + "\n");
					jtxtId.setText(String.valueOf(temp.getcId()));
					jtxtTel.setText(temp.getcTel());
					jtxtName.setText(temp.getcName());
					jtxtPoint.setText(String.valueOf(temp.getcPoint()));
					jtxtAmount.setText(String.valueOf(temp.getcAmount()));
					jcomLevel.setSelectedItem(temp.getLevelName());
				}
			}else {
				jtxtId.setText("");
				jtxtTel.setText("");
				jtxtName.setText("");
				jtxtPoint.setText("");
				jtxtAmount.setText("");
				jcomLevel.setSelectedIndex(0);
				jtxtPool.setText("해당 이름에 해당되는 고객이 없습니다.");
			}
		} else if (e.getSource() == jbtnPoint) {
			String cId = jtxtId.getText().trim();
			String cAmount = jtxtAmount.getText().trim();
			if (cId.equals("") || cAmount.equals("")) {
				jtxtPool.setText("아이디와 금액 모두 입력");
				return;
			}
			int result = dao.buyWithPoint(Integer.parseInt(cAmount), Integer.parseInt(cId));
			if (result == CustomerDao.SUCCESS) {
				jtxtPool.setText("아이디: " + cId + "의 포인트로 구매 완료");
			} else {
				jtxtPool.setText("포인트가 부족합니다.");
			}
		} else if (e.getSource() == jbtnReset) {
			jtxtId.setText("");
			jtxtTel.setText("");
			jtxtName.setText("");
			jtxtPoint.setText("");
			jtxtAmount.setText("");
			jcomLevel.setSelectedIndex(0);
			jtxtPool.setText("");
		} else if (e.getSource() == jbtnBuy) {
			String cAmount = jtxtAmount.getText().trim();
			String cTel = jtxtTel.getText().trim();
			String cId = jtxtId.getText().trim();
			if (cId.equals("") || cTel.equals("") || cAmount.equals("")) {
				jtxtPool.setText("아이디와 금액 모두 입력");
				return;
			}
			int result = dao.buy(Integer.parseInt(cAmount), cTel, Integer.parseInt(cId));
			if (result == CustomerDao.SUCCESS) {
				jtxtPool.setText("아이디: " + cId + " 물품 구매 및 포인트 적립 완료");
			}
		} else if (e.getSource() == jbtnLevelOutput) {
			String levelName = jcomLevel.getSelectedItem().toString().trim();
			if (levelName.equals("")) {
				System.out.println("고객 등급 선택");
			}
			person = dao.levelNameGetCustomers(levelName);
			jtxtPool.setText("ID\t전화번호\t이름\t포인트\t구매 누적액\t고객레벨\t다음 레벨까지 필요금액\n"
					+ "----------------------------------------------------------------------------------"
					+ "-------------------------------------------------------------------------------\n");
			if (person.isEmpty()) {
				jtxtPool.setText(jtxtPool.getText() + "해당 등급에 포함된 고객이 없습니다.");
			} else {
				for (CustomerDto temp : person) {
					jtxtPool.append(temp.toString() + "\n");
				}
			}
		} else if (e.getSource() == jbtnAllOutput) {
			person = dao.getCustomers();
			jtxtPool.setText("ID\t전화번호\t이름\t포인트\t구매 누적액\t고객레벨\t다음 레벨까지 필요금액\n"
					+ "----------------------------------------------------------------------------------"
					+ "-------------------------------------------------------------------------------\n");
			if (person.isEmpty()) {
				jtxtPool.setText(jtxtPool.getText() + "해당 등급에 포함된 고객이 없습니다.");
			} else {
				for (CustomerDto temp : person) {
					jtxtPool.append(temp.toString() + "\n");
				}
			}
		} else if (e.getSource() == jbtnInsert) {
			String cTel = jtxtTel.getText().toString().trim();
			String cName = jtxtName.getText().toString().trim();
			if (cTel.equals("") || cName.equals("")) {
				jtxtPool.setText("전화번호, 이름 모두 입력");
				return;
			}
			CustomerDto newPerson = new CustomerDto(cTel, cName);
			int result = dao.insertCustomer(newPerson);
			if (result == CustomerDao.SUCCESS) {
				jtxtPool.setText(cName + "님 가입 완료");
				jtxtId.setText("");
				jtxtTel.setText("");
				jtxtName.setText("");
				jtxtPoint.setText("");
				jtxtAmount.setText("");
				jcomLevel.setSelectedIndex(0);
			}
		} else if (e.getSource() == jbtnTelUpdate) {
			String cId = jtxtId.getText().trim();
			String cTel = jtxtTel.getText().trim();
			if (cId.equals("") || cTel.equals("")) {
				jtxtPool.setText("아이디와 바꿀 전화번호 모두 입력");
				return;
			}
			int result = dao.updateCustomer(cTel, Integer.parseInt(cId));
			if (result == CustomerDao.SUCCESS) {
				jtxtPool.setText("아이디: " + cId + "님 전화번호 수정 완료");
			}
		} else if (e.getSource() == jbtnDelete) {
			String cId = jtxtId.getText().trim();
			if (cId.equals("")) {
				jtxtPool.setText("삭제할 아이디 입력");
				return;
			}
			int result = dao.deleteCustomer(Integer.parseInt(cId));
			if (result == CustomerDao.SUCCESS) {
				jtxtPool.setText("아이디: " + cId + "님 탈퇴 완료");
				jtxtId.setText("");
				jtxtTel.setText("");
				jtxtName.setText("");
				jtxtPoint.setText("");
				jtxtAmount.setText("");
				jcomLevel.setSelectedIndex(0);
			}
		} else if (e.getSource() == jbtnExit) {
			setVisible(false);
			dispose();
			System.exit(0);
		}
	}

	public static void main(String[] args) {
		new CustomerMng("고객관리");
	}

}
