package app;

import java.io.FileReader;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;
import java.util.Set;

public class Ex9 {

	public static void main(String[] args) {
		Map<String, String> map = new HashMap<>();
		
		Properties properties = getAdminInfo();
		String adminId = properties.getProperty("username");
		String adminPw = properties.getProperty("password");;
		map.put(adminId, adminPw);
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("아이디와 비밀번호를 입력해주세요");
			
			System.out.println("ID : ");
			String id = sc.next();
			
			System.out.println("PWD : ");
			String pwd = sc.next();
			
			if(map.containsKey(id)) { //map에 key의 정보로 저장되어 있는지
				
				if(map.get(id).equals(pwd)) {
					System.out.println("로그인 되었습니다.");
					break;
				} else 
					System.out.println("비밀번호를 다시 입력해주세요.");
				
			} else 
				System.out.println("아이디를 다시 입력해주세요.");
		}
		
		/*
		map.put("spring", "1");
		map.put("summer", "2");
		map.put("fall", "3");
		map.put("winter", "4");
		String value = (String)map.get("spring");
		System.out.println(value);
		Set<String> set = map.keySet();
		Iterator<String> iter = set.iterator();
		while(iter.hasNext()) {
			String key = iter.next();
			System.out.println("key :" + key + 
								"\t value : " + map.get(key));
		}
		*/

	}
	
	public static Properties getAdminInfo() {
		Properties properties = null;
		try {
			properties = new Properties();
			String path = Ex9.class.getResource("database.properties").getPath();
			path = URLDecoder.decode(path, "UTF-8");
			properties.load(new FileReader(path));
			
			/*
			String driver = properties.getProperty("driver");
			String url = properties.getProperty("url");
			String username = properties.getProperty("username");
			String password = properties.getProperty("password");
			System.out.println(driver);
			*/
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return properties;
	}

}
