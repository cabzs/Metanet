package app;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Ex7 {

	public static void main(String[] args) {
		int kor, eng, math, total;
		double avg;
		String names[] = {"�濩��", "��ä��", "��ξ�"};
		int kors[] = { 30 , 20 , 100 };
		int engs[] = { 100 , 70 , 100 };
		int maths[] = { 20 , 50 , 100 };
		
		List arr = new ArrayList(); 
		for (int i = 0 ; i < names.length ; i ++) {
			//�پ��� ��ü �߰� ���
			arr.add(names[i]); //����ڽ�
			arr.add(kors[i]);
			arr.add(engs[i]);
			arr.add(maths[i]);
		}
		
		System.out.println("-------------�л� ���� ��ȸ ���α׷�-----------------");
		System.out.println("�̸� \t ���� \t���� \t���� \t���� \t���");
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
