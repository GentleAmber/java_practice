import java.util.Scanner;
public class Array02{
	//Dynamic initialization
	public static void main(String[] args){
		//Input 5 scores and save into a double array, and then output
		Scanner mySc = new Scanner(System.in);
		double scores[] = new double[5];
		/*
		Alternative: 
		double scores[];//(1)
		scores = new double[5];//(2)
		
		What happens when executing (1):
			Create a variable, but it hasn't been pointed to any space yet
		What happens when executing (2):
			Assign a space for scores[] to store data
		*/

		for (int i = 0; i < scores.length; i++){
			System.out.print("Please type in a score: ");
			scores[i] = mySc.nextDouble();
		}
		for (int i = 0; i < scores.length; i++){
			System.out.print(scores[i] + " ");
		}
	}
}