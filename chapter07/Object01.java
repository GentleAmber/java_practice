/*
Question: Ms Zhang has a cat, named Snow, aged 3, white coloured.
Ms Lian has another cat, named Flower, aged 7, mixed coloured.
Store the aforementioned information. If the user types in one of the names,
prompts all the information of that cat. If none of the cats is named that,
prompts "Cat not found".

The methods introduced till now cannot solve this kind of problems. So Object-oriented 
is introduced here.
*/
class Cat{
	String name;
	int age;
	String colour;
	String owner;
}
public class Object01{
	public static void main(String[] args){
		//Instantiate an object
		Cat cat1 = new Cat();
		cat1.name = "Snow";
		cat1.age = 3;
		cat1.colour = "White";
		cat1.owner = "Ms Zhang";

		Cat cat2 = new Cat();
		cat2.name = "Flower";
		cat2.age = 7;
		cat2.colour = "Mixed";
		cat2.owner = "Ms Lian";

		//Access an object's properties
		System.out.println("Cat1: " + cat1.name + " " + cat1.age + " " + 
			cat1.colour + " " + cat1.owner + " ");
		System.out.println("Cat2: " + cat2.name + " " + cat2.age + " " + 
			cat2.colour + " " + cat2.owner + " ");
	}
}