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
		btnJoin = new JButton("����");
		btnSearch = new JButton("��ȸ");
		btnPrint = new JButton("���");
		btnExit = new JButton("����");
		
		panelUp.add(new JLabel("��ȭ��ȣ",(int)CENTER_ALIGNMENT));
		panelUp.add(txtTel);
		panelUp.add(new JLabel("�̸�",(int)CENTER_ALIGNMENT));
		panelUp.add(txtName);
		panelUp.add(new JLabel("����Ʈ",(int)CENTER_ALIGNMENT));
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
			// customers�� put�ϰ� jta�� ����� textField�����
						String tel, name; int point=1000;
						tel = txtTel.getText().trim();
						name = txtName.getText().trim();
						try {
							point = Integer.parseInt(txtTel.getText());
						}catch (Exception e1) { }
						
						int preIdx = tel.indexOf("-"); //ù-
						int postIdx = tel.lastIndexOf("-");//������-
						if(!tel.trim().equals("") && !name.trim().equals("") && preIdx<postIdx) { // ��ȭ��ȣ�� xxx-xx-xxŸ������ 
							//����
							Customer newCustomer = new Customer(tel, name, point); //���ο� ��ü
							customers.put(tel, newCustomer); //hashmap customer�� put
							System.out.println(newCustomer+"���Լ���");
							txtArea.append(newCustomer.toString()+"\r\n");//ȭ�� ���
							txtTel.setText("");
							txtName.setText("");
							txtPoint.setText("1000");
						}
			}else if(e.getSource()==btnSearch) {
				// ����4�ڸ���ȸ. ��ȸ�Ǹ� textField�� �Ѹ���. ���� ��ȣ�� ���� ��ȣ��� �Ѹ���
				String searchPhone = txtTel.getText().trim(); //���ڸ� �ۼ�
				int cnt = 0;
				
				Iterator<String> iterator = customers.keySet().iterator(); //�ݺ��� ����
				while(iterator.hasNext()) {
					String phone = iterator.next();
					String postPhone = phone.substring(phone.lastIndexOf('-')+1);//���ڸ�
					if(postPhone.equals(searchPhone)) {
						txtTel.setText(customers.get(phone).getTel());
						txtName.setText(customers.get(phone).getName());
						//���� point�� ���ڷ� �ٲ� txtPoint�� ����
						//txtPoint.setText(""+customers.get(phone).getPoint());
						txtPoint.setText(String.valueOf(customers.get(phone).getPoint()));//������ ���ڿ���
						break; // ã������ while�� ��������
					}
					cnt++;//��� ��ü�� �f�� ī��Ʈ
				}
				if(cnt==customers.size()) {
					txtTel.setText("���� ȸ����");
					txtName.setText("");
					txtPoint.setText("1000");
				}
			}else if(e.getSource()==btnPrint) {
				Writer writer = null; //writer �̿�
				try {
					writer = new FileWriter("icon/customer.txt",true);//���� ����
					
					Iterator<String> iterator = customers.keySet().iterator();//�ݺ��� ����
					while(iterator.hasNext()) {
						String phone = iterator.next();
						//System.out.println(customers.get(phone)); // �ܼ����
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
