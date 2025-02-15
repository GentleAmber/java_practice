public class Homework05{
	public static void main(String[] args){
		Circle c = new Circle();
		Circle c2 = new Circle(4);
		c2.showPerimeter();

	}
}

class Circle{
	double radius;
	double perimeter;

	public Circle(double radius){
		this.radius = radius;
	}
	public Circle(){
		
	}

	public void showPerimeter(){
		this.perimeter = 2 * Math.PI * radius;
		System.out.println("Perimeter: " + this.perimeter);
	}
}