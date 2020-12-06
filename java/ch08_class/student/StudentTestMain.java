package com.lec.student;


public class StudentTestMain {
	public static void main(String[] args) {
		Student [] person = {new Student("정우성", 90, 80, 95),
						     new Student("김하늘", 100, 80, 95),
						     new Student("황정민", 95, 80, 90),
						     new Student("강동원", 95, 90, 99),
						     new Student("유아인", 90, 90, 90)};
		System.out.println("\t\t성\t적\t표\t\t\t");
		System.out.println("---------------------------------------------");
		System.out.println("번호 이름\t국어\t영어\t수학\t총점\t평균");
		System.out.println("---------------------------------------------");
		for(Student temp: person) {
			
			temp.setTot();
			temp.setAvg();
			System.out.print(Student.count);
			temp.printScore();
		}
		System.out.println("---------------------------------------------");
		
		int totkor = 0, toteng = 0, totmat = 0, tottot = 0; double totavg = 0;;
		for(int i = 0;i<person.length;i++) {
			totkor += person[i].getKor();
			toteng += person[i].getEng();
			totmat += person[i].getMat();
			tottot += person[i].getTot();
			totavg += person[i].getAvg();
		}
		System.out.printf("%s\t%d\t%d\t%d\t%d\t%d\n","총점",totkor,toteng,totmat,tottot,(int)totavg);
		System.out.printf("%s\t%.1f\t%.1f\t%.1f\t%.1f\t%.1f\n","평균",totkor/5.0,toteng/5.0,totmat/5.0,tottot/5.0,totavg/5.0);
		System.out.println("---------------------------------------------");
	}

}
