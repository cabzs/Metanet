package app;

import java.util.Scanner;

public class Ex {

	public static void main(String[] args) {
		boolean run = true;
		int studentNum = 0;
		int [] scores = null;
		Scanner scanner = new Scanner(System.in);
		
		while(run) {
			System.out.println("----------------------------------------");
			System.out.println("1.�л���  | 2. �����Է� |  3. ��������Ʈ  | 4.");
			System.out.println("----------------------------------------");
			System.out.println("����>  ");
			int selectNo = scanner.nextInt();
			if(selectNo==1) {
				System.out.println("�л� ���� �Է��ϼ��� : ");
				int studenNum = scanner.nextInt();
				scores = new int[studentNum];
				System.out.println("�л� ���� �ԷµǾ����ϴ� :)");
			}
			else if (selectNo==2) {
				System.out.println("������ �Է��ϼ��� :");
				for(int i = 0; i<scores.length; i++ ) {
					System.out.println("scores [ " + i + "] >");
					scores[i] = scanner.nextInt();
				}
			}
			
			
			
		}

	}

}
