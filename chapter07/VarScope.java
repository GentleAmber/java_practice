public class VarScope{
	public static void main(String[] args){
		//Global variable can be used without values assigned to it because it has
			//default value, but local variable has to be assigned values first before being used.
		Cat jessy = new Cat();
		jessy.cry();

		// double weight;
		// System.out.println("Default value of double in main: " + weight);
			//Wrong syntax
		// System.out.println("Test default value of variable in public class in main method: " + test);
	}
}

class Cat{
	//Global variable: also field. The scope of it is the whole class.
	//Can be assigned value when defining.
	int age = 10;
	double weight;
	{
		int calories = 100;
	}


	public void cry(){
		//Local variable: variables other than the fields
		//The scope of it is in the code block that defined it.

		String name = "Jack";
		System.out.println("Use the field age in cry method: " + age);
		System.out.println("Jacy calls out to " + name);
		// System.out.println("I want " + calories + " more calories!");
			//This is wrong syntax because calories is only callable in the code block
			//that it is defined.
		System.out.println("Jacy's weight is: " + weight);
	}
}