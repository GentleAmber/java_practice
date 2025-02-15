public class ThisDetails{
	public static void main(String[] args){
		/*
		1. this is used to distinguish fields and local variables
		2. this can be used to visit methods (including constructors )and fields in a class
			When calling a method from within a class, there're two ways to do this.
			e.g. Method is called f1
			1st: f1();
			2nd: this.f1();
		3. Syntax to call a constructor: this(parameters).
			Notice! Constructor can only be called in another constructor.
			Notice2! this(parameters); should be written in the first line
		4. this cannot be used outside of the class, but only within the class's methods.
		*/
		T3 t3 = new T3();
		System.out.println(t3.name + "\t" + t3.age);
	}
}
class T3{
	String name;
	int age;

	public T3(){
		this("jack",100);
		System.out.println("T3() constructor is called.");
		
	}

	public T3(String name, int age){
		System.out.println("T3(String name, int age) is called.");
		this.name = name;
		this.age = age;
	}
}
