package com.lec.ex1_swing;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Homework extends JFrame implements ActionListener{
	private Container container;
	private JPanel panelUp, panelDown;
	private JTextField txtTel, txtName, txtPoint;
	private JButton btnJoin, btnSearch, btnPrint, btnExit;
	private JTextArea txtArea;
	private JScrollPane scroll;
	
	HashMap<String, Customer> customers = new HashMap<String, Customer>();
	public Homework(String title) {
		super(title);
		customers = new HashMap<String, Customer>();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		container = getContentPane();
		container.setLayout(new FlowLayout());
		panelUp = new JPanel(new GridLayout(3,2));
		panelDown = new JPanel(new FlowLayout());
		txtTel = new JTextField(15);
		txtName = new JTextField(15);
		txtPoint = new JTextField("1000", 15);
		txtArea = new JTextArea(15,30);
		scroll = new JScrollPane(txtArea);
		btnJoin = new JButton("가입");
		btnSearch = new JButton("조회");
		btnPrint = new JButton("출력");
		btnExit = new JButton("종료");
		
		panelUp.add(new JLabel("전화번호",(int)CENTER_ALIGNMENT));
		panelUp.add(txtTel);
		panelUp.add(new JLabel("이름",(int)CENTER_ALIGNMENT));
		panelUp.add(txtName);
		panelUp.add(new JLabel("포인트",(int)CENTER_ALIGNMENT));
		panelUp.add(txtPoint);
		panelDown.add(btnJoin);
		panelDown.add(btnSearch);
		panelDown.add(btnPrint);
		panelDown.add(btnExit);
		container.add(panelUp);
		container.add(panelDown);
		container.add(scroll);
		setBounds(300, 300, 400, 450);
		setVisible(true);
		setResizable(false);
		btnJoin.addActionListener(this);
		btnSearch.addActionListener(this);
		btnPrint.addActionListener(this);
		btnExit.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnJoin) {
			// customers에 put하고 jta에 출력후 textField지우기
						String tel, name; int point=1000;
						tel = txtTel.getText().trim();
						name = txtName.getText().trim();
						try {
							point = Integer.parseInt(txtTel.getText());
						}catch (Exception e1) { }
						
						int preIdx = tel.indexOf("-"); //첫-
						int postIdx = tel.lastIndexOf("-");//마지막-
						if(!tel.trim().equals("") && !name.trim().equals("") && preIdx<postIdx) { // 전화번호는 xxx-xx-xx타입으로 
							//가입
							Customer newCustomer = new Customer(tel, name, point); //새로운 객체
							customers.put(tel, newCustomer); //hashmap customer에 put
							System.out.println(newCustomer+"가입성공");
							txtArea.append(newCustomer.toString()+"\r\n");//화면 출력
							txtTel.setText("");
							txtName.setText("");
							txtPoint.setText("1000");
						}
			}else if(e.getSource()==btnSearch) {
				// 폰뒷4자리조회. 조회되면 textField에 뿌리기. 없는 번호면 없는 번호라고 뿌리기
				String searchPhone = txtTel.getText().trim(); //뒷자리 작성
				int cnt = 0;
				
				Iterator<String> iterator = customers.keySet().iterator(); //반복자 생성
				while(iterator.hasNext()) {
					String phone = iterator.next();
					String postPhone = phone.substring(phone.lastIndexOf('-')+1);//뒷자리
					if(postPhone.equals(searchPhone)) {
						txtTel.setText(customers.get(phone).getTel());
						txtName.setText(customers.get(phone).getName());
						//숫자 point를 문자로 바꿔 txtPoint에 넣음
						//txtPoint.setText(""+customers.get(phone).getPoint());
						txtPoint.setText(String.valueOf(customers.get(phone).getPoint()));//정수를 문자열로
						break; // 찾았으면 while문 빠져나감
					}
					cnt++;//목록 전체를 훓을 카운트
				}
				if(cnt==customers.size()) {
					txtTel.setText("없는 회원님");
					txtName.setText("");
					txtPoint.setText("1000");
				}
			}else if(e.getSource()==btnPrint) {
				Writer writer = null; //writer 이용
				try {
					writer = new FileWriter("icon/customer.txt",true);//파일 지정
					
					Iterator<String> iterator = customers.keySet().iterator();//반복자 생성
					while(iterator.hasNext()) {
						String phone = iterator.next();
						//System.out.println(customers.get(phone)); // 콘솔출력
						writer.write(customers.get(phone).toString()+"\r\n");
					}
					
				} catch (FileNotFoundException e1) {
					System.out.println(e1.getMessage());
				} catch (IOException e1) {
					System.out.println(e1.getMessage());
				}finally {
					try {
						if(writer!=null) writer.close();
					}catch (Exception e1) { }
				}
			}else if(e.getSource()==btnExit) {
				setVisible(false);
				dispose();
				System.exit(0);
			}
	}
	public static void main(String[] args) {
		new Homework("Customer GUI");
	}
}
