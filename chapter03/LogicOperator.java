public class LogicOperator{

	public static void main(String[] args){

		//Shows difference between logical AND and ? AND
		int a = 9;
		int b = 4;

		if(a < 8 & ++b > 3){
			System.out.println("ok1");
		}
		System.out.println("For &: a=" + a + ", b=" + b);

		if (a < 8 && ++b > 3){
			System.out.println("ok2");
		}
		System.out.println("For &&: a=" + a + ", b=" + b);

	}
}