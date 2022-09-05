package view;

import java.util.Scanner;

import dto.Member;
import service.BankService;
import service.BankServiceImpl;

public class SubView {
	
	static Member member;
	private static Scanner sc = new Scanner(System.in);
	public static BankService service = new BankServiceImpl();
	static int amount ;
	
	public static void subMenu() {
		
		System.out.println("-----------------------------");
		System.out.println( member.getId() +"님 현재 로그인 중....  ");
		System.out.println("-----------------------------");
		System.out.println("����>");	
		
		//입 출금, 잔고 확인 ...
		System.out.println("--------------------------------------------------");
		System.out.println("  1. 입금  |  2. 출금  |  3. 잔고 확인  |  4.나가기 ");
		System.out.println("--------------------------------------------------");
		System.out.println("선택 >");
		
		int menuNum = sc.nextInt();
		Scanner sc = new Scanner(System.in);
		
		switch (menuNum) {
		case 1:
			System.out.println("입금하실 금액을 입력하세요");
			amount = sc.nextInt();
			service.deposit(amount);
			
			break;

		case 2:
			System.out.println("출금하실 금액을 입력하세요");
			amount = sc.nextInt();
			service.withDraw(amount);
			break;
		
			
		case 3:
			System.out.println(member.getName() +"님의 계좌");
			System.out.println("계좌번호 :" + member.getAccount() );
			System.out.println("총 금액은" + member.getBalance() + "원 입니다.");
			break;
			
			
		case 4 :
			break;
		
		}
		
		
	}

}
