package app;

import java.util.Scanner;

public class Ex4Main {

	public static void main(String[] args) {
		Ex4 ex = new Ex4();
		boolean result = ex.login("abc", "123");
		if(result) {
			System.out.println("�α��� �Ǿ����ϴ�.");
			System.out.println("--------------------");
			System.out.println("    1. �α׾ƿ�     ");
			System.out.println("--------------------");
			System.out.println("����>");
			Scanner scanner = new Scanner(System.in);
			int menu = Integer.parseInt(scanner.nextLine()); //nextLine�� ĳ����
			if(menu == 1) {
				System.out.println("���̵� �ѹ� �� �Է��ϼ���");
				String userId = scanner.nextLine();
				//�Է¹��� ���̵�� �α��� ���� ���̵� ��
				if(userId.equals(ex.member.getUserId())) {
					ex.logout(userId);			
				}
			}
			
		}else {
			System.out.println("id �Ǵ� password�� �ùٸ��� �ʽ��ϴ�");
		}		

	}

}
