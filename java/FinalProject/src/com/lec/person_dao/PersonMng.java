package com.lec.person_dao;

import java.util.ArrayList;
import java.util.Scanner;

public class PersonMng {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		personDao dao = personDao.getInstance();//테이블 한 개당 DAO 한 개, singleton
		String fn;
		ArrayList<personDto> person;
		do {
			System.out.println("1. 입력 | 2.직업별 출력 | 3. 전체출력 | 그외 종료 > ");
			fn = sc.next();
			switch(fn) {
			case "1":
				System.out.println("입력할 이름: ");
				String name = sc.next();
				System.out.println("입력할 직업: ");
				String jname = sc.next();
				System.out.println("국어 점수: ");
				int kor = sc.nextInt();
				System.out.println("영어 점수: ");
				int eng = sc.nextInt();
				System.out.println("수학 점수: ");
				int mat = sc.nextInt();
				personDto newPerson = new personDto(name, jname, kor, eng, mat);
				int result = dao.insertPerson(newPerson);//입력 끝
				System.out.println(result == personDao.SUCCESS? "success":"fail");
				break;
			case "2":
				System.out.println("출력할 직업 입력: ");
				jname = sc.next();
				person = dao.selectJname(jname);
				if(person.size()!=0) {
					System.out.println("등수\t이름\t직업\t국어\t영어\t수학\t총점");
					for(personDto temp: person) {
						System.out.println(temp);
					}
				}else {
					System.out.println("해당 직업의 인원이 없습니다.");
				}
				break;
			case "3":
				person = dao.selectAll();
				if(person.size()!=0) {
					System.out.println("등수\t이름\t직업\t국어\t영어\t수학\t총점");
					for(personDto temp: person) {
						System.out.println(temp);
					}
				}else {
					System.out.println("해당 직업의 인원이 없습니다.");
				}
				break;
			}
		}while(fn.equals("1")||fn.equals("2")||fn.equals("3"));
		System.out.println("END");
		sc.close();
	}
}
