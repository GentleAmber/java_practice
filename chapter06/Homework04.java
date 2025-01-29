import java.util.Scanner;
public class Homework04{
	public static void main(String[] args){
		//There is an ascending array {10,12,45,90}.
		//Require that if an element is inserted, this array is still ascending.
		//e.g. inserting 23, and the array will be {10,12,23,45,90}.

		int[] arr = {10,12,45,90};
		int[] arrTemp = new int[arr.length + 1];
		Scanner sc = new Scanner(System.in);

		System.out.println("Please insert a number in the array: ");
		int inserted = sc.nextInt();

		for(int i = 0, j = 0; i < arr.length; i++, j++){
			//i is used as pointer in arr, j as pointer in arrTemp
			if(arr[i] > inserted){
				//Compare every element in original array with the inserted number
				//If the inserted is smaller, put the inserted on the according position in arrTemp
				//And move the pointer j right 1 unit, put the current arr[i] here
				arrTemp[j] = inserted;
				j++;
				arrTemp[j] = arr[i];
			}else{
				//Otherwise, just copy the element in arr to arrTemp
				arrTemp[j] = arr[i];
			}
		}
		arr = arrTemp;
		System.out.println("Current array is: ");
		for(int i = 0; i < arr.length; i++){
			System.out.print(arr[i] + " ");
		}
	}
}