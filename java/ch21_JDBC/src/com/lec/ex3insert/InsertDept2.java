package com.lec.ex3insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertDept2 {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Scanner sc = new Scanner(System.in);
		System.out.println("���ϴ� �μ���ȣ: ");
		int deptno = sc.nextInt();
		Connection conn = null; 
		Statement stmt = null; 
		ResultSet rs = null;
		String selectsql = "SELECT * FROM DEPT WHERE DEPTNO="+deptno;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(selectsql);
			if(rs.next()) {
				System.out.println("�ߺ��� �μ� ��ȣ");
			}else{
				System.out.println("���ϴ� �μ���: ");
				String dname = sc.next();
				System.out.println("���ϴ� �μ���ġ: ");
				sc.nextLine();// buffer clear 
				String loc = sc.next();
				String insertsql = String.format("INSERT INTO DEPT VALUES (%d, '%s', '%s')", deptno, dname, loc);
				int result = stmt.executeUpdate(insertsql);//update
				System.out.println(result>0? "success":"fail");
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
