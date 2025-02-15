public class Overload01{
	public static void main(String[] args){
		MyCalculator tool = new MyCalculator();
		System.out.println("1 + 2 = " + tool.sum(1,2));
		System.out.println("1.6 + 2 = " + tool.sum(1.6,2));
		System.out.println("2 + 2.5 = " + tool.sum(2,2.5));
		System.out.println("2 + 2 + 5 = " + tool.sum(2,2,5));

	}
}

class MyCalculator{
	public int sum(int n1, int n2){
		int sum = n1 + n2;
		return sum;
	}

	public double sum(int n1, double n2){
		double sum = n1 + n2;
		return sum;
	}

	public double sum(double n1, int n2){
		double sum = n1 + n2;
		return sum; 
	}

	public int sum(int n1, int n2, int n3){
		int sum = n1 + n2 + n3;
		return sum;
	}
}