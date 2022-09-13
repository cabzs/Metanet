package dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import dto.Member;
import service.Account;
import view.SubView;

public class BankDAOImpl implements BankDAO {

	//List<Member> member = new ArrayList<Member>();
	LocalDate now = LocalDate.now();
	Map<String, Member> map = new HashMap<String, Member>();
	private static Account account = new Account(); //계좌번호 생성
	
	@Override
	public boolean idCheck(String id) {
		boolean result = false;
		if(map.containsKey("id")) {
			//아이디가 존재한다면 false 리턴
			result = false;
		} else {
			result = true;
		}
		return result;
	}
	
	@Override
	public boolean insert(Member member) {
		
		try {
			//회원가입한 사용자 정보를 메모장에 저장하기
			PrintWriter pw = 
					new PrintWriter(new FileWriter(new File("C:/Study/algorithm/BankProject/src/members.txt") , true)); //true - 덮어쓰기 가능, 파일은 워크스페이스 폴더내에 저장
			
			member.setAccount(account.random());
			member.setDate(now);
			map.put(member.getId(), member);
			map.put(member.getPwd(), member);
			map.put(member.getName(), member);
			
			StringBuilder sb = new StringBuilder(); //하나의 builder내에서 처리가능
			sb.append(member.getName());
			sb.append("#");
			sb.append(member.getId());
			sb.append("#");
			sb.append(member.getPwd());
			sb.append("#");
			sb.append(member.getAccount());
			sb.append("#");
			sb.append(member.getDate());
			pw.println(sb.toString());
			pw.close();
			
		} catch(IOException e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public void login(String id, String pwd) {
		//입력받은 아이디로 map에 저장된 정보 꺼내서 입력받은 암호 비교
		if(!map.containsKey(id)) { //get으로 꺼냈을때 뭐가 나오는지 확인, 1)해당 아이디 존재 유무 체크, 2)비밀번호 체크
			System.out.println("해당 아이디가 존재하지 않습니다");
			
		} else if (!pwd.equals((map.get(id)).getPwd())){
			System.out.println("비밀번호를 다시 입력해주세요");
		} else {
			System.out.println("로그인 되었습니다.");
			SubView.member = map.get(id); //subMenu에 가져갈 member 저장!!
		}
	}

	@Override
	public int deposit(String id, int amount) {
		int nowBalance = (map.get(id).getBalance());
		int newBalance = nowBalance += amount;
		map.get(id).setBalance(newBalance);
		//map.put();
		
		return newBalance;
	}

	@Override
	public int withdraw(String id, int amount) {
		int nowBalance = (map.get(id).getBalance());
		int newBalance = nowBalance -= amount;
		map.get(id).setBalance(newBalance);
		
		return newBalance;
	}

	@Override
	public Member findById(String id) {
		Member member = map.get(id);
		return member;
	}


}
