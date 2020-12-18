package com.lec.ex1_InputStreamOutputStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
//1.스트림 객체(단방향, 두개의 객체) 2. 읽고 쓰기 반복 3. 스트림 닫기  
public class Ex05_fileCopy1 {
	public static void main(String[] args) {
		InputStream is = null;
		OutputStream os = null;
		
		try {
			is = new FileInputStream("txtfile/java.txt");//입력
			os = new FileOutputStream("txtfile/vaja.txt"); //출력
			int cnt = 0;
			while(true){
				++cnt; //읽고쓰기 횟수
				int i = is.read();//1바이트 읽음
				if(i==-1) break;//파일 끝
				os.write(i);
			}
			System.out.println("복사 성공\n"+cnt);
		} catch (FileNotFoundException e) {
			System.out.println("파일 못 찾음"+e.getMessage());
		} catch (IOException e) {
			System.out.println("입력 오류"+e.getMessage());
		}finally {
			try {
				if(is!=null)is.close();//반대 순서로 닫음
				if(os!=null) os.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
