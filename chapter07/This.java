public class This{
	public static void main(String[] args){
		Dog d1 = new Dog("Browdie",3);
		d1.info();
	}
}

class Dog{
	String name;
	int age;

	public Dog(String name, int age){
		this.name = name;
		this.age = age;
	}

	public void info(){
		System.out.println(name + "\t" + age);
	}
}