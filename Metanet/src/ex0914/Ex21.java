package ex0914;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Panel;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JTextArea;

public class Ex21 extends Thread { //핸들러
	private Socket s;
	private BufferedReader i;
	private PrintWriter o;
	private Ex20 server;
	
	public Ex21(Ex20 server, Socket s) throws Exception {
		this.server = server;
		this.s = s;
		InputStream ins = s.getInputStream();
		OutputStream os = s.getOutputStream();
		InputStreamReader isr = new InputStreamReader(ins);
		OutputStreamWriter osw = new OutputStreamWriter(os);
		o = new PrintWriter(osw, true);
		i = new BufferedReader(isr);
		
	}
	
	public void run() {
		String name = "";
		try {
			name = i.readLine();
			server.register(this);
			broadcast(name+" 님이 입장하셨습니다.");
			while(true) {
				String msg = i.readLine();
				broadcast(name + " - " + msg);
			}
		}catch(Exception e) {}
		server.unregister(this);
		broadcast(name +" 님이 퇴장하셨습니다.");
		
		try{
			i.close();
			o.close();
			s.close();
		}catch(IOException ex) {}
		
	}
	
	protected void println(String message) {
		o.println(message);
	}
	
	protected void broadcast(String message) {
		server.broadcast(message);
	}
	
	
}
