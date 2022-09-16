package ex0916;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import ex0915.Ex30;

/**
 * BETWEEN (범위) : a AND b에서 a와 b를 포함한(inclusive) 
 * 					그 사이의 모든 값에 해당하는지 여부를 조건으로 한다.
 * 
 * [실습 테이블 만들기] : BWTEST
 * 
 * CREATE TABLE BWTEST(
 * 		IDX INT,
 * 		BIRTH DATE.
 * 		NAME VARCHAR(10)
 * );
 * 
 * */


public class Ex39 {

	public static void main(String[] args) {
		Connection con = Ex30.getInstance().getConnection();
		Statement st = null;
		ResultSet rs = null;

	}

}
