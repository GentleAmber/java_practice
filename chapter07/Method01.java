public class Method01{
	public static void main(String[] args){
		Person p1 = new Person();
		p1.cal02(10);
		System.out.println("Sum of 22 and 40 is: " + 
			p1.getSum(22,40));
		int res[] = p1.getSumAndSub(30,12);
		System.out.println("Sum of 30 and 12 is: " + 
			res[0] + "\nSub of 30 and 12 is: " + res[1]);
	}
}
class Person{
	//Fields
	String name;
	int age;
	//Methods
	//speak method prints "I'm a good person."
	public void speak(){
		//public: The method is public
		//void: No return value
		//speak: Name of this method
		//(): No parameters
		System.out.println("I'm a good person.");
	}
	
	//cal01 method calculates 1+2+...+1000
	public void cal01(){
		int res = 0;
		for(int i = 0; i <= 1000; i++){
			res += i;
		}
		System.out.println("Sum of 1,2...1000 is: " + res);
	}

	//cal02 receives a number n, and calculates 1+2+...+n
	public void cal02(int n){
		int res = 0;
		for(int i = 0; i <= n; i++){
			res += i;
		}
		System.out.println("Sum of 1,2..." + n + " is: " + res);
	}

	//getSum receives two numbers and return their sum.
	public int getSum(int n1, int n2){
		int sum = n1 + n2;
		return sum;
	}
	public int[] getSumAndSub(int n1, int n2){
		int[] arr = new int[2];
		arr[0] = n1 + n2;
		arr[1] = n1 - n2;
		return arr;
	}
}