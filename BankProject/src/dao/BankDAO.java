package dao;

import dto.Member;

public interface BankDAO {
	
	/**
	 * 회원가입
	 * */
	public void insert(Member member);
	
	/**
	 * 로그인
	 * */
	public void login(String id, String pwd);
}
