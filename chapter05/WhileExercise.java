class WhileExercise{

	public static void main(String[] args){

		/*
		Q1: print numbers that can be divided by 3 between 1-100
		*/
		int i = 1;
		while (i <= 100){
			if(i % 3 == 0){
				System.out.println(i);
			}
			i ++;
		}
	}
}

class WhileExercise02{

	public static void main(String[] args){
		//Q2: print all the even numbers between 40-200
		int i = 40;
		while (i <= 200){
			System.out.println(i);
			i += 2;
		}
	}
}