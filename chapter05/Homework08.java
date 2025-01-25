public class Homework08{
	public static void main(String[] args){
		//Calculate the sum of this formula:
		//1-1/2+1/3-1/4...1/100

		double denominator = 1, sum = 0;
		while (denominator <= 100){
			if (denominator % 2 != 0){
				sum += 1/denominator;
			}else{
				sum -= 1/denominator;
			}
			denominator++;
		}
		System.out.println(sum);
	}
}