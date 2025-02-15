public class Homework07{
	public static void main(String[] args){
		Dog d1 = new Dog();
	}
}

class Dog{
	String name;
	String colour;
	int age;

	public Dog(String name, String colour, int age){
		this.name = name; 
		this.colour = colour;
		this.age = age;
	}

	public Dog(){

	}
	
	public void show(){
		System.out.println(this.name + "\t" + this.colour + "\t" + this.age);
	}
}