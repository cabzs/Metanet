package ex0915;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Ex28 {
	
	Connection con;
	
	public Ex28() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/app", "root", "1234");
		}catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	public void createTable() {
		Statement stmt = null;
		try {
			stmt = con.createStatement();
			int result = stmt.executeUpdate("create table DBTEST(ID varchar(50) , PW varchar(50))");
			
			if(result<0) {
				System.out.println("실행 실패");
			} else {
				System.out.println("실행 성공");
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
			
		} finally {
			
			try {
				if(stmt != null) stmt.close();
				if(con != null) con.close();
			}catch (SQLException e) {}
		
		}
	}
	
	public static void main(String[] args) {
		new Ex28().createTable();
	}

}
