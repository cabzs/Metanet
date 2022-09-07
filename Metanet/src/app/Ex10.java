package app;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.awt.*;


import javax.swing.JFrame;

public class Ex10 extends JFrame {
	List list;
	Map<Integer, Ex2> map;
	
	public Ex10() {
		super("MapEx");
		map = new HashMap<>();
		memberInfo();
		list = new List();
		Iterator<Integer> keys = map.keySet().iterator();
		while (keys.hasNext()) {
			Integer key = keys.next();
			Ex2 member = map.get(key);
			list.add(member.getUserName());
		}
		
		/*
		for(Ex2 member : map.values()) {
			list.add(member.getUserName());
		}
		*/
		
		add(list);
		setSize(300,300);
		//setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	public void memberInfo() {
		map.put(1, new Ex2("홍길동1", "a1", "1"));
		map.put(2, new Ex2("홍길동2", "a2", "1"));
		map.put(3, new Ex2("홍길동3", "a3", "1"));
		map.put(4, new Ex2("홍길동4", "a4", "1"));
		map.put(5, new Ex2("홍길동5", "a5", "1"));
		
	}
	
	public static void main(String[] args) {
		new Ex10();
	}
 
}
