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
		member = new Ex2("abc","123", "홍길동", null, 0); // 회원가입
	//	ex2[0] = member;
	}
	
	public boolean login(String userId, String userPwd) {
		
		boolean result = false;
		
			Scanner scanner = new Scanner(System.in);
			System.out.println("아이디를 입력하세요");
			userId = scanner.nextLine();
			
			System.out.println("비밀번호를 입력하세요");
			userPwd = scanner.nextLine();
			
			if(userId.equals(member.getUserId()) && userPwd.equals(member.getUserPwd())) {
				System.out.print(member.getUserName() + "님 ");
				result = true;
			}
			return result;
		
	}
	
	public void logout(String userId) {
		System.out.println("정상적으로 로그아웃 되었습니다");
		
	}
	
	
}
