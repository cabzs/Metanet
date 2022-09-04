package app;

import java.util.Scanner;

public class BankApp implements Bank{
	
	static int balance = 5000;
	static int amount ;

	public static void main(String[] args) {
			
		BankApp app = new BankApp(); //인스턴스 생성
		boolean run = true;
		Scanner scanner = new Scanner(System.in);
		
		do {
		
		System.out.println("-----------------------------");
		System.out.println("  1. 회원가입 |   2.로그인  ");
		System.out.println("-----------------------------");
		System.out.println("선택>");	
			

		System.out.println("---------------------------------------------");
		System.out.println(" 1.예금  |  2.출금  |  3.잔고  |   4.종료  ");
		System.out.println("---------------------------------------------");
		System.out.println("선택>");
		
		int menuNum = scanner.nextInt();
		
		
		switch (menuNum) {
		case 1:
			System.out.println("입금 금액을 입력하세요>");
			amount = scanner.nextInt();
			app.deposit(amount);
			
			break;

		case 2:
			System.out.println("출금액>");
			amount = scanner.nextInt();
			app.withDraw(amount);
			
			break;
			
		case 3:
			System.out.println("잔고>");
			
			System.out.println("현재 계좌 잔액은 (" + balance + ") 원 입니다.");
			break;
			
		case 4:
			run = false;
			break;
	
		default:
			System.out.println("Wrong answer");
		}
		
		System.out.println();
		
		} while (run);
		
		System.out.println("프로그램 종료");
	
	}


	@Override
	public int deposit(int amount) {
		if(amount<0) {
			System.out.println("입금액은 0원 이상의 값을 입력해주세요!!!");
		} else {
			this.balance += amount;
			System.out.println("입금액은 (" + amount + ") 원 입니다.");
			System.out.println("현재 계좌 잔액은 (" + balance + ") 원 입니다.");
		}
		
		return balance;
	}

	@Override
	public int withDraw(int amount) {
		//출금액 입력받아서 잔고에서 빼준다
		if(amount>balance) {
			System.out.println("출금액이 계좌 잔액보다 큽니다 ^^;");
			
		} else {
			this.balance -= amount;
			System.out.println("출금액은 (" + amount + ") 원 입니다.");
			System.out.println("현재 계좌 잔액은 (" + balance + ") 원 입니다.");
		}
		
		return balance;
	}
	
	
}//클래스끝
