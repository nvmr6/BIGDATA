package com.lec.ex3_wiriterreader;

import java.io.*;

public class Ex02_writer {
	public static void main(String[] args) {
		Writer writer = null;
		try {
			writer = new FileWriter("txtfile/out.txt");
			String str = "안녕하세요. Danke. Bon jour.";
			char[] st = str.toCharArray();
			writer.write(str);
			System.out.println("complete");
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(writer!=null)
					writer.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
