public class VariableParameters{
	//The actual arguments for a variable number of parameters can be zero or more.
	//The actual arguments for a variable number of parameters can be an array.
	//The actual arguments for... are actually arrays.
	//Variable parameters can be put together with usual paras in a method, put variable ones should
		//stay at the end.
	//A parameter list can have at most one variable parameter
		//e.g. public int sum(int... nums, double... nums) is wrong
	public static void main(String[] args){
		Method m = new Method();
		
		int sum = m.sum(1,2,3,4,5);
		System.out.println("Sum of 1 to 5: " + sum);

		int[] arr = {10,10,20};
		System.out.println("Sum of arr: " + m.sum(arr));

		m.paraMix("This is the sum of 1.5 to 3.5: ", 1.5,2.5,3.5);
	}
}

class Method{
	public int sum(int... nums){
		//nums is an array
		int sum = 0;
		for(int i = 0; i < nums.length; i++){
			sum += nums[i];
		}
		return sum;
	}

	public void paraMix(String str, double... nums){
		double sum = 0;
		for(int i = 0; i < nums.length; i++){
			sum += nums[i];
		}

		System.out.println(str + sum);
	}
}