package com.lec.ex1_InputStreamOutputStream;

import java.io.*;

public class Ex03_outputStream {
	public static void main(String[] args) {
		OutputStream os = null;
		try {
			os = new FileOutputStream("txtfile/out.txt"); //1. 파일 열기
			byte[] bs = {'H', 'E', 'l', 'l', 'o'};
			for(int i=0;i<bs.length;i++) {
				os.write(bs[i]);//2. 파일에 데이터 쓰기
			}
			System.out.println("complete");
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(os!=null) os.close(); //3. 파일 닫기
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
