package ex0907;

import java.awt.Toolkit;

public class Ex13 extends Thread {
	public void run() {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		System.out.println("ex13 호출됨!");
		for (int i = 0 ; i < 5 ; i++) {
			toolkit.beep();
			try {
				Thread.sleep(500); //스레드의 상태를 전이시키는 메소드
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
