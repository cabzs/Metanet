package app;

	class X {
		protected int i = 10;
		protected String msg = "I am an X.";
		
		public void print() {
			System.out.println(msg);
		}
		
		public void play() {
			System.out.println("Play.." + msg);
		}
	}	
		
	class Y extends X {
		protected int i = 20;
		protected String msg = "I am an Y.";
		
		@Override
		public void print() {
			System.out.println(msg);
		}
	}

public class Z extends Y {
	protected int i = 30;
	protected String msg = "I am a Z.";
	
	public void print () {
		System.out.println(msg);
	}
	
	public void play() {
		System.out.println("Play.." + msg);
	}
	
	public void doZ() {
		System.out.println("do something in Z.");
	}
	
	public void test(int i) {
		Z z = new Z();
		Y y = z; // is a 관계
		X x = z;
		// 문제 )
		z.print(); //I am a Z.
		y.print(); //I am a Z.
		x.print(); //I am a Z. 한번 재정의되면 변환된 타입으로만 사용가능 (객체로 접근했을때)
		super.print(); //I am an Y. super,this는 다이렉트로 접근 (객체로 접근하지 않는다 )
		play(); //Play..I am a Z.
		super.play(); //Play..I am an X.
		//y.doZ();
		//super.super.print();
		System.out.println("\ni = " + i); //i = 15
		System.out.println("this.i = " + this.i); //this.i = 30
		System.out.println("super.i = " + super.i); //super.i = 20
		System.out.println("y.i = " + y.i); //y.i = 30 은닉, 오버라이드는 기능! 변수에는 오버라이드 기능 없음. 
		System.out.println("x.i = " + x.i); //x.i = 30
		System.out.println("((Y)this).i = " + ((Y)this).i ); //((Y)this).i = 20
		System.out.println("((X)this).i = " + ((X)this).i ); //((X)this).i = 10
		//super.super.i = 10;
		System.out.println();
		System.out.println("X" + x);
		System.out.println("Y" + y);
		System.out.println("Z" + z);
		
	}

	public static void main(String[] args) {
		Z z = new Z ();
		z.test(15);

	}

}
