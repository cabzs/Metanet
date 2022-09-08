package view;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import controller.BankController;
import dao.BankDAOImpl;
import dto.Member;
import service.Account;

public class MenuView {
	
	private static Scanner sc = new Scanner(System.in);
	private static BankController controller = new BankController();
	
	public void mainMenu(){
		
		LocalDate now = LocalDate.now();
		System.out.println("----------     JAVA 은행    ------------");
		System.out.println("         현재 날짜 : "  +  now    );
		System.out.println("------------------------------------------");
		
//		List<String> idList = new ArrayList<String>(); //객체에 저장
//		List<String> nameList = new ArrayList<String>(); //이름
//		List<String> accountList = new ArrayList<String>(); //계좌번호
		
		boolean flag = true;
		while(flag) {
		//회원가입, 로그인
		System.out.println("----------------------------");
		System.out.println("  1. 회원가입 |   2.로그인  ");
		System.out.println("----------------------------");
		System.out.println("선택>");	
		
		Scanner sc = new Scanner(System.in);
		int menuNum = sc.nextInt();
		String id,name,pwd,pwd2;
		

		switch (menuNum) {
		case 1:
				System.out.println("가입하실 아이디를 입력해주세요");
				System.out.print("아이디 : ");
				id = sc.next();
				boolean result = controller.idCheck(id);
				if(result) {
					//indexOf는 객체가 없다면 -1 있으면 그 위치를 반환
					//중복이 없다면 -1을 반환한다
					//idList.add(id); //아이디 저장
					System.out.print("이름 : ");
					name = sc.next();
					
					System.out.print("비밀번호 : ");
					pwd = sc.next();
					
					System.out.print("비밀번호 확인 : ");
					pwd2 = sc.next();
					
					if(pwd.equals(pwd2)) { //비밀번호 일치하는지 확인
						Member member = new Member(id, pwd, name, null, null, 0, 0);
						boolean result1 = controller.insert(member);
						
							if(result1) {
								System.out.println();
								System.out.println("회원가입 성공!");
							break;
						}
						
					} else {
						System.out.println("비밀번호가 일치하지 않습니다.");
						break;
					}
				}
				
				
		case 2:
			System.out.println("로그인할 아이디와 비밀번호를 입력해주세요.");
			
			System.out.print("아이디 : ");
			String userId = sc.next();
			
			System.out.print("비밀번호 : ");
			String userPwd = sc.next();
			
			//아이디 비번이 일치하면 로그인
			controller.login(userId, userPwd);
			break;
			
			/*
		case 3:
			System.out.println("로그인 후 이용가능합니다.");
			for(int i=0; i<idList.size(); i++) {
                System.out.println("아이디: " + idList.get(i));
            }
			
			id = sc.next(); //아이디 입력
			
			if(idList.indexOf(id)== -1) { //아이디가 없다면
				System.out.println("존재하지 않는 아이디입니다");
				
			} else if (idList.indexOf(id)!= -1) { //아이디가 존재한다면
				System.out.println("===============================================");
				System.out.println("* 아이디 : " + idList.get(idList.indexOf(id)));
				System.out.println("* 이름 : " + nameList.get(idList.indexOf(id)));
				System.out.println("* 계좌번호 : " + accountList.get(idList.indexOf(id)));
				System.out.println("===============================================");
				
			}*/
			
			}//switch		
		}//while
	}//mainMenu
}//class
