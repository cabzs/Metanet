package app;

public class Ex3 {
	
	Ex3(){
		this(100,"A");
	}

	Ex3(int a){ //오버로딩
		
	}
	
	Ex3(String s, int b){
		System.out.println(s);
	}
	
	Ex3(int b, String a){
		
	}
	
	public static void main(String[] args) {
		new Ex3("",10);
	}
	
}
