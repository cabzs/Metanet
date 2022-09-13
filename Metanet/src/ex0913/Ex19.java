package ex0913;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import app.Ex2;

public class Ex19 {
	//IO를 이용해서 영속적인 기능 추가할 수 있게, 파일을 통해 회원정보 저장, 파일로 읽어오기
	List<Ex2> members;
	
	public Ex19() {
		members = new ArrayList<>();
		Ex2 member = new Ex2("b", "123" ,"홍길동"); //생성자를 이용한 회원가입 
//		members.add(member);
		fileInput(member); //가입하면 바로 파일에 기록
		fileOutput();
		members.add(member);
		for(Ex2 m : members) {
			System.out.println(m.getUserName());
		}
		
	}
	
	public void fileInput(Ex2 member) { //파일 입력
		try {
		PrintWriter pw = 
				new PrintWriter(new FileWriter(new File("members.txt") , true)); //true - 덮어쓰기 가능, 파일은 워크스페이스 폴더내에 저장
		
		StringBuilder sb = new StringBuilder(); //하나의 builder내에서 처리가능
		sb.append(member.getUserName());
		sb.append("#");
		sb.append(member.getUserId());
		sb.append("#");
		sb.append(member.getUserPwd());
		pw.println(sb.toString());
		pw.close();
		
//		pw.println( member.getUserName() + "#" + member.getUserId() + "#" + member.getUserPwd() );
//		pw.close(); //꼭 닫줘야함
		} catch (IOException e){
			e.printStackTrace();
		}
	}
	
	public void fileOutput() {
		try {
			BufferedReader br = //BufferedReader는 문자열 단위로 읽어올 수 있다.
					new BufferedReader(
					new FileReader(new File("members.txt")));
			while(br.ready()) { //입력스트림이 사용할 준비가 되어있는지 확인한다
				StringTokenizer st = new StringTokenizer(br.readLine(), "#"); //디폴트값은 스페이스 기준으로 잘라냄
//				while(st.hasMoreTokens()) {
//					String obj = st.nextToken();
					Ex2 member = new Ex2(st.nextToken(), st.nextToken(), st.nextToken());
					members.add(member); //읽어온 데이터를 담아준다
//				}
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		new Ex19();

	}

}
