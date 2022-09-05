package view;

import java.util.Scanner;

import dto.Member;
import service.BankService;
import service.BankServiceImpl;

public class SubView {
	//메인 메뉴 다음으로 띄워지는 메뉴 창
	//입 출금, 송금, 등... 
	
	static Member member;
	private static Scanner sc = new Scanner(System.in);
	public static BankService service = new BankServiceImpl();
	static int amount ;
	
	public static void subMenu() {
		
		System.out.println("-----------------------------");
		System.out.println( member.getId() +"  님 로그인 중입니다....  ");
		System.out.println("-----------------------------");
		System.out.println("선택>");	
		
		//메인메뉴 - 회원가입, 로그인
		System.out.println("--------------------------------------------------");
		System.out.println("  1. 입금  |  2.출금  |  3.잔고 확인  |  4.종료  ");
		System.out.println("--------------------------------------------------");
		System.out.println("선택>");
		
		int menuNum = sc.nextInt();
		Scanner sc = new Scanner(System.in);
		
		switch (menuNum) {
		case 1:
			System.out.println("입금 금액을 입력하세요>");
			amount = sc.nextInt();
			service.deposit(amount);
			
			break;

		case 2:
			System.out.println("출금 금액을 입력하세요>");
			amount = sc.nextInt();
			service.withDraw(amount);
			break;
		
			
		case 3:
			System.out.println("현재" + member.getName() +"님의 잔액입니다.");
			System.out.println("계좌번호 : " + member.getAccount() );
			System.out.println("총" + member.getBalance() + "원 입니다.");
			break;
			
			
		case 4 :
			break;
		
		}
		
		
	}

}
