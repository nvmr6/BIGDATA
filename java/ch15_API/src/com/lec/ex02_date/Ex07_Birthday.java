package com.lec.ex02_date;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.lec.ex01_string.Friend;

public class Ex07_Birthday {
	public static void main(String[] args) {
		Friend[] friends = {new Friend("홍길동", "010-8673-6876", "12-14"),
						    new Friend("이길동", "010-8673-6874", "12-15"),
						    new Friend("최길동", "010-8673-6878", "12-16")};
		//오늘 생일인 사람
		int idx;
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd"); //sdf 생성
		String today = sdf.format(cal.getTime()); //오늘 날짜
		boolean search = false;
		for(idx=0;idx<friends.length;idx++) {
			String temp = friends[idx].getBirth();
			if(temp.equals(today)) {
				System.out.println(friends[idx].getName()+"님은 오늘 생일입니다.");
				search = true;
				break;
			}
		}
		if(!search) {
			System.out.println("오늘 생일인 친구는 없습니다.");
		}
	}
}
