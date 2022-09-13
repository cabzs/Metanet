package ex0913;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class EchoClient extends JFrame implements ActionListener {
	
	JTextArea ta;
	JTextField tf;
	JButton btn;

	
	private Socket socket;
	
	public EchoClient () { //GUI
		setTitle("client");
		setBounds(450,50,500,350);
		
		ta = new JTextArea();
		ta.setEditable(false); //글 작성 금지
		JScrollPane scrollPane = new JScrollPane(ta);
//		33add(scrollPane, )
		
		
	}
	
	public EchoClient(String host, int port) throws Exception {
		socket = new Socket(host, port); //host에 접속할 ip주소
	}
	
	public void echo() throws IOException {
		
		OutputStream os = socket.getOutputStream();
		InputStream is = socket.getInputStream(); //byteStream...
		BufferedReader in = new BufferedReader(new InputStreamReader(is));
		PrintWriter out = new PrintWriter(os,true);
		BufferedReader con = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			String msg = con.readLine();
			out.println(msg);
			if(msg.equals("bye")) {
				break;
			}
			System.out.println(in.readLine());
		}
	}
	
	public void close() throws IOException {
		socket.close();
	}	
	
	public static void main(String[] args) {
		try {
			EchoClient ec;
			System.out.println("메세지를 입력하세요");
			
			if(args.length > 0) {
				ec = new EchoClient(args[0], 1289);
			} else {
				ec = new EchoClient("localhost", 1289);
			}
			ec.echo();
			ec.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
