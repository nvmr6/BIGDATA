package strategy3.step5.modularization;

public class TestMain {
	public static void main(String[] args) {
		Person st1 = new Student("30301", "강학생", "python반");
		Person st2 = new Student("30302", "강공부", "Java반");
		Person gs1 = new Lecturer("J01", "홍강의", "hadoop반");
		Person gs2 = new Lecturer("J02", "김수업", "db");
		Person s = new Staff("A01", "신일해", "취업지원");
		
		Person[] person = {st1, st2, gs1, gs2, s};
		
		System.out.println("업무시간\n");
		for(Person p : person)
			p.isTodo();
		System.out.println("\n월말 지급\n");
		for(Person p : person)
			p.isMoney();
		System.out.println("\n인원 상태 출력\n");
		for(Person p : person)
			p.print();
	}
}
