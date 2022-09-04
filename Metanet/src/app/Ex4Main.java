package app;

import java.util.Scanner;

public class Ex4Main {

	public static void main(String[] args) {
		Ex4 ex = new Ex4();
		boolean result = ex.login("abc", "123");
		if(result) {
			System.out.println("로그인 되었습니다.");
			System.out.println("--------------------");
			System.out.println("    1. 로그아웃     ");
			System.out.println("--------------------");
			System.out.println("선택>");
			Scanner scanner = new Scanner(System.in);
			int menu = Integer.parseInt(scanner.nextLine()); //nextLine을 캐스팅
			if(menu == 1) {
				System.out.println("아이디를 한번 더 입력하세요");
				String userId = scanner.nextLine();
				//입력받은 아이디와 로그인 중인 아이디 비교
				if(userId.equals(ex.member.getUserId())) {
					ex.logout(userId);			
				}
			}
			
		}else {
			System.out.println("id 또는 password가 올바르지 않습니다");
		}		

	}

}
