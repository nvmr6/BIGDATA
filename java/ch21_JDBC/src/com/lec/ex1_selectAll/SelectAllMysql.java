package com.lec.ex1_selectAll;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectAllMysql {
	public static void main(String[] args) {
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/kimdb?serverTimezone=UTC";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String query = "SELECT * FROM PERSONAL";
		
		try {
			Class.forName(driver);
			System.out.println("Driver Load");
			conn = DriverManager.getConnection(url, "root", "mysql");
			System.out.println("DB Connection");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			System.out.println("사번\t이름\t직책\t\t상사사번\t입사일\t\t급여\t상여금\t부서번호");
			//데이터의 유무가 확실하지 않은 경우
			if(rs.next()) {//결과 데이터 있음
				do {//do-while 사용하지 않으면 첫 행이 출력되지 않음
					int pno = rs.getInt("pno");
					String pname = rs.getString("pname");
					String job = rs.getString("job");
					int manager = rs.getInt("manager");
					Date startdate = rs.getDate("startdate");
					int pay = rs.getInt("pay");
					int bonus = rs.getInt("bonus");
					int dno = rs.getInt("dno");
					if(job!=null && job.length()<=7) {
						System.out.printf("%d\t%s\t%s\t\t%d\t%TF\t%d\t%d\t%d\n", pno, pname, job, manager, startdate, pay, bonus, dno);
						}else {
							System.out.printf("%d\t%s\t%s\t%d\t%TF\t%d\t%d\t%d\n", pno, pname, job, manager, startdate, pay, bonus, dno);
						}
				}while(rs.next());
			}else {//결과 데이터 없음
				System.out.println("사원 정보가 없습니다.");
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
	}
}
