package app;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Ex8 {
	
	Ex2[] member;
	static List<Ex2> list;
	
	public Ex8() {
		member = new Ex2[3];
		member[0] = new Ex2("홍길동1", "a", "1");
		member[1] = new Ex2("홍길동2", "b", "2");
		member[2] = new Ex2("홍길동3", "c", "3");
		list = Arrays.asList(member);
		for(Ex2 m : list) {
			System.out.println(m.getUserId()); //List<Ex2> 제네릭타입으로 타입 명시해주기 때문에
												//별도의 캐스팅없이 사용 가능하다
		}
		
		/*
		list = new LinkedList<>(); //기본 생성자
		list.add(member[0]); //기본 생성자를 사용할경우 추가해준다.
		*/
		
		list = new LinkedList<>(list);
//		Object obj = list.get(0);
//		Ex2 user = (Ex2)obj;
		Iterator<Ex2> iter = list.iterator();
		while(iter.hasNext()) { //hasNext() - 요소가 존재하는만큼 반복한다.
			System.out.println(iter.next().getUserId()); //.next() - 커서를 넘겨준다.
										//마찬가지로 Iterator가 제너릭타입이기때문에 .getUserId()로 꺼내서 사용가능			
		}
		//list.remove(0);
		list.remove(member[1]);
		for(Ex2 m : list) {
			System.out.println(m.getUserId()); //List<Ex2> 제네릭타입으로 타입 명시해주기 때문에
												//별도의 캐스팅없이 사용 가능하다
		}
		
	}
	
	public static void main(String[] args) {
		new Ex8();
		
		

	}

}
