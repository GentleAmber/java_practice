class practice{
	public static void main(String[] args){
		
		//Adding an int and a float number
		int n1 = 10;
		
		/*
		[Method 1]:
		float f1 = 1.1f;
		float f2 = n1 + f1;
		System.out.println(f2);
		*/

		//[Method 2]:
		float f1 = n1 + 1.1f;
		System.out.println(f1);

	}
}

class Calculation{

	public static void main(String[] args){

		char c1 = 'c';
		char c2 = 'b';
		//char c3 = c1 + c2; This will cause error because c1 + c2 -> int
		// System.out.println(c1);
		// System.out.println((int)c2);

	}
}

class Convert{

	public static void main(String[] args){


		// Q1:
		// short s = 12;
		// s = s - 9;
		// False syntax

		// Q2:
		byte b = 10;
		// b = b + 11; Flase syntax
		b = (byte)(b + 11);

		// Q3:
		char c ='a';
		int i = 16;
		float d = .314F;
		double result = c + i + d;
		c = (char)result;
		System.out.println(c);// should be q

		// Q4:
		byte j = 16;
		short s = 14;
		short t = (short)(s + j);// Why does this work??
		System.out.println(t);

	}
}