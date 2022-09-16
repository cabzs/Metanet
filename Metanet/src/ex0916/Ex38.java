package ex0916;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import ex0915.Ex30;

public class Ex38 {

	public static void main(String[] args) {
		Connection con = Ex30.getInstance().getConnection();
		Statement st = null;
		ResultSet rs = null;
		
		try {
			st = con.createStatement();
			
//			String sql = insert();
//			int result = st.executeUpdate(sql);
//			String msg = result > -1 ? "성공" : "실패";
//			System.out.println(msg);
			
			String sql = orderBy();
			rs = st.executeQuery(sql);
			ResultSetMetaData rsmd = rs.getMetaData();
			int cols = rsmd.getColumnCount();
			for(int i =1 ; i<= cols; i++) {
				String columnName = rsmd.getColumnClassName(i);
				System.out.println(columnName + "\t");
			}
			System.out.println("------------------------------------");
			while(rs.next()) {
				for(int i =1 ; i<= cols; i++) {
					System.out.println(rs.getString(i) + "\t");
				}
				System.out.println();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(st != null) st.close();
				if(con != null) con.close();
			} catch (SQLException e) {}
		}

	}

}
