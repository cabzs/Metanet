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
		login = new JButton("�α���");
		join= new JButton("ȸ������");
		
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
		
		//Frame frame = new Frame(); // frame �ν��Ͻ� ����
		//frame.setSize(300, 450);
		//frame.setVisible(true);
		//frame.addWindowListener(this);
		
		setSize(300, 300);
		setVisible(true);
		addWindowListener(new WindowAdapter() {
			
			@Override // â ������ �߻��ϴ� �̺�Ʈ
			public void windowClosing(WindowEvent e) {
				System.exit(0);
				
			}
		});
		login.addActionListener(this); //����ڰ� ��ư �������� �����ϴ� �̺�Ʈ
		
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
		System.out.println("�α��� ��ư Ȯ��! : " + id_tf.getText() );
		id_tf.setText("");
		ex6.setVisible(true);
		this.setVisible(false);
		ex6.dispose(); //��ü�� ������Ų��.
		
//		if(id_tf.getText().equals(ex4.member[0].getId()) && pwd_tf.getText().equals(ex4.member[0].getPwd()) ) {
//			
//		}
	}

	
}
