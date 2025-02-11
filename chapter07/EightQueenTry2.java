import java.util.Random;
public class EightQueenTry2{
	public static void main(String[] args){
		//Use a one dimentional array, index for the row, value for the column
		//e.g. One solution:{0,4,7,5,2,6,1,3} means the eight pieces are put at these positions:
		//(0,0),(1,4),(2,7),...,(7,3)
		int[] board = new int[8];
		Queen tool = new Queen();
		tool.solve(board,0);
		System.out.println("The number of all the possible solutions: " + tool.solutionNum + "\n");

		System.out.println("Print three random solutions: ");
		Random rand  = new Random();
		for(int i = 0; i < 3; i++){
			int[] tem = tool.allSolutions[rand.nextInt(tool.solutionNum)];
			System.out.print("{");
			for(int j = 0; j < tem.length; j++){
				if(j != tem.length - 1)
					System.out.print(tem[j] + ", ");
				else
					System.out.print(tem[j]);
			}
			System.out.println("}");
		}
	}
}

class Queen{
	int solutionNum = 0;
	int[][] allSolutions = new int[92][8];
	int solutionIndex = 0;

	public void solve(int[] board, int row){

		if(row == 7){
			for(int i = 0; i < 8; i++){
				int approvedRow = 0;
				for(int j = row - 1; j >= 0; j--){
					if(board[j] != i && Math.abs(board[j] - i) != Math.abs(j - row)){
						approvedRow++;
					}
					if(approvedRow == row){
						board[row] = i;//Got one solution
						solutionNum++;
						saveSolution(allSolutions, solutionIndex, board);
						solutionIndex++;
						return;
					}
				}
			}
			return;
		}else if(row > 0){
			//For any other rows except the first
			for(int i = 0; i < 8; i++){
				int approvedRow = 0;
				for(int j = row - 1; j >= 0; j--){
			  		if(board[j] != i && Math.abs(board[j] - i) != Math.abs(j - row)){
						approvedRow++;
					}
					if(approvedRow == row){
						board[row] = i;//Put down the piece and go on to the next row
						solve(board, row + 1);
					}
				}
			}
			return;
		}else{
			//For the 1st row
			for(int i = 0; i < 8; i++){
				board[row] = i;
				solve(board, row + 1);
			}
		}
	}

	public void saveSolution(int[][] allSolutions, int solutionIndex, int[] board){
		for(int i = 0; i < 8; i++){
			allSolutions[solutionIndex][i] = board[i];
		}
	}
}
