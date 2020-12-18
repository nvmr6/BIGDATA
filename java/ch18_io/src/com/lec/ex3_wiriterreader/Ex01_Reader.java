package com.lec.ex3_wiriterreader;

import java.io.*;

public class Ex01_Reader {
	public static void main(String[] args) {
		Reader reader = null;
		try {
			reader = new FileReader("txtfile/out.txt");
			while(true) {
				int i = reader.read();
				if(i==-1) break;
				System.out.print((char)i);//두 바이트씩
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(reader!=null)
					reader.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
