package ex0914;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.Vector;

public class Ex20 { //서버
	private Vector handlers; //Vector는 동기화 되어있음
	public Ex20(int port) {
		try {
			ServerSocket server = new ServerSocket(port);
			handlers = new Vector();
			System.out.println("ChatServer is ready");
			while(true) {
				Ex21 handler = new Ex21(this, server.accept());
				handler.start(); //Ex21를 스레드 객체로 만들어준다, request, response처럼 스레드로 요청,응답
				//server.accept(); //데몬스레드의 역할... 프로그램 종료전까지 영원히
			}
		} catch (Exception e) {}
	}

	public Object getHandler(int index) {
		return handlers.elementAt(index);
	}
	
	public void register(Ex21 c) {
		handlers.addElement(c); //저장
	}
	
	public void unregister(Object o) {
		handlers.removeElement(o); //삭제
	}
	
	public void broadcast(String message) {
		synchronized(handlers) {
		int n = handlers.size();
			for(int i =0; i<n ; i++) {
				Ex21 h = (Ex21)handlers.elementAt(i); //제네릭 선언을 안해줬기때문에 (Ex21)로 캐스팅
				try {
					h.println(message);
				} catch(Exception e) {}
			}
		}
	}
	public static void main(String[] args) {
		new Ex20(7979);

	}

}
