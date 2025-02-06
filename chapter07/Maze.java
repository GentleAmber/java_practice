//A program for a mice to find the exit to a maze.
//Algorithm: Hand On Wall.

public class Maze{
	public static void main(String[] args){
		//Create the maze first. 1 = obstacle, 0 = accessible & untouched.
		int[][] maze = new int[8][7];
		for(int i = 0; i < maze.length; i++){
			for(int j = 0; j < maze[i].length; j++){
				if(i == 0 || i == maze.length - 1){
					maze[i][j] = 1;
				}else if(j == 0 || j == maze[i].length - 1){
					maze[i][j] = 1;
				}else{
					maze[i][j] = 0;
				}
			}
		}
		//Sets a wall, an exit and a mice looking for exit (mice starts from maze[4][3])
		maze[3][1] = 1;
		maze[3][2] = 1;
		maze[0][1] = 0;//The exit tile


		//Check if it's set right. Yes, it is.
		System.out.println("==============The maze==============");
		for(int i = 0; i < maze.length; i++){
			for(int j = 0; j < maze[i].length; j++){
				System.out.print(maze[i][j] + " ");
			}
			System.out.println();
		}

		Mice mice = new Mice();
		mice.findWay(maze, 4, 3);
		System.out.println("==============Path found !==============");
		for(int i = 0; i < maze.length; i++){
			for(int j = 0; j < maze[i].length; j++){
				System.out.print(maze[i][j] + " ");
			}
			System.out.println();
		}

	}
}
class Mice{
	//0: untouched accessible tile, 1: wall, 2: touched accessible tile, 3: touched & death end
	//Strategy for the mice to find the exit: 
	// try these directions in order for every move: up, right, down, left
	public boolean findWay(int[][] map, int i, int j){
		if(map[0][1] == 2){
			return true;
		}else{
			if(map[i][j] == 0){
				map[i][j] = 2;//Assume this is in the right path
				if(findWay(map, i - 1, j)){
					return true;
				}else if(findWay(map, i, j + 1)){
					return true;
				}else if(findWay(map, i + 1, j)){
					return true;
				}else if(findWay(map, i, j - 1)){
					return true;
				}else{
					map[i][j] = 3;
					return false;
				}

			}else{//map[i][j] = 1,2,3
				return false;
			}
		}
	}
}

