import java.util.Scanner;
public class SwitchPractice01{
	public static void main(String[] args){

		System.out.println("Please input a char of a/b/c/d/e/f/g:");
		Scanner s = new Scanner(System.in);
		char ch = s.next().charAt(0);
		switch (ch){
		case 'a':
			System.out.println("Monday");
			break;
		case 'b':
			System.out.println("Tuesday");
			break;
		case 'c':
			System.out.println("Wednesday");
			break;
		case 'd':
			System.out.println("Thursday");
			break;
		case 'e':
			System.out.println("Friday");
			break;
		case 'f':
			System.out.println("Saturday");
			break;
		case 'g':
			System.out.println("Sunday");
			break;
		default:
			System.out.println("This is not a valid character!");
			break;
		}


	}
}