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
			System.out.println("1. 입력 | 2.학과별 출력 | 3. 일반 학생 성적 출력 | 4. 제적 학생 성적 출력 | 그외 종료 > ");
			fn = sc.next();
			switch(fn) {
			case "1":
				System.out.println("입력할 이름: ");
				String sname = sc.next();
				System.out.println("입력할 학과: ");
				String mname = sc.next();
				System.out.println("입력할 점수: ");
				int score = sc.nextInt();
				if(score<0 || score>100) {
					System.out.println("유효하지 않은 점수");
					continue;
				}
//				System.out.println("제적 여부(0: 정상 | 1: 제적): ");
				int sexpel = 0;
				ReportDto newPerson = new ReportDto(sname, mname, score, sexpel);
				int result = dao.insertReport(newPerson);
				System.out.println(result==ReportDao.SUCCESS? "success":"fail");
				break;
			case "2":
				System.out.println("출력할 학과 입력: ");
				mname = sc.next();
				person = dao.selectMname(mname);
				if(person.size()!=0) {
					System.out.println("등수\t이름\t\t학과\t점수\t제적 여부");
					for(ReportDto temp: person) {
						System.out.println(temp);
					}
				}else {
					System.out.println("해당 학과에 인원이 없습니다.");
				}
				break;
			case "3":
				person = dao.selectUnexpel();
				if(person.size()!=0) {
					System.out.println("등수\t이름\t\t학과\t점수");
					for(ReportDto temp: person) {
						System.out.println(temp);
					}
				}else {
					System.out.println("해당 학과에 인원이 없습니다.");
				}
				break;
			case "4":
				person = dao.selectExpel();
				if(person.size()!=0) {
					System.out.println("등수\t이름\t\t학과\t점수");
					for(ReportDto temp: person) {
						System.out.println(temp);
					}
				}else {
					System.out.println("해당 학과에 인원이 없습니다.");
				}
				break;
			}
		}while(fn.equals("1")||fn.equals("2")||fn.equals("3")||fn.equals("4"));
		System.out.println("END");
		sc.close();
	}
}
