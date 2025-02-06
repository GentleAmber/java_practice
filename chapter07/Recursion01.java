public class Recursion01{
	public static void main(String[] args){
	
	T t1 = new T();
	t1.test(4);//print:n=2,n=3,n=4
	}
}

class T {
	public void test(int n){
		if(n > 2){
			test(n - 1);
		}
		System.out.println("n= " + n);
	}
}