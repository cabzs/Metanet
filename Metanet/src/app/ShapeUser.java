package app;

public class ShapeUser {

	public static void main(String[] args) {
		Shape[] shape = new Shape[3];
		shape[0] = new Circle(5);
		shape[1] = new Circle(7);
		shape[2] = new Rect(9,5);
		
		System.out.println("**** 기본형으로 출력하기 ****");
		System.out.println("shape[0]'s area = " + shape[0].area());
		System.out.println("shape[1]'s area = " + shape[1].area());
		System.out.println("shape[2]'s area = " + shape[2].area());
		
		System.out.println("**** 반복문으로 출력하기 **** ");
		for(int i=0; i<3; i++) {
			System.out.println("shape["+i+"]'s area = " + shape[i].area());
		}
		
		//사각형 넓이 구하기
		((Rect)(shape[2])).getSize();
		
		Rect rect = (Rect)shape[2];
		rect.getSize();
	}

}
