package com.lec.report;

import java.util.ArrayList;
import java.util.Scanner;

public class Report {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ReportDao dao = ReportDao.getInstance();
		String fn;
		ArrayList<ReportDto> person;
		
		do {
			System.out.println("1. �Է� | 2.�а��� ��� | 3. �Ϲ� �л� ���� ��� | 4. ���� �л� ���� ��� | �׿� ���� > ");
			fn = sc.next();
			switch(fn) {
			case "1":
				System.out.println("�Է��� �̸�: ");
				String sname = sc.next();
				System.out.println("�Է��� �а�: ");
				String mname = sc.next();
				System.out.println("�Է��� ����: ");
				int score = sc.nextInt();
				if(score<0 || score>100) {
					System.out.println("��ȿ���� ���� ����");
					continue;
				}
//				System.out.println("���� ����(0: ���� | 1: ����): ");
				int sexpel = 0;
				ReportDto newPerson = new ReportDto(sname, mname, score, sexpel);
				int result = dao.insertReport(newPerson);
				System.out.println(result==ReportDao.SUCCESS? "success":"fail");
				break;
			case "2":
				System.out.println("����� �а� �Է�: ");
				mname = sc.next();
				person = dao.selectMname(mname);
				if(person.size()!=0) {
					System.out.println("���\t�̸�\t\t�а�\t����\t���� ����");
					for(ReportDto temp: person) {
						System.out.println(temp);
					}
				}else {
					System.out.println("�ش� �а��� �ο��� �����ϴ�.");
				}
				break;
			case "3":
				person = dao.selectUnexpel();
				if(person.size()!=0) {
					System.out.println("���\t�̸�\t\t�а�\t����");
					for(ReportDto temp: person) {
						System.out.println(temp);
					}
				}else {
					System.out.println("�ش� �а��� �ο��� �����ϴ�.");
				}
				break;
			case "4":
				person = dao.selectExpel();
				if(person.size()!=0) {
					System.out.println("���\t�̸�\t\t�а�\t����");
					for(ReportDto temp: person) {
						System.out.println(temp);
					}
				}else {
					System.out.println("�ش� �а��� �ο��� �����ϴ�.");
				}
				break;
			}
		}while(fn.equals("1")||fn.equals("2")||fn.equals("3")||fn.equals("4"));
		System.out.println("END");
		sc.close();
	}
}
