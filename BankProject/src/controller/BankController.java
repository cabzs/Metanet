package controller;

import dto.Member;
import service.BankService;
import service.BankServiceImpl;
import view.FailView;
import view.SubView;

public class BankController {
	
	static BankService bankService = new BankServiceImpl();
	
	/**
	 * �α���
	 * */
	public static void login(String id, String pwd) {
		try {
			Member member = bankService.login(id, pwd);
			//�α��� �����ϸ� subview ����
			SubView.subMenu();
			
			
			
		}catch (Exception e) {
			//e.printStackTrace();
			FailView.errorMessage(e.getMessage());
			
		}
	}

}
