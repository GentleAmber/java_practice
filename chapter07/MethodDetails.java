//To call a method within the same class, you can directly call it
//To call a method in a different class, you should use the format of [instance.method]
public class MethodDetails{
	public static void main(String[] args){
		A example = new A();
		example.ok();

	}
}

class A{
	
	public void print(){
		System.out.println("This is print function from class A.");
	}

	public void ok(){
		print();
	}
}