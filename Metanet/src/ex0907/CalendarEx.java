package ex0907;

import java.sql.Time;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.TextStyle;
import java.util.Calendar;
import java.util.Locale;

public class CalendarEx implements Runnable{
	
	/**
	 * Calendar class는 1970년 1월 1일부터 특정 값으로 진보해 오면서
	 * 날짜와 시간에 대한 조작을 수행할 수 있도록 제공되는 abstract class이다.
	 * Object 생성 법은 다음과 같다.
	 * 	1) Calendar cal = Calendar.getInstance(); //abstract이기때문에 new 생성 불가능,
	 * 	2) GregorianCalendar cal = new GregorianCalendar();
	 * */
	
	public CalendarEx() {
		new Thread(this).start();
			
	}
	
	
	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = (cal.get(Calendar.MONTH) + 1); //0부터 반환되기 때문에 +1을 해준다.
		int date = cal.get(Calendar.DATE);
		
		System.out.println("년 : " + year);
		System.out.println("월 : " + month);
		System.out.println("일 : " + date);
		System.out.println("일 : " + date);
		
		//시,분,초 를 출력해 보세요
		//요일 출력
		
		int day1 = cal.get(Calendar.DAY_OF_YEAR);
		int day2 = cal.get(Calendar.DAY_OF_MONTH);
		int day3 = cal.get(Calendar.DAY_OF_WEEK);
		int day4 = cal.get(Calendar.WEEK_OF_YEAR);
		
		/**
		 * DAY_OF_WEEK : 한 주의 요일을 나타낸다.
		 * 	Calendar.SUNDAY 1
			Calendar.MONDAY 2
			Calendar.TUESDAY 3
			Calendar.WEDNESDAY 4
			Calendar.THURSDAY 5
			Calendar.FRIDAY 6
			Calendar.SATURDAY 7
		 * */
		
		System.out.println("오늘은 "+year+"년의 " + day1 + "번째 날입니다.");
		System.out.println("오늘은 "+month+"월 " + day2 + "일 입니다.");
		System.out.println("오늘은 이번주 : " + day3 + "요일입니다.");
		System.out.println("오늘은 올해의 : " + day4 + "주입니다.\n");
		
		String[] yoil = {"일","월","화","수","목","금","토"};
		//요일 출력
		System.out.println("오늘은" + yoil[day3-1] + "요일 입니다."); //yoil[day3-1] 인덱스는 0부터 시작, -1해준다.
		
		year = 2020;
		month = 5;
		cal.set(year, month-1,1); //(int year, int month, int date)
		int startDay = cal.get(Calendar.DAY_OF_WEEK); //월의 1일에 대한 요일을 받아온다.
		int lastDay = cal.getActualMaximum(Calendar.DATE); //해당 달의 최대일을 받아온다
		
		System.out.println("=====================달력========================");
		System.out.println("일\t월\t화\t수\t목\t금\t토 ");
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
		
		
		/*
		LocalDateTime time = LocalDateTime.now();
		DayOfWeek dayOfWeek = time.getDayOfWeek();
		int dayOfWeek1 = dayOfWeek.getValue(); //숫자 요일
		System.out.println(dayOfWeek1 + "요일");
		System.out.println(dayOfWeek.getDisplayName(TextStyle.FULL, Locale.KOREAN));
		
		
		System.out.println("시간 : " + time);
		
		LocalDate date1 = LocalDate.now();
		System.out.println(date1);
		*/


	} //main 끝	
	
	public void run() {
		while(true) {
			try {
				Thread.sleep(1000);
				System.out.println(Calendar.getInstance().get(Calendar.SECOND));
				
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
} //class끝
