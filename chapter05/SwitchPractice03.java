import java.util.Scanner;
public class SwitchPractice03{
	public static void main(String[] args){

		System.out.println("Please input a month:");
		Scanner s = new Scanner(System.in);
		int month = s.nextInt();
		switch (month){
			case 3:
			case 4:
			case 5:
				System.out.println("Spring");
				break;
			case 6:
			case 7:
			case 8:
				System.out.println("Summer");
				break;
			case 9:
			case 10:
			case 11:
				System.out.println("Autumn");
				break;
			case 12:
			case 1:
			case 2:
				System.out.println("Winter");
				break;
			default:
				System.out.println("This is not a valid month!");
				break;
		}


	}
}