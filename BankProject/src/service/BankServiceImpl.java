package service;

import dao.BankDAO;
import dao.BankDAOImpl;
import dto.Member;

public class BankServiceImpl implements BankService {
	
	BankDAO dao = new BankDAOImpl();

	@Override
	public boolean idCheck(String id) {
		boolean result = dao.idCheck(id);
		return result;
	}

	@Override
	public boolean insert(Member member) {
		//아이디 받고, 비밀번호 
		boolean result = dao.insert(member);
		
		return result;
	}

	@Override
	public void login(String id, String pwd) {
		//입력받은 아이디로 map에 저장된 정보 꺼내서 입력받은 암호 비교하기
		dao.login(id, pwd);
	}
	
	@Override
	public void deposit(int amount) {
		
		
	}

	@Override
	public void withDraw(int amount) {
		// TODO Auto-generated method stub
		
	}


}
