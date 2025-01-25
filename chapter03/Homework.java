import java.util.Scanner;
public class Homework{
	public static void main(String[] args){
		//Q1
		System.out.println("Q1: ");
		System.out.println(10/3);//3
		System.out.println(10/3.0);//3.3333333
		System.out.println(10/5);//2
		System.out.println(10%2);//0
		System.out.println(-10.5%3);//=-10.5-(-10.5)/3*3

		//Q2
		int i = 66;
		System.out.println("Q2: ");
		System.out.println(++i+i);//Priority: Unary Operator > Arithmetic Operator
							//67+67=134
	
		//Q4
		//converting string to double
		System.out.println("Q4: ");
		String str = "19.8";
		double d1 = Double.parseDouble(str);

		//converting char to string
		char any = 'a';
		String anyToString = any + "";




	}
}