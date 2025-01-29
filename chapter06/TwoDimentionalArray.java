public class TwoDimentionalArray{
	public static void main(String[] args){
		//Dynamically create such a 2-dimentional array:
		//1
		//2 2 
		//3 3 3
		//4 4 4 4
		//5 5 5 5 5

		int[][] arr = new int[5][];//Every one-dimentional array has different dynamic length, so the later 
		//bracket should remain blank

		for(int i = 0; i < arr.length; i++){
			arr[i] = new int[i + 1];//Create space for the one-dimentional arrays now

			//Now assign values to the current looped one-dimentional array
			for(int j = 0; j < i + 1; j++){
				arr[i][j] = i + 1;
			}
		}

		//Print the 2-dimentional array
		for(int i = 0; i < arr.length; i++){
			for(int j = 0; j < arr[i].length; j++){
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}