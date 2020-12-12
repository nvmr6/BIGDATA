package strategy3.step5.modularization;

import strategy3.step5.component.*;

public class Lecturer extends Person {
	private String subject;
	public Lecturer(String name, String ID, String subject) {
		setTodo(new JobLec());
		setMoney(new GetSalary());
		setName(name);
		setID(ID);
		this.subject = subject;
	}
	
	@Override
	public String toString() {
		return "교육생은  ID, 이름, "+subject+"데이터를 갖습니다.";
	}
	@Override
	public void print() {
		super.print();
		System.out.println("[과목]"+subject);
	}
}
