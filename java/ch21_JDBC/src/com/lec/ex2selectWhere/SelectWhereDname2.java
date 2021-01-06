package com.lec.ex2selectWhere;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SelectWhereDname2 {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Scanner sc = new Scanner(System.in);
		System.out.println("원하는 부서명: ");
		String dname = sc.next();
		Connection conn = null; 
		Statement stmt = null; 
		ResultSet rs = null;
		String sql = "SELECT EMPNO, ENAME, SAL, GRADE FROM EMP E, DEPT D, SALGRADE "+
				"WHERE E.DEPTNO = D.DEPTNO AND SAL BETWEEN LOSAL AND HISAL AND DNAME = '"+dname+"'";
		try {
			Class.forName(driver);
			System.out.println("Driver Load");
			conn = DriverManager.getConnection(url, "scott", "tiger");
			System.out.println("DB Connection");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				do {
					int empno = rs.getInt("empno");
					String ename = rs.getString("ename");
					int sal = rs.getInt("sal");
					int grade = rs.getInt("grade");
					System.out.printf("사번: %d \t 사원명: %s \t 급여: %d \t 등급: %d \n", empno, ename, sal, grade);
				}while(rs.next());
			}else {
				System.out.println("해당 부서가 존재하지 않습니다.");
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
				try {
					if(rs!=null) rs.close();
					if(stmt!=null) stmt.close();
					if(conn!=null) conn.close(); //생성 역순으로 close
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
		}
		sc.close();
	}
}
