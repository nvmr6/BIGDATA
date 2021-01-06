package com.lec.ex2selectWhere;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SelectWhereDname {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Scanner sc = new Scanner(System.in);
		System.out.println("���ϴ� �μ���: ");
		String dname = sc.next();
		Connection conn = null; 
		Statement stmt = null; 
		ResultSet rs = null;
		String sql = "SELECT * FROM DEPT WHERE DNAME ='"+dname+"'";
		sql = String.format("SELECT * FROM DEPT WHERE DNAME ='%s'",dname);
		try {
			Class.forName(driver);
			System.out.println("Driver Load");
			conn = DriverManager.getConnection(url, "scott", "tiger");
			System.out.println("DB Connection");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				String deptno = rs.getString("deptno");
				String loc = rs.getString("loc");
				System.out.printf("�μ� ��ȣ: %s \t �μ���: %s \t �μ� ��ġ: %s \n", deptno, dname, loc);
			}else {
				System.out.println("�ش� �μ��� �������� �ʽ��ϴ�.");
			}
			
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
				try {
					if(rs!=null) rs.close();
					if(stmt!=null) stmt.close();
					if(conn!=null) conn.close(); //���� �������� close
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
		}
		sc.close();
	}
}
