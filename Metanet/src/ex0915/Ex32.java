package ex0915;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Ex32 {
	
	/**
	 * Data DELETE
	 * @return sql
	 * */
	public static String delete() {
		String sql = "DELETE FROM DBTEST WHERE ID = ? ";
		return sql;
	}
	

	public static void main(String[] args) {
		Connection con = Ex30.getInstance().getConnection();
		PreparedStatement pstmt = null;
		
		Scanner sc = new Scanner(System.in);
		System.out.print("ID :");
		String id = sc.next();
		
		try {
			pstmt = con.prepareStatement(delete());
			pstmt.setString(1, id);
			int result = pstmt.executeUpdate();
			String msg = result > -1 ? "성공" : "실패";
			System.out.println(msg);
		} catch (Exception e) {
			System.out.println("데이터 베이스 드라이버 로딩실패!");
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch(Exception e) {}
		}

	}

}
