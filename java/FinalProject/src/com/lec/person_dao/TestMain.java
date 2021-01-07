package com.lec.person_dao;

import java.util.ArrayList;

public class TestMain {
	public static void main(String[] args) {
		personDto dto = new personDto("jim", "���", 23, 56, 78);
		personDao dao = personDao.getInstance();
		int result = dao.insertPerson(dto);
		System.out.println(result == personDao.SUCCESS? "o":"x");

		ArrayList<personDto> dtos = dao.selectJname("���");
		if(dtos.size()==0) {
			System.out.println("����");
		}else {
			for(personDto temp: dtos) {
				System.out.println(temp);
			}
		}
		
		dtos = dao.selectAll(); //return ArrayList
		if(dtos.isEmpty()) {
			System.out.println("����");
		}else{
			for(personDto temp: dtos) {
				System.out.println(temp);
			}
		}
	}
}
