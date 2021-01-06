package com.lec.ex2selectWhere;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SelectWhereDeptno2 {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Connection conn = null; 
		Statement stmt = null; 
		ResultSet rs = null;
		Scanner sc = new Scanner(System.in);
		System.out.println("���ϴ� �μ���ȣ: ");
		int deptno = sc.nextInt();
		String sql1 = "SELECT W.EMPNO, W.ENAME, W.SAL, M.ENAME MANAGER FROM EMP W, EMP M WHERE W.MGR = M.EMPNO AND W.DEPTNO ="+deptno;
		String sql2 = "SELECT * FROM DEPT WHERE DEPTNO ="+deptno;
		try {
			Class.forName(driver);
			System.out.println("Driver Load");
			conn = DriverManager.getConnection(url, "scott", "tiger");
			System.out.println("DB Connection");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql2);
			if(rs.next()) {
				String dname = rs.getString("dname");
				String loc = rs.getString("loc");
				System.out.printf("�μ���: %s \t �μ� ��ġ: %s \n", dname, loc);
			rs.close();
			rs = stmt.executeQuery(sql1);
				if(rs.next()) {
					System.out.println("���\t�̸�\t�޿�\t���\t�μ���ȣ");
					do {
						int empno = rs.getInt("empno");
						String ename = rs.getString("ename");
						int sal = rs.getInt("sal");
						String manager = rs.getString("manager");
						System.out.printf("%d\t%s\t%d\t%s\t%d\n", empno, ename, sal, manager, deptno);
					}while(rs.next());
				}else {
					System.out.println("�ش� ����� �������� �ʽ��ϴ�");
				}
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
