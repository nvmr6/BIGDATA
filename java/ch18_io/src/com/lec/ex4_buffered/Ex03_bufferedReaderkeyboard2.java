package com.lec.ex4_buffered;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Writer;

//출력할 파일 이름
//내용 입력
public class Ex03_bufferedReaderkeyboard2 {
	public static void main(String[] args) {
		BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
		Writer writer = null;
		System.out.println("출력할 파일 이름은 ");
		try {
			String fileName = keyboard.readLine();
			writer = new FileWriter(fileName, true);
			while (true) {
				System.out.println("출력할 파일 내용 (종료 x)");
				String content = keyboard.readLine();
				if (content.equalsIgnoreCase("x"))
					break;
				writer.write(content + "\r\n");
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (writer != null)
					writer.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
