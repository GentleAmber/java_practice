public class Homework09{
	public static void main(String[] args){
		//Calculate 1 + (1+2) + (1+2+3) + ... + (1+2+3+...+100)
		int totalSum = 0;
		for (int i = 1; i <= 100; i++){
			int singleBracket = 0;
			for (int j = 1; j <= i; j++){
				singleBracket += j;
			}
			totalSum += singleBracket;
		}
		System.out.println(totalSum);
	}
}
