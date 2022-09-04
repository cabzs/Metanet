package app;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Ex6 extends Frame {
	public Ex6() {
		super("GUI");
		this.setSize(300,300);
		this.setVisible(false);
		setResizable(false);
		this.addWindowListener(new WindowAdapter() {
			
			@Override // 창 닫을때 발생하는 이벤트
			public void windowClosing(WindowEvent e) {
				System.exit(0);
				
			}
		});

	}


}
