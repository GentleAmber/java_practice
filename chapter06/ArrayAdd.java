import java.util.Scanner;
public class ArrayAdd{
	public static void main(String[] args){
		//Dynamically add elements into an array (at the rear of the array)
		//The original array is a static one int[] arr = {1,2,3}
		//User can decide when to stop adding element (y/n)

		int[] arr = {1,2,3};
		Scanner user = new Scanner(System.in);

		while(true){
			System.out.print("Would you like to add an element? (y/n)");
			char addElement = user.next().charAt(0);
			if(addElement != 'n' && addElement != 'y'){
				System.out.println("Not a valid answer.");
				continue;
			}else if(addElement == 'n'){
				System.out.println("Finish adding elements!");
				break;
			}else{//addElement == 'y'
				System.out.print("Type an integer to add: ");
				int element = user.nextInt();
				int[] arrTemp = new int[arr.length + 1];
				for(int i = 0; i < arr.length; i++){
					arrTemp[i] = arr[i];
				}
				arrTemp[arr.length] = element;
				arr = arrTemp;
			}
		}
		System.out.print("Elements in the new array are as followed: ");
		for (int i = 0; i < arr.length; i++){
			System.out.print(arr[i] + " ");
		}
	}
}