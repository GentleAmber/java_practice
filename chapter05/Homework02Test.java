import java.util.Scanner;
public class Homework02Test{
	public static void main(String[] args){
		Scanner mySc = new Scanner(System.in);
		//Module 1: Getting digits out of the number 

		// while(true){
		// 	System.out.print("Give me a integer between 100-999 (type beyond to exit): ");
		// 	int i = mySc.nextInt();
		// 	if (i >= 100 && i <= 999){
		// 		int ones = i % 10, tens = (i % 100) / 10, hundreds = i / 100;
		// 		System.out.println("The three digits are: " + ones + ", " + tens + ", " + 
		// 			hundreds);
		// 	}else{
		// 		System.out.println("Exiting...");
		// 		break;
		// 	}
		// }

		//Module 2: Calculate the sum of the digits raised to the power of 3.
		int a = 1, b = 5, c = 3;
		int sum = a ^ 3 + b ^ 3 + c ^ 3;
		System.out.println(sum);
		// So it's this module that's causing the proglem. ^ is not the right operator to use.
		System.out.print(Math.pow(b , 3));
		//This is outputing the right double number (instead of .0000000002 or so)
	}
}