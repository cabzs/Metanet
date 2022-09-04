package app;

import java.util.Scanner;

public class BankApp implements Bank{
	
	static int balance = 5000;
	static int amount ;

	public static void main(String[] args) {
			
		BankApp app = new BankApp(); //�ν��Ͻ� ����
		boolean run = true;
		Scanner scanner = new Scanner(System.in);
		
		do {
		
		System.out.println("-----------------------------");
		System.out.println("  1. ȸ������ |   2.�α���  ");
		System.out.println("-----------------------------");
		System.out.println("����>");	
			

		System.out.println("---------------------------------------------");
		System.out.println(" 1.����  |  2.���  |  3.�ܰ�  |   4.����  ");
		System.out.println("---------------------------------------------");
		System.out.println("����>");
		
		int menuNum = scanner.nextInt();
		
		
		switch (menuNum) {
		case 1:
			System.out.println("�Ա� �ݾ��� �Է��ϼ���>");
			amount = scanner.nextInt();
			app.deposit(amount);
			
			break;

		case 2:
			System.out.println("��ݾ�>");
			amount = scanner.nextInt();
			app.withDraw(amount);
			
			break;
			
		case 3:
			System.out.println("�ܰ�>");
			
			System.out.println("���� ���� �ܾ��� (" + balance + ") �� �Դϴ�.");
			break;
			
		case 4:
			run = false;
			break;
	
		default:
			System.out.println("Wrong answer");
		}
		
		System.out.println();
		
		} while (run);
		
		System.out.println("���α׷� ����");
	
	}


	@Override
	public int deposit(int amount) {
		if(amount<0) {
			System.out.println("�Աݾ��� 0�� �̻��� ���� �Է����ּ���!!!");
		} else {
			this.balance += amount;
			System.out.println("�Աݾ��� (" + amount + ") �� �Դϴ�.");
			System.out.println("���� ���� �ܾ��� (" + balance + ") �� �Դϴ�.");
		}
		
		return balance;
	}

	@Override
	public int withDraw(int amount) {
		//��ݾ� �Է¹޾Ƽ� �ܰ��� ���ش�
		if(amount>balance) {
			System.out.println("��ݾ��� ���� �ܾ׺��� Ů�ϴ� ^^;");
			
		} else {
			this.balance -= amount;
			System.out.println("��ݾ��� (" + amount + ") �� �Դϴ�.");
			System.out.println("���� ���� �ܾ��� (" + balance + ") �� �Դϴ�.");
		}
		
		return balance;
	}
	
	
}//Ŭ������
