import java.util.Scanner;
class DoWhileExercise{

	public static void main(String[] args){

		int sum = 0, i = 1;
		do{
			sum += i;
			i ++;		
		}while(i <= 100);
		System.out.println(sum);
	}
}

class DoWhileExercise01{

	public static void main(String[] args){
		//Count the numbers that can be divided by 5 but not 3 between 1-200
		int count = 0, i = 1;
		do{
			if(i % 5 == 0 && i % 3 != 0){
				count ++;
			}
			i ++;		
		}while(i <= 200);
		System.out.println(count);
	}
}


class DoWhileExercise02{

	public static void main(String[] args){
		//If the user don't say yes, the programme will not end
		Scanner mySc = new Scanner(System.in);
		char answer = 'n';
		do{
			System.out.println("Are you going to say yes?  y/n" );
			answer = mySc.next().charAt(0);
		}while(answer != 'y');
	}
}