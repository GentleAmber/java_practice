public class Homework02{
	public static void main(String[] args){
		//Determine if a number is an armstrong/narcissist number
		//Narcissist number: a number that is equal to the sum of its own digits
		//raised to the power of the number of digits
		//e.g. :153 = 1^3 + 5^3 + 3^3, 9474 = 9^4 + 4^4 + 7^4 + 4^4
		//For this homework only search among 3-digit numbers
		for(int i = 100; i <= 999; i++){
			//Define variables for ones place, tens place, hundreds place
			int ones = i % 10, tens = (i % 100) / 10, hundreds = i / 100;//Tested
			//Calculate the sum of these digits raised to the power of 3
			double sumPower = Math.pow(ones , 3) + Math.pow(tens , 3) + Math.pow(hundreds , 3);
			if (sumPower == i){
				System.out.println(i);
			}else{
				continue;
			}
		}
		System.out.println("These are all the Narcissistic numbers between 100-999.");
	}
}