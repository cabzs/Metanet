package controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import dto.Member;
import exception.BalanceInstufficientException;
import service.BankService;
import service.BankServiceImpl;
import view.FailView;
import view.SubView;

public class BankController {
	
	private static Scanner sc = new Scanner(System.in);
	static BankService service = new BankServiceImpl();
	Member member;
	
	/**
	 * 회원가입
	 * */
	public boolean insert(Member member) {
		//비밀번호 일치할때 회원가입
		boolean result = service.insert(member);
		
		return result;
		
	}
	
	/**
	 * 아이디 중복 체크
	 * */
	public boolean idCheck(String id) {
		boolean result = service.idCheck(id); 
		return result;
	}
	
	
	/**
	 * 로그인
	 * */
	public void login(String id, String pwd) {
		try {
			service.login(id, pwd);
			//로그인 성공시 subMenu로 이동
			SubView.subMenu();
			
			
		}catch (Exception e) {
			e.printStackTrace();
			//FailView.errorMessage(e.getMessage());
			
		}
	}
	
	/**
	 * 회원 조회
	 * */
	public void memberList() {
		
	}
	
	/**
	 * 입금
	 * */
	public int deposit(String id, int amount) throws BalanceInstufficientException {
		if(amount<0) {
			throw new BalanceInstufficientException("입금은 0원 이상부터 가능합니다.");
		} else {
			return service.deposit(id, amount);
		}
	}
	
	/**
	 * 출금
	 * */
	public int withdraw(String id, int amount) throws BalanceInstufficientException {
		if((service.findById(id)).getBalance() <amount) {
			throw new BalanceInstufficientException("출금액이 계좌 잔금보다 큽니다.");
		} else if (amount<0){
			throw new BalanceInstufficientException("출금은 0원 이상부터 가능합니다.");
		}else {
			return service.withdraw(id, amount);
		}
	}
	
	
}
