package view;

import java.util.Scanner;

import controller.BankController;
import dto.Member;
import exception.BalanceInstufficientException;

public class SubView {
	
	public static Member member;
	private static Scanner sc = new Scanner(System.in);
	public static BankController controller = new BankController();
	static int amount ;
	
	public static void subMenu() {
		
		System.out.println("*******************************");
		System.out.println( member.getId() +"님 현재 로그인 중....  ");
		System.out.println("*******************************");
		
		//입 출금, 잔고 확인 ...
		System.out.println("---------------------------------------------------------------------------");
		System.out.println("  1. 입금  |  2. 출금  |  3. 잔고 확인  |   4. 내 정보 확인   |  5.나가기 ");
		System.out.println("---------------------------------------------------------------------------");
		System.out.println("선택 >");
		
		int menuNum = sc.nextInt();
		Scanner sc = new Scanner(System.in);
		
		switch (menuNum) {
		case 1:
			System.out.println("입금하실 금액을 입력하세요");
			amount = sc.nextInt();
			try {
				int balance = controller.deposit(member.getId(),amount);
				System.out.println("계좌 잔액은 " + balance+ "원 입니다.");
				subMenu();
			} catch (BalanceInstufficientException e) {
				e.printStackTrace();
			}
			
			break;

		case 2:
			System.out.println("출금하실 금액을 입력하세요");
			amount = sc.nextInt();
			try {
				int balance = controller.withdraw(member.getId(),amount);
				System.out.println("계좌 잔액은 " + balance+ "원 입니다.");
				subMenu();
			} catch (BalanceInstufficientException e) {
				e.printStackTrace();
			}
			break;
		
			
		case 3:
			System.out.println(member.getName() +"님의 계좌");
			System.out.println("계좌번호 :" + member.getAccount() );
			System.out.println("총 금액은" + member.getBalance() + "원 입니다.");
			subMenu();
			break;
			
			
		case 4 :
			System.out.println("===============================================");
			System.out.println("* 아이디 : " + member.getId());
			System.out.println("* 이름 : " + member.getName());
			System.out.println("* 계좌번호 : " + member.getAccount());
			System.out.println("* 계좌 개설일 : " + member.getDate());
			System.out.println("* 회원 등급 : " + member.getLevel());
			System.out.println("===============================================");
			break;
			
		case 5 :
			break;
		
		}
		
		
	}

}
