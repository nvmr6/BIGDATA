package com.lec.ex4_buffered;

import java.io.*;

public class Ex01_BufferedReader {
	public static void main(String[] args) {
		Reader reader = null;
		BufferedReader br = null;
		try {
			reader = new FileReader("txtfile/out.txt");
			br = new BufferedReader(reader);
			while(true) {
				String line = br.readLine();
				if(line==null)break;
				System.out.println(line);//한 줄씩 읽기
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(br!=null)br.close();
				if(reader!=null)reader.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
