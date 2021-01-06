package com.lec.ex0;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connMysql {
	public static void main(String[] args) {
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/kimdb?serverTimezone=UTC";
		Connection conn = null;
		try {
			// 1단계: driver load
			Class.forName(driver);
			System.out.println("Driver Load");
			//2단계: DB connection
			conn = DriverManager.getConnection(url, "root", "mysql");
			System.out.println("DB Connection");
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage()+": 드라이버 오류");
		} catch (SQLException e) {
			System.out.println(e.getMessage()+": 객체 생성 실패");
		} finally {
			try {
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
