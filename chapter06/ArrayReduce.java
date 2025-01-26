import java.util.Scanner;
public class ArrayReduce{
	public static void main(String[] args){
		//Dynamically remove elements from an array (at the rear of the array)
		//There is a array{1,2,3,4,5}. Prompts for the user to decide whether to remove an element
		//User can decide when to stop removing element (y/n)
		int arr[] = {1,2,3,4,5};
		Scanner user = new Scanner(System.in);

		labelLoop:
		do{
			System.out.println("Array status: ");
			for (int i = 0; i < arr.length; i++){
				System.out.print(arr[i] + " ");
			}
			System.out.print("\nDo you want to remove the last element from the array? (y/n)");
			char elementReduce = user.next().charAt(0);
			switch(elementReduce){
			case 'n':
				System.out.println("Understood. Program stopped.");
				break labelLoop;
			case 'y':
				int arrTemp[] = new int[arr.length - 1];
				for (int i = 0; i < arrTemp.length; i++){
					arrTemp[i] = arr[i];
				}
				arr = arrTemp;
				break;
			default:
				System.out.println("Invalid input.");
				break;
			}

		}while(arr.length > 1);
		if (arr.length == 1){
			System.out.println("Array status: ");
			for (int i = 0; i < arr.length; i++){
				System.out.print(arr[i] + " ");
			}
			System.out.println("\nThere is only 1 element in the array. You should stop doing this.");
		}
	}
}