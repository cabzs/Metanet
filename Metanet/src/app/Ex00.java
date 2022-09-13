package app;

import java.util.Scanner;

public class Ex00 {

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("1. 숫자를 입력하세요");
        int a = sc.nextInt();
        System.out.println(a);
        
        System.out.println("2. 문자를 입력하세요");
        String b = sc.nextLine();
        System.out.println(b);
        
        System.out.println("3. 숫자를 입력하세요");
        int c = sc.nextInt();
        System.out.println(c);
        
        sc.nextLine();
        
        System.out.println("4. 문자를 입력하세요");
        String d = sc.nextLine();
        System.out.println(d);
        
        System.out.println("5. 숫자를 입력하세요");
        int e = sc.nextInt();
        System.out.println(e);
        
        sc.nextLine();
        
        System.out.println("6. 숫자를 입력하세요");
    	int f = Integer.parseInt(sc.nextLine());
    	System.out.println(f);

        System.out.println("7. 숫자를 입력하세요");
        int g = sc.nextInt();
        System.out.println(g);
        
        System.out.println("8. 문자를 입력하세요");
        String h = sc.next();
        System.out.println(h);

	}

}
