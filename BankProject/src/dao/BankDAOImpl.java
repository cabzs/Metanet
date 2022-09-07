package dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dto.Member;
import service.Account;
import view.SubView;

public class BankDAOImpl implements BankDAO {

	//List<Member> member = new ArrayList<Member>();
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
		member.setAccount(account.random());
		map.put(member.getId(), member);
		map.put(member.getPwd(), member);
		map.put(member.getName(), member);
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


}
