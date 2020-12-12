package strategy3.step5.modularization;

import strategy3.step5.component.*;

public class Staff extends Person {
	private String part;
	public Staff(String name, String ID, String part) {
		setTodo(new JobMng());
		setMoney(new GetSalary());
		setName(name);
		setID(ID);
		this.part = part;
	}
	@Override
	public String toString() {
		return "교육생은  ID, 이름, "+part+"데이터를 갖습니다.";
	}
	@Override
	public void print() {
		super.print();
		System.out.println("[부서]"+part);
	}
}
