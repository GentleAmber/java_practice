
public class RecursionExercise01{
	public static void main(String[] args){
		//Q1: Use recursion method to calculate Fibonacci number with the given N
		Fibonacci numCalculator = new Fibonacci();
		int n = 7;
		System.out.println("No. " + n + " in Fibonacci sequence: " + numCalculator.number(n));
	
		//Q2: Monkey peach problem: 
		//There are peaches. A monkey eats half of them plus one every day. On day 10, when
		//the monkey is about to eat peaches, it finds there's only 1 peach left.
		//So how many peaches were there initially?
		Monkey monkey = new Monkey();
		System.out.println("The initial number of peaches: " + monkey.peachLeft(1));
	}
}

class Fibonacci{
	public int number(int n){
		if(n > 2){
			return (number(n - 1) + number(n - 2));
		}else{
			return 1;
		}
	}
}

class Monkey{
	public int peachLeft(int day){
		//int day = should input 1
		//return the number of the peaches before today's eating
		if(day == 10){
			return 1;
		}else{
			return 2 * (1 + peachLeft(day + 1));
		}
	}
}