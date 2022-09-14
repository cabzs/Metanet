package ex0914;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class Ex25handler extends Thread {
	private Socket socket;
	private BufferedReader bufferedReader;
	private PrintWriter printWriter;
	private Ex24server server;
	private String user;
	
	public Ex25handler() {}

	public Ex25handler(Ex24server server, Socket socket) throws Exception {
		this.server = server;
		this.socket = socket;
		InputStream is = socket.getInputStream();
		OutputStream os = socket.getOutputStream();
		InputStreamReader isr = new InputStreamReader(is);
		OutputStreamWriter osw = new OutputStreamWriter(os);
		printWriter = new PrintWriter(osw, true);
		bufferedReader = new BufferedReader(isr);
	}
	
	public String getUser() {
		return user;
	}
	
	public void setUser(String user) {
		this.user = user;
	}
	
	public void run() {
		String name = "";
		try {
			name = bufferedReader.readLine();
			setUser(name);
			server.register(this);
			broadcast(name + " 님께서 입장하셨습니다.");
			
			while (true) {
				String message = bufferedReader.readLine();
				broadcast(name + ": " + message);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		server.unregister(name);
		broadcast(name + " 님께서 퇴장하셨습니다.");
	}
	
	protected void println(String message) {
		printWriter.println(message);
	}
	
	protected void broadcast(String message) {
		server.broadcast(message);
	}
}