package ex0915;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Ex27 {
	public Ex27() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
//			"oracle.jdbc.driver.OracleDriver" //오라클DB
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/app", "root", "1234");
		}catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new Ex27();
		System.out.println("test");
	}

}
