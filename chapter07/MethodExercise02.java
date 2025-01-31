public class MethodExercise02{
	public static void main(String[] args){
		int arr[][] = new int[5][];
		for(int i = 0; i < arr.length; i++){
			arr[i] = new int[i + 1];
			for(int j = 0; j < arr[i].length; j ++){
				arr[i][j] = i + 1;
			}
		}

		MyTools tool = new MyTools();
		tool.printTwoDimentionalArray(arr);

		//=======================
		System.out.println("=====================================");

		Person originalPerson = new Person();
		originalPerson.name = "Jack";
		originalPerson.age = 18;
		originalPerson.weight = 50.4;
		originalPerson.gender = 'F';
		Person copiedPerson = originalPerson.copyPerson(originalPerson);

		System.out.println("The original person's information: ");
		originalPerson.printInfo(originalPerson);
		System.out.println("The copied person's information: ");
		copiedPerson.printInfo(copiedPerson);

		//Amend copied person's information.
		copiedPerson.age = 30;
		copiedPerson.name = "Amenda";
		System.out.println("===========After amendment===========");
		System.out.println("The original person's information: ");
		originalPerson.printInfo(originalPerson);
		System.out.println("The copied person's information: ");
		copiedPerson.printInfo(copiedPerson);


	}
}

class MyTools{
	//Write a method that can print data in a 2-dimention array.
	//This is tested to be working fine.
	public void printTwoDimentionalArray(int[][] arr){
		for(int i = 0; i < arr.length; i++){
			for(int j = 0; j < arr[i].length; j++){
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}

class Person{
	//Write a method that copies a Person object. Return the copied object.
	//Note that the new object and the original one should be two independent objects with same fields.
	String name;
	int age;
	double weight;
	char gender;

	public Person copyPerson(Person p){
		Person clonedPerson = new Person();
		clonedPerson.name = p.name;
		clonedPerson.age = p.age;
		clonedPerson.weight = p.weight;
		clonedPerson.gender = p.gender;
		return clonedPerson;
	}

	public void printInfo(Person P){
		System.out.println("Name: " + name + "\nAge: " + age + "\nWeight: " 
			+ weight + "\nGender: " + gender);
	}

}