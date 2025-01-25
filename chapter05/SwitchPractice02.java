import java.util.Scanner;
public class SwitchPractice02{
	public static void main(String[] args){

		Scanner mySc = new Scanner(System.in);
		System.out.println("Please type in the score.");
		int score = mySc.nextInt();

		if(score <= 100){
			switch(score/60){
				case 0 :
					System.out.println("Unsuccessful");
					break;
				case 1  :
					System.out.println("Successful");
					break;
				// default:
				// 	System.out.println("This is just a default phrase.");
			}
		}else{
			System.out.println("The score should be lower than 100.");
		}
	}
}