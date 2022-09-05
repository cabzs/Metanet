package view;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import controller.BankController;
import dao.BankDAOImpl;
import service.Account;

public class MenuView {
	
	private static Scanner sc = new Scanner(System.in);
	private static BankDAOImpl dao = new BankDAOImpl();
	private static BankController controller = new BankController();
	private static Account account = new Account();
	
	public void mainMenu(){
		
		LocalDate now = LocalDate.now();
		System.out.println("----------     JAVA ����     ------------");
		System.out.println("         ���� ��¥ : "  +  now    );
		System.out.println("------------------------------------------");
		
		//List<String> idList = new ArrayList<String>(); //���̵� ����
		ArrayList idList = new ArrayList(); //���̵� ����
		ArrayList nameList = new ArrayList(); //�̸� ����
		ArrayList accountList = new ArrayList(); //���¹�ȣ �������� �� ����
		
		boolean flag = true;
		while(flag) {
		//���θ޴� - ȸ������, �α���
		System.out.println("-----------------------------------------------");
		System.out.println("  1. ȸ������ |   2.�α���  | 3. �� ���� Ȯ�� ");
		System.out.println("-----------------------------------------------");
		System.out.println("����>");	
		
		Scanner sc = new Scanner(System.in);
		int menuNum = sc.nextInt();
		String id,name;
		

		switch (menuNum) {
		case 1:
				System.out.println("ȸ�������� ���� �ʿ��� ������ �Է��ϼ���.");
				
				System.out.print("���̵� : ");
				id = sc.next();
				
				if(idList.indexOf(id)== -1) {
					//indexOf�� ��ü�� ���ٸ� -1, ������ �� ��ġ�� ��ȯ
					//�Է��� ���̵� �ߺ��̾ƴ϶�� -1 ����
					idList.add(id); //���̵� �߰�
					
					System.out.print("�̸� : ");
					name = sc.next();
					nameList.add(name); //�̸� �߰�
					
					System.out.print("��й�ȣ : ");
					String pwd = sc.next();
					
					System.out.print("��й�ȣ Ȯ�� : ");
					String pwd2 = sc.next();
					
					
					if(pwd.equals(pwd2)) { //��й�ȣ ��ġ�Ѵٸ� ȸ�� ����
						//Member member = new Member(id, pwd, name, null, 0, 0);
						//dao.insert(member);
						
						//��й�ȣ������ ��ġ�Ѵٸ� ���¹�ȣ ���� ���� �� ����Ʈ�� �߰�
						String ac = account.random();
						accountList.add(ac); 
						
						System.out.println();
						System.out.println("*ȸ�������� �Ϸ�Ǿ����ϴ� :)");
						//flag = false;
						break;
						
					} else {
						System.out.println("��й�ȣ�� Ʋ�Ƚ��ϴ�.");
						//flag = false;
						break;
					}
				}
				
				
		case 2:
			System.out.println("�α����� ���� �ʿ��� ������ �Է��ϼ���.");
			
			System.out.print("���̵� : ");
			String userId = sc.next();
			
			System.out.print("��й�ȣ : ");
			String userPwd = sc.next();
			
			//���̵�, ��й�ȣ�� ����� ����� ������ ��ġ�Ѵٸ� ���� �޴��� ����. (�α���)
			controller.login(userId, userPwd);
		
		case 3:
			
//			System.out.println("���̵� ���");
//			for(int i=0; i< idList.size(); i++) {
//				System.out.println(idList.get(i).toString());
//			}
//			
//			System.out.println("�̸� ���");
//			for(int i=0; i< nameList.size(); i++) {
//				System.out.println(nameList.get(i).toString());
//			}
//			
//			System.out.println("���¹�ȣ ���");
//			for(int i=0; i< accountList.size(); i++) {
//				System.out.println(accountList.get(i).toString());
//			}
			
			System.out.println("������ Ȯ���ϰ� ���� ���̵� �Է��ϼ���.");
			for(int i=0; i<idList.size(); i++) {
                System.out.println("���̵� : " + idList.get(i));
            }
			
			id = sc.next(); //���̵� �Է¹���
			
			if(idList.indexOf(id)== -1) { //�Է��� ���̵� ���ٸ� -1 ����
				System.out.println("�ش� ���̵� �������� �ʽ��ϴ�.");
				
			} else if (idList.indexOf(id)!= -1) { //�ش� ���̵� �����Ѵٸ�, id�� ã�� ��ġ������ ���� �ҷ���
				System.out.println("===============================================");
				System.out.println("* ���̵�: " + idList.get(idList.indexOf(id)));
				System.out.println("* �̸�: " + nameList.get(idList.indexOf(id)));
				System.out.println("* ���¹�ȣ: " + accountList.get(idList.indexOf(id)));
				System.out.println("===============================================");
				
			}
			
			}//switch		
		}//while
	}//mainMenu
}//class
