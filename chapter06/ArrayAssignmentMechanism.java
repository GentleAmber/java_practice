public class ArrayAssignmentMechanism{
	public static void main(String[] args){
		//Assign value to primitive type
		int n1 = 10;
		int n2 = n1;//n2 copies the value of n1.

		n2 = 80;
		System.out.println("n1=" + n1);//The value of n1 is not affected.
		System.out.println("n2=" + n2);

		//By default, pass by reference is applied to array. It's the addresses 
		//that's been assigned.
		int[] arr1 = {1,2,3};
		int[] arr2 = arr1;

		arr2[0] = 5;
		System.out.print("arr1= ");
		for (int i = 0; i < arr1.length; i++){
			System.out.print(arr1[i] + " ");
		}
	}
}