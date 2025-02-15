public class Homework02{
	public static void main(String[] args){
	A02 tool = new A02();
	String[] arr = {"Jack","Mark","Amanda"};
	String target1 = "Jack";
	String target2 = "Null";
	String target3 = "Amanda";

	System.out.println(tool.find(arr,target1));//0
	System.out.println(tool.find(arr,target3));//2
	System.out.println(tool.find(arr,target2));//-1


	}
}

class A02{
	public int find(String[] arr, String target){
		for(int i = 0; i < arr.length; i++){
			if(target.equals(arr[i]))
				return i;
		}
		return -1;
	}
}