package ex0916;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ex0915.Ex30;

/**
 * 제약 조건 (constraint)
 * 
 * 제약 조건 (constraint)이란 데이터의 무결성을 지키기 위해,
 * 데이터를 입력받을때 실행되는 검사 규칙을 의미합니다.
 * 이러한 제약 조건은 CREATE문으로 테이블을 생성할때나 alter문으로 필드를 추가할 때도 설정할 수도 있습니다.
 * - MYSQL에서 사용할 수 있는 제약 조건은 다음과 같습니다.
 * 1. NOT NULL
 * 2. UNIQUE
 * 3. PRIMARY KEY
 * 4. FOREIGN KEY
 * 5. DEFAULT
 * 
 * - NOT NULL
 * NOT NULL 제약 조건을 설정하면, 해당 필드는 NULL값을 저장할 수 없습니다.
 * 즉, 이 제약 조건이 설정된 필드는 무조건 데이터를 가지고 있어야 합니다.
 * NOT NULL 제약 조건은 CREATE 문으로 테이블을 생성할 때나,
 * 나중에 ALTER문으로 추가할 수도 있습니다.
 * 
 * ex1) [테이블 생성]
 * CREATE TABLE TEST1 (
 * 		ID VARCHAR(10) NOT NULL,
 * 		PW VARCHAR(30),
 * 		NAME VARCHAR(30),
 * 		MDate DATE,
 * 		AGE INT
 * );
 * 
 * 
 * ex2) [테이블 생성]
 * CREATE TABLE TEST2 (
 * 		ID VARCHAR(10) UNIQUE,
 * 		PW VARCHAR(30),
 * 		NAME VARCHAR(30),
 * 		MDate DATE,
 * 		AGE INT
 * );
 * 
 * ex3) 
 * [테이블 생성]
 * CREATE TABLE TEST3 (
 * 		ID VARCHAR(10) PRIMARY KEY,
 * 		PW VARCHAR(30),
 * 		NAME VARCHAR(30),
 * 		MDate DATE,
 * 		AGE INT
 * ); 
 * 
 * 	표현)
 * 		String sql = "INSERT INTO TEST3(PW) VALUES('123')"; // 1.NOT NULL
 * 		String sql = "INSERT INTO TEST3(ID, PW) VALUES('ABC','123')"; // 1.NOT NULL
 * 		String sql = "INSERT INTO TEST3 VALUES('ABC','123','홍길동','2021')"; // 1.NOT NULL
 * 
 * ALTER문
 * - 테이블 변경
 * [테이블 생성] : ATTEST
 * 			CREATE TABLE ATTEST(ID VARCHAR(10) NOT NULL, PW VARCHAR(10));
 * 	실습1) 테이블에 새로운 컬럼 추가
 * 	실습2) 테이블의 컬럼 타입 수정
 * 	실습3) 테이블의 컬럼 이름 변경
 * 	실습4) 테이블 컬럼 삭제
 * 	연습문제) MEMBER 테이블에 PRIMARY KEY 추가
 * 
 * 	ex4)
 * 		create table test4( -- parent
 * 			code int primary key,
 * 			item varchar(30),
 * 			rdate date
 * 		);
 * 
 * 		create table test5( -- child
 * 			num int primary key auto_increment,
 * 			code int,
 * 			primary key (code)
 * 			references test5(code) on update cascade
 * 		);
 * 		테이블 삭제
 * 		drop table test5;
 * 		drop table test4;
 * 
 * 	실행1) "INSERT INTO TEST4" +"(CODE,ITEM,RDATE) VALUES(1,'아이템1','2020-01-01')"; //INSERT
 * 	실행2) "INSERT INTO TEST4" +"(CODE,ITEM,RDATE) VALUES(2,'아이템2','2020-01-01')"; //INSERT
 * 	실행3) "INSERT INTO TEST5" +"(CODE) VALUES(1)"; //INSERT
 * 	실행4) "INSERT INTO TEST5" +"(CODE) VALUES(2)"; //INSERT
 * 
 * 
 * */

public class Ex34 {
	public static void main(String[] args) {
		Connection con = Ex30.getInstance().getConnection();
		PreparedStatement pst = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			pst = con.prepareStatement(alter());
			int result = pst.executeUpdate();
			String msg = result > -1 ? "성공" : "실패";
			System.out.println(msg);
			
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pst != null) pst.close();
				if(con != null) con.close();
			} catch (SQLException e) {}
		}
		
	} 
 	
	public static String alter() {
//		ex1)
		String sql = "ALTER TABLE ATTEST" +
					" ADD COLUMN AGE VARCHAR(10) NOT NULL";
//		
//		ex2) age int 변경, 
//		String sql = "alter table attest modify column age int";
		
//		ex3) pw를 password로 변경 varchar(30) not null로 변경
//		String sql = "alter table attest "
//				+ "change column pw password varchar(30) not null";
		
//		ex4) age 삭제
//		String sql = "alter table attest drop column age";
		
		return sql;
	}
	
	
	

}
