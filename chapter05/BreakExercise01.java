public class BreakExercise01{
	public static void main(String[] args){
		int sum = 0;
		for (int i = 1; i <= 50000; i++){
			int count = 0;
			while(true){
			int randomNumber = (int)(Math.random() * 100) + 1;
			count++;
			if (randomNumber == 97){
				sum += count;
				break;
				}
			}
		}
		System.out.print("The average number of times to generate 97 among 1-100 is: " + 
			sum/50000.0);
		
	}
}