public class LogicOperatorTest{
	public static void main(String[] args){
		int[] board = new int[] {0,7,1,2,1,6,0,3};
		for(int i = 1; i < 8; i++){
			System.out.println("Examine the " + i + "th row.");
			for(int j = i - 1; j >= 0; j--){
				if(board[i] != board[j] && Math.abs(board[i] - board[j]) != Math.abs(i - j)){
					System.out.print("It works with " + j + "th row.\t");
				}else{
					System.out.print("It DOESN'T work with " + j + "th row.\t");
				}
			}
			System.out.println();
		}
	}
}