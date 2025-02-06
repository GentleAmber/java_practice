import java.util.Arrays;
public class TowerOfHanoi{
	public static void main(String[] args){
		//Given five discs (can be changed) and three spikes (fixed)
		//Use a variable to store the number of discs
		int discNum = 4;
		int[][] spikes = new int[3][discNum];

		//Initialisation
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < discNum; j++){
				if(i == 0){
					spikes[i][j] = j + 1;
				}else{
					spikes[i][j] = 0;
				}
			}
		}
		HanoiMethods tool = new HanoiMethods();
		tool.status(spikes);
		tool.abstractMove(spikes, discNum, 0, 1, 2);
		System.out.println("Total steps: " + tool.steps + ". After moving: ");
		tool.status(spikes);


	}
}
class HanoiMethods{
	int steps = 0;
	public void status(int[][] spikes){
		for(int j = 0; j < spikes[0].length; j++){
			for(int i = 0; i < 3; i++){
				System.out.print(spikes[i][j] + "\t");
			}
		System.out.println();
		}
	}

	public void moveAmongSpikes(int[][] spikes, int start, int end, boolean ifPrint){
		
		int hold = 0;
		steps++;//Every time a move happens, step+1

		for(int i = 0; i < spikes[start].length; i++){
			if(spikes[start][i] != 0){
				hold = spikes[start][i];
				spikes[start][i] = 0;
				break;
			}
		}

		for(int j = 0; j < spikes[end].length; j++){
			if(spikes[end][j] != 0 && j > 0){
				spikes[end][j - 1] = hold;
				break;
			}else if(spikes[end][j] != 0 && j == 0){
				System.out.println("Error: the [" + end + "] spike is full!");
				return;
			}else if(j == spikes[end].length - 1){//If [end] is an empty spike
				spikes[end][j] = hold;
			}
		}

		if(ifPrint){
			System.out.println("===========Step " + steps + "===========");
			status(spikes);
		}
	}

	public void abstractMove(int[][] spikes, int discNum, int start, int through, int end){
		//Key to solve the problem
		boolean ifPrint = true;
		if(discNum == 1){
			moveAmongSpikes(spikes, start, end, ifPrint);
		}else{
			abstractMove(spikes, discNum - 1, start, end, through);//Move the top N-1 discs to [1] through [2]
			moveAmongSpikes(spikes, start, end, ifPrint);//Then move the Nth disc to [2]
			abstractMove(spikes, discNum - 1, through, start, end);//Move the N-1 discs to [2] through [0]
		}
	}

	/*Algorithm for Tower of Hanoi with N discs solutions:
	- Before [0] is emptied:
	1. First move is always to put a disc from spikes[0] to another spike.
	2. When there is an empty spike between spikes[1] and [2], always continue moving
	 disc from spikes[0].
		While moving disc from spikes[0]:
		2.1 If by puting the disc on the occupied spike, a new tower is formed, then do it.
		2.2 If not, then put the disc on the empty spike.
	3. When both spikes[1] and [2] are occupied, always try to solve a tower with the discs
	 on them.
	- After [0] is emptied:
	0. Now spikes[1] and [2]'s status should be: a N-1 tower on one, and the Nth disc
	 on the other. 
	1. Keep the Nth disc unmoved, and use the empty spike to form a tower of: 1 disc, 2 discs,
	 3, 4... until the (N-1)th disc is exposed and can be moved onto the Nth disc.

	*/



	// public void solve(int[][] spikes){//VOID or WHAT?
	// 	//Objection: put all the discs from spikes[0] to spikes[2] in an ascending order
	// 	//Use an array to record the status of spikes[0]
	// 	int[] obj = spikes[0];
	// 	if(Arrays.equals(spikes[2],obj) || Arrays.equals(spikes[1],obj)){
	// 		return;
	// 	}else{
	// 		//Move the top disc of spikes[0] to another spike where applicable, and then
	// 		//use solve() method for the rest. (Recursion)
	// 		for(int i = 0; i < spikes[0].length; i++){
	// 			if(spikes[0][i] != 0){//Top disc found)
	// 				int grab = spikes[0][i];//Grab the top disc with your hand
	// 				//Examine the right spike to drop it.
	// 			}
	// 		}
	// 	}
	// }
}