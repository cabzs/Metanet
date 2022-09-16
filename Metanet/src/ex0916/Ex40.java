package ex0916;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import ex0915.Ex30;

public class Ex40 {

/**
 * 그룹화 하여 데이터 조회 (GROUP BY)
 * : 대표적인 그룹함수 COUNT(), AVG(), MIN(), MAX(), SUM() 함수 등과,
 * 		HAVING 절(조건절)을 사용함 (HAVING만 별도로 사용할수는 없음)
 * 
 * [연습 테이블 만들기] : GBTEST
 * 	CREATE TABLE GBTEST(
 * 		IDX int,
 * 		TYPE int.
 * 		NAME VARCHAR(10));
 * 
 * [레코드 추가]
 * INSERT INTO GBTEST VALUES(1,1, '홍길동');
 * INSERT INTO GBTEST VALUES(2,1, '홍길동');
 * INSERT INTO GBTEST VALUES(3,2, '홍길동');
 * INSERT INTO GBTEST VALUES(4,2, '홍길동');
 * INSERT INTO GBTEST VALUES(5,3, '홍길동');
 * INSERT INTO GBTEST VALUES(6,3, '홍길동');
 * INSERT INTO GBTEST VALUES(7,4, '홍길동');
 *                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      
 * */
	public static String select() {
//		String sql = "SELECT count(type) from gbtest";
//		String sql = "select type, count(name) as cnt"
//				+ "from gbtest group by type";
		
//		String sql = "select type, count(name) as cnt"
//				+ "from gbtest where type > 1 group by type";
//		String sql = "select type, count(name) as cnt"
//				+ "from gbtest where type > 1 group by type"
//				+ "having cnt >=2";
		
		String sql = "select type, count(name) as cnt from gbtest"
				+ "where type > 1 group by type having cnt >= 2"
				+ "order by type desc";
		
		return sql;
	}
	
	
	public static void main(String[] args) {
		Connection con = Ex30.getInstance().getConnection();
		Statement st = null;
		ResultSet rs = null;
		ResultSetMetaData rsmd = null;
		String sql = select();
		
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			rsmd = rs.getMetaData();
			int columnCnt = rsmd.getColumnCount();
			for (int i =1; i<=columnCnt; i++) {
				String columnName = rsmd.getColumnName(i);
				System.out.println(columnName + "\t");
			}
			System.out.println("\n-----------------------------------------");
			while(rs.next()) {
				for(int i=1; i<=columnCnt; i++) {
					String columnValue = rs.getString(i);
					System.out.println(columnValue +"\t");
				}
				System.out.println();
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
		}

	}

}
