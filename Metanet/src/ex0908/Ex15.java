package ex0908;

public class Ex15 {
	
	String str = "";
	public void foo(int i) {
		try {
			if(i==1) {
				throw new Exception();
			}
			str += "1"; //예외 발생시 무시된다
		}catch(Exception e) {
			str += "2";
			return; //메소드를 빠져나감
		} finally {
			str += "3"; //return을 만나도 finally는 실행
		}
		str += "4";
	}// foo
	
	public static void main(String[] args) {
		Ex15 ee = new Ex15();
		ee.foo(0); //134
		ee.foo(1); //23
		System.out.println(ee.str); //13423

	}

}
