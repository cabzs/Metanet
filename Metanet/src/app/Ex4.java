package app;

import java.util.Scanner;

public class Ex4 {
	
	public Ex2 getMember() {
		return member;
	}

	public void setMember(Ex2 member) {
		this.member = member;
	}

	public Ex2 member;
	//Ex02[] ex2 = new Ex02[2];
	public Ex4() {
		member = new Ex2("abc","123", "ȫ�浿", null, 0); // ȸ������
	//	ex2[0] = member;
	}
	
	public boolean login(String userId, String userPwd) {
		
		boolean result = false;
		
			Scanner scanner = new Scanner(System.in);
			System.out.println("���̵� �Է��ϼ���");
			userId = scanner.nextLine();
			
			System.out.println("��й�ȣ�� �Է��ϼ���");
			userPwd = scanner.nextLine();
			
			if(userId.equals(member.getUserId()) && userPwd.equals(member.getUserPwd())) {
				System.out.print(member.getUserName() + "�� ");
				result = true;
			}
			return result;
		
	}
	
	public void logout(String userId) {
		System.out.println("���������� �α׾ƿ� �Ǿ����ϴ�");
		
	}
	
	
}
