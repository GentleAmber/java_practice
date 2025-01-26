public class ArrayCopy{
	public static void main(String[] args){
		//Copy array 1 to array 2. Their data should be independent.
		int arr1[] = {10,20,30};

		//Create a new array arr2.
		int arr2[] = new int[arr1.length];
		for (int i = 0; i < arr1.length; i++){
			arr2[i] = arr1[i];
		}

		arr2[0] = 100;
		
		System.out.println("Array1: ");
		for (int i = 0; i < arr1.length; i++){
			System.out.print(arr1[i] + " ");
		}
		System.out.print("\n");
		System.out.println("Array2: ");
		for (int i = 0; i < arr1.length; i++){
			System.out.print(arr2[i] + " ");
		}
	}
}