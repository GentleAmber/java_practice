public class Homework06{
	public static void main(String[] args){
		//Output all the numbers that cannot be divided by 5 between 1-100
		//5 numbers in a line
		int lineController = 0;
		for (int i = 1; i <= 100; i++){
			if (i % 5 != 0){
				System.out.print(i + "\t");
				lineController++;
				if (lineController % 5 ==0){
					System.out.print("\n");
				}
			}
		}
	}
}