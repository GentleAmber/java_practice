public class ForExercise{

	public static void main(String[] args){

		//Q1
		//Print integers that can be divided by 9 between 1-100
		//Also count the numbers and calculate their sums
		int count = 0, sum = 0;
		for (int i = 1; i <= 100; i++){
			if(i % 9 == 0){
				System.out.println(i);
				count++;
				sum += i;
			}
		}
		System.out.println("Count: " + count);
		System.out.println("Sum: " + sum);

	}
}
class ForExercise02{

	public static void main(String[] args){
		/*
		Q2
		Output the following formulas:
		0 + 5 = 5
		1 + 4 = 5
		2 + 3 = 5
		...
		5 + 0 = 5
		*/
		int FIVE = 5;
		for (int i = 0; i <= FIVE; i++){
			int sub = FIVE - i;
			System.out.println(i + " + " + sub + " = " + FIVE);
		}

	}
}