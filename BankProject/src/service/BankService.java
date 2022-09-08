package service;

import dto.Member;
import exception.NotfoundException;

public interface BankService {
	
	/**
	 * 아이디 중복 체크
	 * */
	public boolean idCheck(String id);
	
	
	/**
	 * 회원가입
	 * */
	public boolean insert(Member member);

	
	/**
	 * 로그인
	 * @return 
	 * @throws NotfoundException 
	 * */
	public void login(String id, String pwd) throws NotfoundException;
	
	
	/**
	 * 입금
	 * @throws NotfoundException 
	 * */
	public int deposit(String id, int amount);

	
	/**
	 * 출금
	 * @throws NotfoundException 
	 * */
	public int withdraw(String id, int amount);
	
	
	/**
	 * 아이디로 회원 찾기
	 * */
	public Member findById(String id);
	
}
