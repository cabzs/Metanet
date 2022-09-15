package ex0915;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Ex31 {
	
	public String updateSql() {
		Scanner sc = new Scanner(System.in);
		System.out.print("ID :");
		String id = sc.next();
		System.out.print("PWD :");
		String pwd = sc.next();
		String sql = "UPDATE DBTEST SET PW = '" + pwd + "' WHERE ID = '" + id + "'"; 
		return sql;
	}
	
	public void update(String sql) {
		Statement stmt = null;
		Connection con = Ex30.getInstance().getConnection();
		try {
			stmt = con.createStatement();
			int result = stmt.executeUpdate(sql);
			String msg = result > -1 ? "성공" : "실패";
			System.out.println(msg);
		}catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(stmt != null) stmt.close();
				if(con != null) con.close();
			}catch(SQLException e) {}
		}
		
	}

	public static void main(String[] args) {
		Ex31 ex31 = new Ex31();
		ex31.update(ex31.updateSql());

	}

}
