package ex0915;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Ex29 {
	
	Connection con;
	
	public Ex29() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/app", "root", "1234");
		}catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void insert() {
		PreparedStatement pstmt = null;
		try {
			Scanner sc = new Scanner(System.in);
			System.out.print("ID :");
			String id = sc.next();
			System.out.print("PWD :");
			String pwd = sc.next();
			
//			pstmt = con.prepareStatement("insert into dbtest values('" + id +  "', '" + pwd + " ') ");
			pstmt = con.prepareStatement("insert into dbtest values(?,?)");
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			
			
			int result = pstmt.executeUpdate();
			String msg = result > -1 ? "성공" : "실패";
			System.out.println(msg);
			
		}catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch (SQLException e) {}
		
		}
		
	}
	
	public static void main(String[] args) {
		new Ex29().insert();

	}

}
