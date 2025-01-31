public class ParameterPassingMechanism{
	public static void main(String[] args){
		//When manipulating primitive variables in methods, the original ones stay unchanged,
		//because the methods create new space and copy & paste the values there.
		int a = 10, b = 20;
		PrimitiveVariable pv = new PrimitiveVariable();
		pv.swap(a,b);
		System.out.println("In main, a = " + a + ", b = " + b);

		//When manipulating reference variables in methods, the original ones are also changed,
		//because the parameters passed are addresses.
		int[] arr = {1,2,3,4,5};
		ReferenceVariable rv = new ReferenceVariable();
		System.out.println("The original array is: ");
		rv.printIntArr(arr);
		System.out.println("Array after manipulated in the method: ");
		rv.arrayManipulate(arr);
		rv.printIntArr(arr);
	}
}
class PrimitiveVariable{
	public void swap(int a, int b){
		int temp = a;
		a = b;
		b = temp;
		System.out.println("In PrimitiveVariable, a = " + a + ", b = " + b);
		System.out.println("Swap ended.");
	}
}

class ReferenceVariable{
	public void arrayManipulate(int[] arr){
		arr[0] = 200;
	}
	public void printIntArr(int[] arr){
		for(int i = 0; i < arr.length; i++){
			System.out.print(arr[i] + " ");
		}
	System.out.println();
	}
}