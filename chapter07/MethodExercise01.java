public class MethodExercise01{
	public static void main(String[] args){
		AA aatool = new AA();
		int n = 40;
		if(aatool.oddOrEven(n)){
			System.out.print(n + " is an odd number.\n");
		}else{
			System.out.print(n + " is an even number.\n");
		}

		int row = 3, column = 5;
		char c = 'k';
		aatool.specialPrint(row,column,c);
	}
}
class AA{
	public boolean oddOrEven(int n){
		//odd -> true, even -> false
		if(n % 2 == 0){
			return false;
		}else{
			return true;
		}
	}

	public void specialPrint(int row, int column, char c){
		//Print the chat with the given row and column
		for(int i = 0; i <= row; i++){
			for(int j = 0; j <= column; j++){
				System.out.print(c + " ");
			}
			System.out.println();
		}
	}
}