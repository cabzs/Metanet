package service;

import dto.Member;

public interface BankService {
	/**
	 * ���̵� �ߺ� üũ
	 * */
	public void idCheck(String id);
	
	
	/**
	 * ȸ������
	 * */
	public void insert(Member member);

	
	/**
	 * �α���
	 * @return 
	 * */
	public Member login(String id, String pwd);
	
	
	/**
	 * �Ա�
	 * */
	public void deposit(int amount);

	
	/**
	 * ���
	 * */
	public void withDraw(int amount);
	
	
	
}
