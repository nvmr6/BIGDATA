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
			// 1�ܰ�: driver load
			Class.forName(driver);
			System.out.println("Driver Load");
			//2�ܰ�: DB connection
			conn = DriverManager.getConnection(url, "root", "mysql");
			System.out.println("DB Connection");
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage()+": ����̹� ����");
		} catch (SQLException e) {
			System.out.println(e.getMessage()+": ��ü ���� ����");
		} finally {
			try {
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
