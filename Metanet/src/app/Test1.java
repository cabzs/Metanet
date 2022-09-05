package app;

	import java.util.Scanner;
	import java.util.ArrayList;
	 
	public class Test1 {
	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        // 이름을 저장할 ArrayList name 생성
	        ArrayList name = new ArrayList();
	        // 번호를 저장할 ArrayList num 생성
	        ArrayList num = new ArrayList();
	        // 이름, 번호를 입력받을 변수 선언
	        String na, nu;
	        // 종료했을때 while문을 탈출할 변수 선언
	        boolean bool = true;
	        
	        // 연락처 프로그램 반복실행
	        while(bool) {
	            System.out.println("1.연락처 등록");
	            System.out.println("2.연락처 보기");
	            System.out.println("3.연락처 삭제");
	            System.out.println("4.모든 연락처 보기");
	            System.out.println("5.종료");
	            // 보기를 선택받음
	            int input = sc.nextInt();
	            switch(input) {
	            case 1:
	                System.out.println("등록할 이름을 입력하세요");
	                na = sc.next();
	                // 이름이 등록되어 있지 않다면 연락처 저장
	                // indexOf는 객체가 없다면 -1 있으면 그 위치를 반환
	                // -1이 반환된다는건 중복이 없다는 뜻이다.
	                if(name.indexOf(na) == -1) {
	                    name.add(na);
	                    System.out.println("등록할 번호를 입력하세요");
	                    nu = sc.next();
	                    // 입력받은 번호를 ArrayList num에 추가
	                    num.add(nu);
	                    System.out.println("등록된 이름은 : " + na + " / 번호는 : " + nu + "입니다.");
	                // 이름이 등록되어 있다면 중복된 이름이 있다고 반환
	                } else {
	                    System.out.println("중복된 이름이 있습니다.");
	                }
	                break;
	        
	            case 2:
	                System.out.println("누구의 연락처를 확인하시겠습니까?");
	                // 저장되어 있는 모든 이름을 확인
	                for(int i=0; i<name.size(); i++) {
	                    System.out.println("이름 : " + name.get(i));
	                }
	                na = sc.next();
	                // 확인할 이름의 인덱스 번호 확인
	                // name.indexOf(na);
	                
	                // 저장되어 있는 값이 없으면 -1이 출력
	                if(name.indexOf(na) == -1) {
	                    System.out.println("목록에 없습니다.");
	                } else {
	                    System.out.println(na + "의 번호는 " + num.get(name.indexOf(na)));
	                    
	                }
	                break;
	            
	            case 3:
	                System.out.println("누구의 연락처를 삭제하시겠습니까?");
	                // 저장되어 있는 모든 이름을 String으로 변환하여 출력
	                for(int i=0; i<name.size(); i++) {
	                    na = (String)name.get(i);
	                    System.out.println(na);
	                }
	                System.out.println("삭제할 이름을 입력하세요");
	                na = sc.next();
	                // 입력받은 이름을 ArrayList name에서 삭제
	                System.out.println(name.remove(na));
	                break;
	            
	            case 4:
	                System.out.println("저장되어 있는 연락처는");
	                // 저장되어 있는 연락처의 이름과 번호를 모두 출력
	                for(int i=0; i<name.size(); i++) {
	                    System.out.println("이름 : " + name.get(i) + " / 번호 : " + num.get(i));
	                }
	                // 저장되어 있는 값이 없을때 목록이 없다, 연락처를 추가해라 문구 출력
	                if(name.size()==0) {
	                    System.out.println("목록이 없습니다.");
	                    System.out.println("연락처를 추가해주세요.");
	                }
	                break;
	                
	            case 5:
	                // 종료하면 while문 탈출
	                System.out.println("종료하겠습니다.");
	                bool = false;
	            }
	        }
	    }
	}

