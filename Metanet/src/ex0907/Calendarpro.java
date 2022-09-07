package ex0907;

import java.util.Calendar;
import java.util.Scanner;

public class Calendarpro {

	// 달력 프로그램 만들기
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Calendar cal = Calendar.getInstance();
		
			System.out.println("연도를 입력하세요");
			int year = sc.nextInt();
			
			if(year==0) {
				System.exit(0);
			}
			
			System.out.println("달을 입력하세요");
			int month = sc.nextInt();
			
			if(month<1 || month>12) {
				System.out.println("1부터 12사이의 수를 입력해주세요");
				return;
			}
			
			cal.set(Calendar.YEAR, year); //입력받은 년도로 세팅
			cal.set(Calendar.MONTH, month);
			cal.set(year, month-1,1); //(int year, int month, int date)
			
			System.out.println("================" +year+"년 "+month+"월 달력===================");
			System.out.println();
			System.out.println("일\t월\t화\t수\t목\t금\t토 ");
			int startDay = cal.get(Calendar.DAY_OF_WEEK); //월의 1일에 대한 요일을 받아온다.
			int lastDay = cal.getActualMaximum(Calendar.DATE); //해당 달의 최대일을 받아온다
			
			for(int i = 1; i < lastDay + startDay ; i++) { //lastDay + startDay
				if(i<startDay) {
					System.out.print("\t");
					continue;
				}
				System.out.print((i- startDay + 1) + "\t"); //위에서 증가한 값 부터 시작되기 때문에 i- startDay
				if(i%7==0) { //개행
					System.out.println();
				}
			}
			System.out.println();
			System.out.println("====================================================");
		}
}

