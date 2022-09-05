package controller;

import dto.Member;
import service.BankService;
import service.BankServiceImpl;
import view.FailView;
import view.SubView;

public class BankController {
	
	static BankService bankService = new BankServiceImpl();
	
	/**
	 * 로그인
	 * */
	public static void login(String id, String pwd) {
		try {
			Member member = bankService.login(id, pwd);
			//로그인 성공시 subview로 이동
			SubView.subMenu();
			
			
			
		}catch (Exception e) {
			//e.printStackTrace();
			FailView.errorMessage(e.getMessage());
			
		}
	}

}
