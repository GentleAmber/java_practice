public class TwoDimentionalArrayExercise02{
	public static void main(String[] args){
		/*Print a Yanghui Triangle of 10 rows
		1
		1 1
		1 2 1
		1 3 3 1
		1 4 6 4 1
		...
		*/
		int[][] yanghui = new int[10][];
		for(int i = 0; i < yanghui.length; i++){
			yanghui[i] = new int[i + 1];
			for(int j = 0; j < i + 1; j++){
				if(j == 0 || j == i){
					yanghui[i][j] = 1;
				}else{
					yanghui[i][j] = yanghui[i - 1][j] + yanghui[i - 1][j - 1];
				}
			}
		}

		for(int i = 0; i < yanghui.length; i++){
			for(int j = 0; j < yanghui[i].length; j++){
				System.out.print(yanghui[i][j] + " ");
			}
			System.out.println();
		}
	}
}