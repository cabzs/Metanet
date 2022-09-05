package service;

import dto.Member;

public interface BankService {
	/**
	 * 아이디 중복 체크
	 * */
	public void idCheck(String id);
	
	
	/**
	 * 회원가입
	 * */
	public void insert(Member member);

	
	/**
	 * 로그인
	 * @return 
	 * */
	public Member login(String id, String pwd);
	
	
	/**
	 * 입금
	 * */
	public void deposit(int amount);

	
	/**
	 * 출금
	 * */
	public void withDraw(int amount);
	
	
	
}
