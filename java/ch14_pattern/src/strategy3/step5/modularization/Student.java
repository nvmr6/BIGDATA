package strategy3.step5.modularization;

import strategy3.step5.component.*;

public class Student extends Person {
	private String ban;
	
	public Student(String name, String ID, String ban) {
		setTodo(new JobStudy());
		setMoney(new GetStudentPay());
		setName(name);
		setID(ID);
		this.ban = ban;
	}
	@Override
	public String toString() {
		return "교육생은  ID, 이름, "+ban+"데이터를 갖습니다.";
	}
	@Override
	public void print() {
		super.print();
		System.out.println("[과목]"+ban);
	}
}
