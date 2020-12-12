package strategy3.step5.modularization;

import strategy3.step5.component.*;

public class Person {
	private ITodo todo;
	private IMoney money;
	private String name;
	private String ID;
	
	public void isTodo() {
		todo.todo();
	}
	public void isMoney() {
		money.money();
	}
	public void print() {
		System.out.print("[ID]"+ID+" [이름]"+name);
	}

	public void setTodo(ITodo todo) {
		this.todo = todo;
	}

	public void setMoney(IMoney money) {
		this.money = money;
	}

	public void setName(String name) {
		this.name = name;
	}
	public void setID(String iD) {
		ID = iD;
	}
	
}
