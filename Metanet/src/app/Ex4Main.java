package app;

import java.util.Properties;

public class Ex4Main {

	public static void main(String[] args) {
		Ex4 ex = new Ex4();
		//boolean result = ex.login("abc1", "123");
		boolean result = ex.login("a", "1");
		
		if(result) {
			System.out.println("관리자 로그인 되었습니다.");
			new Ex10().setVisible(true);
		}else {
			System.out.println("id 또는 password가 일치하지 않습니다.");
		}		

	}

}
