package service;

import java.util.Random;

public class Account {
	
	
	public String random() {
		// 4 - 3 - 6 (0000-000-000000) 계좌번호 랜덤 생성기
		Random random = new Random();
		int account1 = (int)(Math.random() * (9999 - 1000 + 1));
		int account2 = (int)(Math.random() * (999 - 100 + 1));
		int account3 = (int)(Math.random() * (999999 - 100000 + 1));
		
		String newAccount = Integer.toString(account1)+"-"+
						Integer.toString(account2)+"-"+
						Integer.toString(account3);
		
		return newAccount;
	
	}

	
	/*
	public static void main(String[] args) {
		Account account = new Account(); //인스턴스 생성
		account.randomAccount();
	}
	*/
	
}
