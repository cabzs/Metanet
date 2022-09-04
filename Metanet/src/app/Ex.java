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
			System.out.println("1.학생수  | 2. 점수입력 |  3. 점수리스트  | 4.");
			System.out.println("----------------------------------------");
			System.out.println("선택>  ");
			int selectNo = scanner.nextInt();
			if(selectNo==1) {
				System.out.println("학생 수를 입력하세요 : ");
				int studenNum = scanner.nextInt();
				scores = new int[studentNum];
				System.out.println("학생 수가 입력되었습니다 :)");
			}
			else if (selectNo==2) {
				System.out.println("점수를 입력하세요 :");
				for(int i = 0; i<scores.length; i++ ) {
					System.out.println("scores [ " + i + "] >");
					scores[i] = scanner.nextInt();
				}
			}
			
			
			
		}

	}

}
