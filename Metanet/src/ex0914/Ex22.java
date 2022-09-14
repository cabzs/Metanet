package ex0914;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Ex22 extends JFrame implements Runnable, ActionListener { //클라이언트
	private BufferedReader i;
	private PrintWriter o;
	private JTextArea output, list;
	private JTextField input;
	private JLabel label;
	private Thread listener;
	private String host;
	private JScrollPane jp;
	private JScrollBar jb;
	
	public Ex22(String server) {
		super("채팅 프로그램");
		host = server;
		listener = new Thread(this);
		listener.start();
		
		output = new JTextArea();
		jp = new JScrollPane(output);
		jb = jp.getVerticalScrollBar();
		add(jp, "Center");
		output.setEditable(false);
		
		Panel bottom = new Panel(new BorderLayout());
		label = new JLabel("사용자 이름");
		bottom.add(label, "West");
		input = new JTextField();
		bottom.add(input, "Center");
		input.addActionListener(this);
		add(bottom, "South");
		
		//측면 이용자 리스트 패널
		Container right = new Panel(new BorderLayout());
		list = new JTextArea(10, 10);
		list.setEditable(false);
		right.add(list);
		add(right, "East");
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(400,300);
		setVisible(true);
	}
	
	public void run() {
		try {
			Socket s = new Socket(host,7979);
			InputStream ins = s.getInputStream();
			OutputStream os = s.getOutputStream();
			i = new BufferedReader(new InputStreamReader(ins));
			o = new PrintWriter(new OutputStreamWriter(os),true);
			
			while(true) {
				String line = i.readLine();
				output.append(line + "\n");
				jb.setValue(jb.getMaximum());
			}
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	

	public static void main(String[] args) {
		if(args.length > 0) {
			new Ex22(args[0]);
		} else {
			new Ex22("localhost");
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object c = e.getSource();
		if(c == input) {
			label.setText("메세지");
			o.println(input.getText());
			input.setText("");
		}
		
	}

	
}

