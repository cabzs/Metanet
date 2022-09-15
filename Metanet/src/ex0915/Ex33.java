package ex0915;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Ex33 {
	
	public static void main(String[] args) {
		Connection con = Ex30.getInstance().getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = con.prepareStatement(select());
			rs = pstmt.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			int cols = rsmd.getColumnCount();
			for(int i =1 ; i <= cols; i++) {
				System.out.print(rsmd.getColumnName(i) + "\t");
			}
//			System.out.println("ID"+"\tPW");
			System.out.println();
			
			List<User> data = new ArrayList<>();
			
			while(rs.next()) {
				/*
				for(int i =1 ; i <= cols; i++) {
				System.out.print(rs.getString(i) + "\t");
				}
				System.out.println(); //개행
				*/
				User user = new User().setId(rs.getString(1)).setPw(rs.getString(2));
				data.add(user);
				
			}
			Iterator<User> iterator = data.iterator();
			while(iterator.hasNext()) {
				User userinfo = iterator.next();
				System.out.println(
							userinfo.getId() + "\t" +
							userinfo.getPw()
						);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				//열어주는 역순으로 닫아준다
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch(Exception e) {}
		}

	}
	/**
	 * select
	 * @return SQL
	 * */
	public static String select(){
//		String sql = "SELECT ID, PW FROM DBTEST";
//		String sql = "SELECT ID, PW FROM DBTEST WHERE ID ='USER1'";
		String sql = "SELECT * FROM DBTEST";
		return sql;
		
	}
}

class User {
	private String id;
	private String pw;
	public String getId() {
		return id;
	}
	public String getPw() {
		return pw;
	}
	
	public User setId(String id) {
		this.id = id;
		return this;
	}
	public User setPw(String pw) {
		this.pw = pw;
		return this;
	}
	
}