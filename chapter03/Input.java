import java.util.Scanner;
public class Input{

	public static void main(String[] args){

		//Step 1. import the package where Scanner is in
		//Step 2. Create an instance of Scanner
		//Step 3. Receive user's input

		Scanner myScanner = new Scanner(System.in);
		System.out.println("Please type your name: ");
		String name = myScanner.next();
		System.out.println("Please type your age: ");
		int age = myScanner.nextInt();
		System.out.println("Please type your salary: ");
		double salary = myScanner.nextDouble();
		System.out.println("Please type your gender: ");
		char gender = myScanner.next().charAt(0);
		System.out.println("Your information is as follwed:");
		System.out.println("Name: " + name + ", Age: " + age 
			+ ", Salary: " + salary + ", Gender: " + gender);


	}
}