package view;

import java.util.Scanner;

import dto.Member;
import service.BankService;
import service.BankServiceImpl;

public class SubView {
	//���� �޴� �������� ������� �޴� â
	//�� ���, �۱�, ��... 
	
	static Member member;
	private static Scanner sc = new Scanner(System.in);
	public static BankService service = new BankServiceImpl();
	static int amount ;
	
	public static void subMenu() {
		
		System.out.println("-----------------------------");
		System.out.println( member.getId() +"  �� �α��� ���Դϴ�....  ");
		System.out.println("-----------------------------");
		System.out.println("����>");	
		
		//���θ޴� - ȸ������, �α���
		System.out.println("--------------------------------------------------");
		System.out.println("  1. �Ա�  |  2.���  |  3.�ܰ� Ȯ��  |  4.����  ");
		System.out.println("--------------------------------------------------");
		System.out.println("����>");
		
		int menuNum = sc.nextInt();
		Scanner sc = new Scanner(System.in);
		
		switch (menuNum) {
		case 1:
			System.out.println("�Ա� �ݾ��� �Է��ϼ���>");
			amount = sc.nextInt();
			service.deposit(amount);
			
			break;

		case 2:
			System.out.println("��� �ݾ��� �Է��ϼ���>");
			amount = sc.nextInt();
			service.withDraw(amount);
			break;
		
			
		case 3:
			System.out.println("����" + member.getName() +"���� �ܾ��Դϴ�.");
			System.out.println("���¹�ȣ : " + member.getAccount() );
			System.out.println("��" + member.getBalance() + "�� �Դϴ�.");
			break;
			
			
		case 4 :
			break;
		
		}
		
		
	}

}
