public class Constructor{
	public static void main(String[] args){
		/*
		Used to initialise an object.
		It is a special method in a class and follows these rules:

		1. Modifier to the constructor can be default/public/protected/private
		2. No return value for constructor
		3. Must have same name to the class
		4. Be called by the system automatically

		Example below: while creating a person object, initialise its name and age.
		*/
		Person p1 = new Person("Smith",80);
		System.out.println(p1.name + "\t" + p1.age);
	}
}

class Person{
	String name;
	int age;

	public Person(String pName, int pAge){
		// Notice: no return value, so no void/int/String... in the title
		System.out.println("Constructor is called.");
		name = pName;
		age = pAge;
	}
}