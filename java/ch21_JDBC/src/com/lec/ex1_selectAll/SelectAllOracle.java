package com.lec.ex1_selectAll;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectAllOracle {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Connection conn = null; //DB연결 객체 변수
		Statement stmt = null; //SQL 전송 객체 변수
		ResultSet rs = null; //SELECT문 결과 받는 객체 변수
		String sql = "SELECT * FROM EMP";
		
		try {
			Class.forName(driver);//1
			System.out.println("Driver Load");
			conn = DriverManager.getConnection(url, "scott", "tiger");//2
			System.out.println("DB Connection");
			stmt = conn.createStatement();//3 SQL 전공 객체 생성
			rs = stmt.executeQuery(sql);//4. SQL전송 > 5. SQL 결과 수신
			//6. SQL 결과 출력 > rs 콘솔 출력
			System.out.println("사번\t이름\t직책\t\t상사사번\t입사일\t\t급여\t상여금\t부서번호");
			while(rs.next()) {
				int empno = rs.getInt("empno");
				String ename = rs.getString("ename");
				String job = rs.getString("job");
				int mgr = rs.getInt("mgr");
				Date hiredate = rs.getDate("hiredate");
//				Timestamp hiredate = rs.getTimestamp("hiredate");
				int sal = rs.getInt("sal");
				int comm = rs.getInt("comm");
				int deptno = rs.getInt("deptno");
				if(job!=null && job.length()<=7) {
				System.out.printf("%d\t%s\t%s\t\t%d\t%TF\t%d\t%d\t%d\n", empno, ename, job, mgr, hiredate, sal, comm, deptno);
				}else {
					System.out.printf("%d\t%s\t%s\t%d\t%TF\t%d\t%d\t%d\n", empno, ename, job, mgr, hiredate, sal, comm, deptno);
				}
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
