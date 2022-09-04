package view;

import java.util.Scanner;

import dao.BankDAOImpl;
import dto.Member;

public class MenuView {
	
	private static Scanner sc = new Scanner(System.in);
	private static BankDAOImpl dao = new BankDAOImpl();
	
	public void mainMenu(){
		//���θ޴� - ȸ������, �α���
		
		System.out.println("-----------------------------");
		System.out.println("  1. ȸ������ |   2.�α���  ");
		System.out.println("-----------------------------");
		System.out.println("����>");	
		
		int menuNum = sc.nextInt();
		
		switch (menuNum) {
		case 1:
				Scanner sc = new Scanner(System.in);
				System.out.println("ȸ�������� ���� �ʿ��� ������ �Է��ϼ���.");
				
				System.out.print("���̵� : ");
				String id = sc.nextLine();
				
				System.out.print("�̸� : ");
				String name = sc.nextLine();
				
				System.out.print("��й�ȣ : ");
				String pwd = sc.nextLine();
				
				System.out.print("��й�ȣ Ȯ�� : ");
				String pwd2 = sc.nextLine();
			
				
				if(pwd == pwd2) { //��й�ȣ ��ġ�Ѵٸ� ȸ�� ����
					Member member = new Member(id, pwd, name, null, 0, 0);
					dao.insert(member);
				} else {
					System.out.println("��й�ȣ�� Ʋ�Ƚ��ϴ�.");
				}
				
				
				
		}//switch		
	}//mainMenu
}//class
