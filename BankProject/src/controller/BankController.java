package controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import dto.Member;
import service.BankService;
import service.BankServiceImpl;
import view.FailView;
import view.SubView;

public class BankController {
	
	private static Scanner sc = new Scanner(System.in);
	static BankService service = new BankServiceImpl();
	
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

}
