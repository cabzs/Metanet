package app;

public class Circle extends Shape {
	protected int r;
	public Circle () {
		r = 0;
	}
	
	public Circle(int r) {
		this.r = r;
	}
	
	public double circumference() {
		return Math.PI*2*r;
	}
	
	public double area() {
		return Math.PI*r*r;
	}
	
	public int getRadius() {
		return r;
	}
	
	public void setRadius(int r) {
		this.r = r;
	}
	
}
