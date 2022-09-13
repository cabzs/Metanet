package ex0913;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
	private ServerSocket server;
	public EchoServer(int port) throws IOException {
		server = new ServerSocket(port); //서버를 거쳐서 통신
	}
	
	public void service () throws IOException {
		Socket client = server.accept(); //소켓을 반환한다
		InputStream is = client.getInputStream(); //byteStream...
		OutputStream os = client.getOutputStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader in = new BufferedReader(isr);
		PrintWriter out = new PrintWriter(os,true);
		BufferedReader con = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			String msg = in.readLine();
			System.out.println(msg);
			if(msg.equals("bye")) {
				break;
			}
			out.println(">>" + msg);
		}
		
	}
	public void close() throws IOException {
		server.close();
	}
	
	public static void main(String[] args) {
		try {
			EchoServer es = new EchoServer(1289);
			es.service();
			es.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
