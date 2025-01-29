public class TwoDimentionalArrayExercise01{
	public static void main(String[] args){
		//int arr[][]={{4,6},{1,4,5,7},{-2}}. Calculate the sum of all the elements in this array
		int arr[][]={{4,6},{1,4,5,7},{-2}};
		int sum = 0;

		for(int i = 0; i < arr.length; i++){
			for(int j = 0; j < arr[i].length; j++){
				System.out.print(arr[i][j] + " ");
				sum += arr[i][j];
			}
			System.out.println();
		}
		System.out.println("The sum is: " + sum + ".");
	}
}