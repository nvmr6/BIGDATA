package com.lec.ex4_buffered;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

//키보드로부터 파일이름 받아 출력
public class Ex02_bufferedReaderkeyboard {
	public static void main(String[] args) {
		BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in)); // 스트링으로 받아옴
		Reader reader = null;
		BufferedReader br = null;
		System.out.println("파일 이름: ");
		try {// txtfile/out.txt
			String fileName = keyboard.readLine();// 키보드로 입력 받는다
			File file = new File(fileName);// 입력한 파일이름의 파일객체
			if (file.exists()) {
				reader = new FileReader(file);
				br = new BufferedReader(reader);
				while (true) {
					String line = br.readLine();
					if (line == null)
						break;
					System.out.println(line);
				}
			} else {
				System.out.println("입력하신 파일은 존재하지 않습니다.");
			}

		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (br != null)
					br.close();
				if (reader != null)
					reader.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
