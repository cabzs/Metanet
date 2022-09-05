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
		System.out.println("----------     JAVA 은행     ------------");
		System.out.println("         현재 날짜 : "  +  now    );
		System.out.println("------------------------------------------");
		
		//List<String> idList = new ArrayList<String>(); //아이디 저장
		ArrayList idList = new ArrayList(); //아이디 저장
		ArrayList nameList = new ArrayList(); //이름 저장
		ArrayList accountList = new ArrayList(); //계좌번호 랜덤생성 후 저장
		
		boolean flag = true;
		while(flag) {
		//메인메뉴 - 회원가입, 로그인
		System.out.println("-----------------------------------------------");
		System.out.println("  1. 회원가입 |   2.로그인  | 3. 내 정보 확인 ");
		System.out.println("-----------------------------------------------");
		System.out.println("선택>");	
		
		Scanner sc = new Scanner(System.in);
		int menuNum = sc.nextInt();
		String id,name;
		

		switch (menuNum) {
		case 1:
				System.out.println("회원가입을 위해 필요한 정보를 입력하세요.");
				
				System.out.print("아이디 : ");
				id = sc.next();
				
				if(idList.indexOf(id)== -1) {
					//indexOf는 객체가 없다면 -1, 있으면 그 위치를 반환
					//입력한 아이디가 중복이아니라면 -1 리턴
					idList.add(id); //아이디 추가
					
					System.out.print("이름 : ");
					name = sc.next();
					nameList.add(name); //이름 추가
					
					System.out.print("비밀번호 : ");
					String pwd = sc.next();
					
					System.out.print("비밀번호 확인 : ");
					String pwd2 = sc.next();
					
					
					if(pwd.equals(pwd2)) { //비밀번호 일치한다면 회원 저장
						//Member member = new Member(id, pwd, name, null, 0, 0);
						//dao.insert(member);
						
						//비밀번호까지도 일치한다면 계좌번호 랜덤 생성 후 리스트에 추가
						String ac = account.random();
						accountList.add(ac); 
						
						System.out.println();
						System.out.println("*회원가입이 완료되었습니다 :)");
						//flag = false;
						break;
						
					} else {
						System.out.println("비밀번호가 틀렸습니다.");
						//flag = false;
						break;
					}
				}
				
				
		case 2:
			System.out.println("로그인을 위해 필요한 정보를 입력하세요.");
			
			System.out.print("아이디 : ");
			String userId = sc.next();
			
			System.out.print("비밀번호 : ");
			String userPwd = sc.next();
			
			//아이디, 비밀번호가 저장된 사용자 정보와 일치한다면 다음 메뉴를 띄운다. (로그인)
			controller.login(userId, userPwd);
		
		case 3:
			
//			System.out.println("아이디 목록");
//			for(int i=0; i< idList.size(); i++) {
//				System.out.println(idList.get(i).toString());
//			}
//			
//			System.out.println("이름 목록");
//			for(int i=0; i< nameList.size(); i++) {
//				System.out.println(nameList.get(i).toString());
//			}
//			
//			System.out.println("계좌번호 목록");
//			for(int i=0; i< accountList.size(); i++) {
//				System.out.println(accountList.get(i).toString());
//			}
			
			System.out.println("정보를 확인하고 싶은 아이디를 입력하세요.");
			for(int i=0; i<idList.size(); i++) {
                System.out.println("아이디 : " + idList.get(i));
            }
			
			id = sc.next(); //아이디 입력받음
			
			if(idList.indexOf(id)== -1) { //입력한 아이디가 없다면 -1 리턴
				System.out.println("해당 아이디가 존재하지 않습니다.");
				
			} else if (idList.indexOf(id)!= -1) { //해당 아이디가 존재한다면, id로 찾은 위치값으로 정보 불러옴
				System.out.println("===============================================");
				System.out.println("* 아이디: " + idList.get(idList.indexOf(id)));
				System.out.println("* 이름: " + nameList.get(idList.indexOf(id)));
				System.out.println("* 계좌번호: " + accountList.get(idList.indexOf(id)));
				System.out.println("===============================================");
				
			}
			
			}//switch		
		}//while
	}//mainMenu
}//class
