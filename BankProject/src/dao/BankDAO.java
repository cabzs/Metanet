package dao;

import dto.Member;

public interface BankDAO {
	
	/**
	 * ȸ������
	 * */
	public void insert(Member member);
	
	/**
	 * �α���
	 * */
	public void login(String id, String pwd);
}
