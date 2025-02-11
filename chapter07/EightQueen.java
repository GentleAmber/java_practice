import java.io.PrintWriter;

public class EightQueen{
	public static void main(String[] args){
		//Initialise the board. 0: can put pieces on. 1: No. 2: A piece. 
		//3: Definitely no (ususally should only be used on row 0)
		int[][] board = new int[8][8];
		for (int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
				board[i][j] = 0;
			}
		}
		Board boardTool = new Board();
		boardTool.solve(board,0,0);
		boardTool.status(boardTool.solutionBoard);
	}
}

//column should be 0 when called in main
class Board{
	int solutionNum = 0;
	int[][] solutionBoard = new int[8][8];
	
	//WHEN CALLED IN MAIN, ALWAYS START WITH ROW = 0, startingColumn = 0
	//Scans from the left most to the right most
	public boolean solve(int[][] board, int row, int startingColumn){//row = i
		if(row == 7){
			System.out.println("Check the 7th row:");
			for(int i = 0; i < 8; i++){//If there's an empty cell, return true;
				if(board[row][i] == 0){
					board[row][i] = 2;
					//Save this solution
					for(int copyI = 0; copyI < 8; copyI++){
						for(int j = 0; j < 8; j++){
							solutionBoard[copyI][j] = board[copyI][j];
						}
					}
					System.out.println("There is empty cell. Return true.");
					return true;
				}
			}
			//Otherwise, false
			System.out.println("There's no empty cell. Return false.");
			return false;
		}else{
			System.out.println("Operating the " + row + "th row.");
			//Duplicate a board for testing
			int[][] newBoard = copyBoard(board);
			//...Put a piece on the duplicate and cross out unavailable cells accordingly
			boolean ifPiecePut = false;
			int pieceIndex = -1;
			for(int j = startingColumn; j < 8; j++){
				if(newBoard[row][j] == 0){
					newBoard[row][j] = 2;
					crossOut(newBoard, row, j);
					ifPiecePut = true;
					pieceIndex = j;
					break;
				}
			}
			if(ifPiecePut == false){
				System.out.println("No empty cell on the " + row + "th row. Return false.");
				return false;
			}else{
				System.out.println("Piece put on the " + pieceIndex + "th column.");
			}

			if(solve(newBoard, row + 1, 0)){
				//If the next row has empty cell(s), go on. Otherwise, receive false
				System.out.println("Next row: " + row + 1 + " has empty cells.");
			}else if(pieceIndex < 7){
				//The next row returned false, check availabilty from the next column
				System.out.println("Next row: " + row + 1 + " doesn't have empty cells.");
				System.out.println("Check if there's feasible place to put piece on the current row: " + row );
				solve(board, row, pieceIndex + 1);
			}else if(pieceIndex == 7){
				System.out.println("No feasible place to put piece on this row.");
				return false;
			}
		}
	System.out.println("???The programme really goes down here???");
	return false;
	}

	public int[][] copyBoard(int[][] board){
		int[][] newBoard = new int[8][8];
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
				newBoard[i][j] = board[i][j];
			}
		}
		return newBoard;
	}

	public void crossOut(int[][] board, int row, int currentColumn){
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
				if(i == row && j != currentColumn){
					board[i][j] = 1;
				}else if(i != row && j == currentColumn){
					board[i][j] = 1;
				}else if(i - row == j - currentColumn && i != row){
					board[i][j] = 1;
				}
			}
		}
		System.out.println("Crossout done. Current board status:");
		status(board);
	}

	public void status(int[][] board){
		for(int i = 0; i < board.length; i++){
			for(int j = 0; j < board[i].length; j++){
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}
}

//The golden frame is set, I believe:
// public boolean solve(int[][] board, int row, int startingColumn){//row = i
// 		if(row == 7){
// 			//If there's an empty cell, return true;
// 			//Otherwise, false
// 		}else{
// 			//...Put a piece on a branch board
// 			if(solve(borad, row + 1, 0)){
// 				//If the next row has empty cell(s), return true
// 			}else if(startingColumn < 7){
// 				//The next row returned false, check availabilty from the next column
// 				solve(borad, row, startingColumn + 1)
// 			}else if(startingColumn == 7){
// 				return false;
// 			}
// 		}
// 	}