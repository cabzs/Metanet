package ex0907;

import java.awt.Toolkit;

public class Ex12 {

	public static void main(String[] args) {
		
		Thread thread = new Ex13();
		thread.start();
		
		for (int i = 0 ; i < 5 ; i++) {
			System.out.println("띵~");
			try {
				Thread.sleep(500); //스레드의 상태를 전이시키는 메소드
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
