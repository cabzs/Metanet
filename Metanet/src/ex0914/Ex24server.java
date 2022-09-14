package ex0914;

import java.net.ServerSocket;
import java.util.Vector;

public class Ex24server {
	private Vector handlers;
	
	public Ex24server() {}
	
	public Ex24server(int port) {
		try {
			ServerSocket server = new ServerSocket(port);
			handlers = new Vector();
			System.out.println("chat server is ready");
			while(true) {
				Ex25handler handler = new Ex25handler(this, server.accept());
				handler.start();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public Object getHandler(int index) {
		return handlers.elementAt(index);
	}
	
	public void register(Ex25handler c) {
		handlers.addElement(c);
	}
	
	public void unregister(Object o) {
		handlers.removeElement(o);
	}
	
	public void broadcast(String message) {
		synchronized (handlers) {
			int n = handlers.size();
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < n; i++) {
				Ex25handler h = (Ex25handler)handlers.elementAt(i);
				sb.append("#" + h.getUser());
			}
			for (int i = 0; i < n; i++) {
				Ex25handler h = (Ex25handler)handlers.elementAt(i);			
				try {
					h.println(message + sb.toString());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void main(String[] args) {
		new Ex24server(7900);
	}

}