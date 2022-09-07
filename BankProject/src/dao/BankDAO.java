package dao;

import dto.Member;

public interface BankDAO {
	
	/**
	 * 아이디 중복체크
	 * */
	public boolean idCheck(String id);

	
	/**
	 * 회원가입
	 * */
	public boolean insert(Member member);
	
	
	/**
	 * 로그인
	 * */
	public void login(String id, String pwd);
}
