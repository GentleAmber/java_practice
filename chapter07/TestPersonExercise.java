/*
Define a class Person, with two fields: name, age. Provide a compareTo method to compare if 
an object is the same to another one. 
Define a class TestPerson to test. If name and age are exactly the same, return true, otherwise
false.
*/
public class TestPersonExercise{
	public static void main(String[] args){
		Person p = new Person("Jack",100);
		TestPerson tp1 = new TestPerson("Jack",100);
		TestPerson tp2 = new TestPerson("Jack",90);

		System.out.println("Compare p to tp1: " + p.compareTo(tp1));
		System.out.println("Compare p to tp2: " + p.compareTo(tp2));
	}
}

class Person{
	String name;
	int age;

	public Person(String name, int age){
		this.name = name;
		this.age = age;
	}

	public boolean compareTo(TestPerson tp){
		if(this.name.equals(tp.name) && this.age == tp.age){
			return true;
		}else{
			return false;
		}
	}
}

class TestPerson{
	String name;
	int age;

	public TestPerson(String name, int age){
		this.name = name;
		this.age = age;
	}
}