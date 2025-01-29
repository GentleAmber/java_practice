public class TwoDimentionalArray02{
	public static void main(String[] args){
		//Static initialization:
		int[][] arr = {{1,1,1},{8,5,9},{100}};
		//If the last bracket is removed since there's only 1 element in that 1-dimentional array,
		//there will be error because it's just a primitive data type (int), not the array type (reference data).

		for(int i = 0; i < arr.length; i++){
			for(int j = 0; j < arr[i].length; j++){
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}