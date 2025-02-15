public class ConstructorExercise{
	public static void main(String[] args){
		Person p1 = new Person();
		Person p2 = new Person("Mike", 35);

		System.out.println(p1.name + "\t" + p1.age);
		System.out.println(p2.name + "\t" + p2.age);
		
	}
}

class Person{
	//Add two constructors in Person. 1st one: no parameters. default value of age: 18
		//2nd one: accepts parameters for name and age.
	String name;
	int age;

	public Person(String pName, int pAge){
		System.out.println("Constructor (full) is called.");
		name = pName;
		age = pAge;
	}

	public Person(){
		//Overload
		System.out.println("Constructor (default) is called.");
		age = 18;
	}
}
