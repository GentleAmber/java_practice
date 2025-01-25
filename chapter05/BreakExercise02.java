import java.util.Scanner;
public class BreakExercise02{
	public static void main(String[] args){
		//Sum 1-100, and print the current number when the sum reaches above 20 for the first time
		//Use for + break
		int sum = 0;
		for (int i = 1; i <= 100; i++){
			sum += i;
			if (sum > 20){
				System.out.print("Sum = " + sum + ", current number = " + i);
				break;
			}
		}	
	}
}