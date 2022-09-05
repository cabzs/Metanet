package app;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Ex7 {

	public static void main(String[] args) {
		int kor, eng, math, total;
		double avg;
		String names[] = {"경여랑", "공채현", "김민아"};
		int kors[] = { 30 , 20 , 100 };
		int engs[] = { 100 , 70 , 100 };
		int maths[] = { 20 , 50 , 100 };
		
		List arr = new ArrayList(); 
		for (int i = 0 ; i < names.length ; i ++) {
			//다양한 객체 추가 방법
			arr.add(names[i]); //오토박싱
			arr.add(kors[i]);
			arr.add(engs[i]);
			arr.add(maths[i]);
		}
		
		System.out.println("-------------학생 성적 조회 프로그램-----------------");
		System.out.println("이름 \t 국어 \t영어 \t수학 \t총점 \t평균");
		Iterator iterator = arr.iterator();
		while(iterator.hasNext()) {
			System.out.print("\n" + iterator.next());
			Object obj = iterator.next();
//			Integer kor2 = (Integer)obj;
			Integer in = (Integer)obj;
			kor = (Integer)obj;
//			kor = in.intValue();
			eng = ((Integer) iterator.next()).intValue();
			math = ((Integer) iterator.next());
			total = kor + eng + math;
			avg = (double)total/3;
			System.out.print("\t" + kor + "\t" + eng + "\t" + math );
			System.out.print("\t" + total + "\t" + avg );
		}

	}

}
