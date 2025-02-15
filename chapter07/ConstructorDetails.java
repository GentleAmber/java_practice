public class ConstructorDetails{
	public static void main(String[] args){
		/*
		
		1. Constructors can be overloaded.
		2. If no constructor is defined, the system will generate a default
			constructor without any parameter, e.g. Person(){}. Use javap to decompile
		3. Once defining your own constructor, the default one is overwritten, which
			means it's not available, unless manually write down the default one.
		*/
		Person p1 = new Person("Smith",80);
		Person p2 = new Person("Jack");
		System.out.println(p1.name + "\t" + p1.age);
		System.out.println(p2.name + "\t" + p2.age);

		Dog d1 = new Dog("Fluffee");
		Dog d2 = new Dog("Star",3);
		System.out.println(d1.dogName + "\t" + d1.dogAge);
		System.out.println(d2.dogName + "\t" + d2.dogAge);

		Dog d3 = new Dog();
		System.out.println(d3.dogName + "\t" + d3.dogAge);

	}
}

class Person{
	String name;
	int age;

	public Person(String pName, int pAge){
		System.out.println("Constructor (full) is called.");
		name = pName;
		age = pAge;
	}

	public Person(String pName){
		//Overload
		System.out.println("Constructor (name only) is called.");
		name = pName;
	}
}

class DefaultConstructor{

	/*
	DefaultConstructor(){
	
	}
	*/
}

class Dog{
	String dogName;
	int dogAge;
	
	Dog(String dName, int dAge){
		dogName = dName;
		dogAge = dAge;
	}
	Dog(String dName){
		dogName = dName;
	}
	Dog(){

	}
}
