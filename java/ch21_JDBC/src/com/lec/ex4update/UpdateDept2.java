package com.lec.ex4update;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateDept2 {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Scanner sc = new Scanner(System.in);
		System.out.println("수정할 부서번호: ");
		String deptno = sc.next();//String으로 입력
		String selectquery = "SELECT * FROM DEPT WHERE DEPTNO="+deptno;
		Connection conn = null; 
		Statement stmt = null; 
		ResultSet rs = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(selectquery);
			if(rs.next()) {
				System.out.println("수정할 부서명: ");
				String dname = sc.next();
				System.out.println("수정할 부서위치: ");
				String loc = sc.next();
				String query =String.format("UPDATE DEPT SET DNAME = '%s', LOC = '%s' WHERE DEPTNO = %s", dname, loc, deptno);
				int result = stmt.executeUpdate(query);
				System.out.println(result>0? deptno+"번 부서 수정":"해당 부서 존재하지 않음");
			}else {
				System.out.println("유효하지 않은 부서 번호");
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
	}
	sc.close();
	}
}
