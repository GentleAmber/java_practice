import java.util.Scanner;
public class IfExercise01{

	public static void main(String[] args){

		//Judge if a year is a leap year.
		//Leap year meets either of the two conditions: 
		//1) the number is divisible by 4 but not by 100;
		//2) divisible by 400.
		Scanner myScanner = new Scanner(System.in);
		System.out.println("Please type in a year:");
		int year = myScanner.nextInt();
		if ((year % 4 == 0 && year % 100 !=0) || year % 400 == 0){
			System.out.println(year + " is a leap year.");		
		}else{
			System.out.println(year + " is NOT a leap year.");		
		}

	}

}