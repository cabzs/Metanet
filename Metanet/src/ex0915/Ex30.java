package ex0915;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Ex30 {
	//싱글톤 패턴
	private static Ex30 instance;
	private Connection con;
	public Ex30() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/app", "root", "1234");
		}catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static Ex30 getInstance() {
		if(instance == null) {
			instance = new Ex30();
		}
		return instance;
	} 
	
	public Connection getConnection() {
		return this.con;
	}

}
