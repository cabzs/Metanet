package ex0914;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.StringTokenizer;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.*;

public class Ex26chat extends JFrame implements Runnable, ActionListener {
	private BufferedReader reader;
	private PrintWriter writer;
	private JTextArea output;
	private JTextField input;
	private JLabel label;
	private Thread listener;
	private String host;
	private JScrollPane scrollPane;
	private JScrollBar scrollBar;
	private List user;
	
	private JTextArea userList;
	
	public Ex26chat() {}
	
	public Ex26chat(String server) {
		super("채팅창");

		host = server;
		listener = new Thread(this);
		listener.start();
		
		output = new JTextArea();
		scrollPane = new JScrollPane(output);
		scrollBar = scrollPane.getVerticalScrollBar();
		add(scrollPane, "Center");
		output.setEditable(false);
		
		Panel bottom = new Panel(new BorderLayout());
		label = new JLabel("사용자 이름");
		bottom.add(label, "West");
		input = new JTextField();
		bottom.add(input, "Center");
		input.addActionListener(this);
		add(bottom, "South");
		
		user = new List();
		add(user, "West");
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(400, 300);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object c = e.getSource();
		if(c == input) {
			label.setText("메세지");
			writer.println(input.getText());
			input.setText(null);
		}
	}

	@Override
	public void run() {
		try {
			Socket socket = new Socket(host, 7900);
			InputStream is = socket.getInputStream();
			OutputStream os = socket.getOutputStream();
			reader = new BufferedReader(new InputStreamReader(is));
			writer = new PrintWriter(new OutputStreamWriter(os), true);
			
			while(true) {
				String line = reader.readLine();
				StringTokenizer stringTokenizer = new StringTokenizer(line, "#");
				output.append(stringTokenizer.nextToken() + "\n");
				user.removeAll();
				while (stringTokenizer.hasMoreElements()) {
					user.add(stringTokenizer.nextToken());
				}
				scrollBar.setValue(scrollBar.getMaximum());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		Ex26chat ce = new Ex26chat("localhost");
	}

}