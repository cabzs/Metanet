package ex0908;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Ex16 {
	//입력
	public static void main(String[] args) throws IOException {
		File file = new File("C:/IO/IO.txt");
		FileWriter fw = new FileWriter(file);
		BufferedWriter bw = new BufferedWriter(fw);
		PrintWriter pw = new PrintWriter(bw, true);
		InputStream is = System.in;
		InputStreamReader isr = new InputStreamReader(is); //read로 변환시켜준다
		BufferedReader br = new BufferedReader(isr); //개행문자도 받아줌
		
		System.out.println("입력 : ");
		String str = "";
		while(!str.equals("end")){
			str = br.readLine();
			pw.println(str);
		}
		br.close();
		pw.close();

	}

}
