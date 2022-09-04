package view;

import java.util.Scanner;

import dao.BankDAOImpl;
import dto.Member;

public class MenuView {
	
	private static Scanner sc = new Scanner(System.in);
	private static BankDAOImpl dao = new BankDAOImpl();
	
	public void mainMenu(){
		//메인메뉴 - 회원가입, 로그인
		
		System.out.println("-----------------------------");
		System.out.println("  1. 회원가입 |   2.로그인  ");
		System.out.println("-----------------------------");
		System.out.println("선택>");	
		
		int menuNum = sc.nextInt();
		
		switch (menuNum) {
		case 1:
				Scanner sc = new Scanner(System.in);
				System.out.println("회원가입을 위해 필요한 정보를 입력하세요.");
				
				System.out.print("아이디 : ");
				String id = sc.nextLine();
				
				System.out.print("이름 : ");
				String name = sc.nextLine();
				
				System.out.print("비밀번호 : ");
				String pwd = sc.nextLine();
				
				System.out.print("비밀번호 확인 : ");
				String pwd2 = sc.nextLine();
			
				
				if(pwd == pwd2) { //비밀번호 일치한다면 회원 저장
					Member member = new Member(id, pwd, name, null, 0, 0);
					dao.insert(member);
				} else {
					System.out.println("비밀번호가 틀렸습니다.");
				}
				
				
				
		}//switch		
	}//mainMenu
}//class
