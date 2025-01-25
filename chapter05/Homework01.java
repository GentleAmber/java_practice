public class Homework01{
	public static void main(String[] args){
		//Someone has 100,000 yuan. Every time he passes a transaction he needs to pay
		//Rules:
		//When his money is more than (>) 50,000, he needs to pay 5% of it.
		//When his money is less than (<=) 50,000, he needs to pay 1,000.
		//Calculate how many transactions he can cross. Use while break.
		double money = 100000, CHARGE_RATE = 0.05, CHARGE_AMOUNT = 1000;
		int intersectionCount = 0;
		while(true){
			if(money > 50000){
				money *= (1 - CHARGE_RATE);
				intersectionCount++;
			}else if(money >= 1000){
				money -= CHARGE_AMOUNT;
				intersectionCount++;
			}else{
				break;
			}
		}
		System.out.print("The number of intersections he can cross is: " + intersectionCount);
	}
}