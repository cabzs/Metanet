package ex0907;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

public class Ex14 extends Frame implements Runnable {

	int x = 0;
	int y = 0;
	boolean xOrient, yOrient; //필드값 자동 초기화
	public Ex14() {
		setSize(300,200);
		setVisible(true);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	
	public void paint(Graphics gr) { //창 띄우자마자 자동으로 호출됨
		Random ran = new Random();
		Dimension d = this.getSize(); //컨테이너에 대한 가로세로 크기를 가져온다
		if(xOrient) {
			x--;
			if(x<0) {
				x=0;
				xOrient = false;
			}
		} else {
			x++;
			if(x>= d.width - 20) {
				x = d.width - 20;
				xOrient = true;
			}
		}
		
		if(yOrient) {
			y--;
			if(y<0) {
				y=0;
				yOrient = false;
			}
		} else {
			y++;
			if(y>= d.height - 20) {
				y = d.height - 20;
				yOrient = true;
			}
		}
		
		int r = ran.nextInt(255);
		int g = ran.nextInt(255);
		int b = ran.nextInt(255);
		gr.setColor(new Color(r,g,b));
		gr.drawRect(x, y, 20, 20);
	}
	public void update(Graphics g) {
		paint(g);
	}
	
	public void run() {
		while (true) {
			repaint();
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}
	
	public static void main(String[] args) {
		Thread thread = new Thread(new Ex14());
		thread.start();
		
	}

}
