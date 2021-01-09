package com.lec.person_dao;

import java.util.ArrayList;
import java.util.Scanner;

public class PersonMng {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		personDao dao = personDao.getInstance();//���̺� �� ���� DAO �� ��, singleton
		String fn;
		ArrayList<personDto> person;
		do {
			System.out.println("1. �Է� | 2.������ ��� | 3. ��ü��� | �׿� ���� > ");
			fn = sc.next();
			switch(fn) {
			case "1":
				System.out.println("�Է��� �̸�: ");
				String name = sc.next();
				System.out.println("�Է��� ����: ");
				String jname = sc.next();
				System.out.println("���� ����: ");
				int kor = sc.nextInt();
				System.out.println("���� ����: ");
				int eng = sc.nextInt();
				System.out.println("���� ����: ");
				int mat = sc.nextInt();
				personDto newPerson = new personDto(name, jname, kor, eng, mat);
				int result = dao.insertPerson(newPerson);//�Է� ��
				System.out.println(result == personDao.SUCCESS? "success":"fail");
				break;
			case "2":
				System.out.println("����� ���� �Է�: ");
				jname = sc.next();
				person = dao.selectJname(jname);
				if(person.size()!=0) {
					System.out.println("���\t�̸�\t����\t����\t����\t����\t����");
					for(personDto temp: person) {
						System.out.println(temp);
					}
				}else {
					System.out.println("�ش� ������ �ο��� �����ϴ�.");
				}
				break;
			case "3":
				person = dao.selectAll();
				if(person.size()!=0) {
					System.out.println("���\t�̸�\t����\t����\t����\t����\t����");
					for(personDto temp: person) {
						System.out.println(temp);
					}
				}else {
					System.out.println("�ش� ������ �ο��� �����ϴ�.");
				}
				break;
			}
		}while(fn.equals("1")||fn.equals("2")||fn.equals("3"));
		System.out.println("END");
		sc.close();
	}
}
