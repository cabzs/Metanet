package app;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Ex5 extends JFrame implements ActionListener {
	
	Ex4 ex4 = new Ex4();
	Ex6 ex6 = new Ex6();
	public JTextField id, pwd;
	
	
	JLabel id_la, pwd_la;
	JTextField id_tf, pwd_tf;
	JButton login, join;
	
	public Ex5() {
		super("GUI");
		id_la = new JLabel("ID"); 
		pwd_la = new JLabel("PWD");
		id_tf = new JTextField();
		pwd_tf = new JTextField();
		login = new JButton("로그인");
		join= new JButton("회원가입");
		
		JPanel p = new JPanel();
		JPanel p2 = new JPanel(new GridLayout(2,2));

		p.setLayout(new GridLayout(1,2));
		p.add(login);
		p.add(join);
		p2.add(id_la);
		p2.add(id_tf);
		p2.add(pwd_la);
		p2.add(pwd_tf);
		
		this.add(p,"South");
		this.add(p2,"Center");
		
		//Frame frame = new Frame(); // frame 인스턴스 생성
		//frame.setSize(300, 450);
		//frame.setVisible(true);
		//frame.addWindowListener(this);
		
		setSize(300, 300);
		setVisible(true);
		addWindowListener(new WindowAdapter() {
			
			@Override // 창 닫을때 발생하는 이벤트
			public void windowClosing(WindowEvent e) {
				System.exit(0);
				
			}
		});
		login.addActionListener(this); //사용자가 버튼 눌렀는지 감지하는 이벤트
		
		//id = new JTextField("id");
		//pwd = new JTextField("pwd");
		//JPanel p = new JPanel();
		//p.add(id);
		//p.add(pwd);
		//this.add(p);
		

	}

	public static void main(String[] args) {
		new Ex5();
		

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("로그인 버튼 확인! : " + id_tf.getText() );
		id_tf.setText("");
		ex6.setVisible(true);
		this.setVisible(false);
		ex6.dispose(); //객체를 해지시킨다.
		
//		if(id_tf.getText().equals(ex4.member[0].getId()) && pwd_tf.getText().equals(ex4.member[0].getPwd()) ) {
//			
//		}
	}

	
}