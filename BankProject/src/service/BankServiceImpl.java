package service;

import dao.BankDAO;
import dao.BankDAOImpl;
import dto.Member;

public class BankServiceImpl implements BankService {
	
	BankDAO dao = new BankDAOImpl();


	@Override
	public void insert(Member member) {
		

	}

	@Override
	public void idCheck(String id) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void deposit(int amount) {
		
		
	}

	@Override
	public void withDraw(int amount) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Member login(String id, String pwd) {
		// TODO Auto-generated method stub
		return null;
	}

}
