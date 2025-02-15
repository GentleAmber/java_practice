public class VarScopeDetails{
	//1. Fields and local variables can have the same name. When called, 
		//it accesses the nearest variable.
	//2. Local variables cannot have modifiers; while global ones can have.
	public static void main(String[] args){
		Person p = new Person();
		p.say();

	}
}

class Person{
	String name = "Jack";
	public int age = 20;//Modifier: public

	public void say(){
		String name = "King";
		System.out.println("say() name = " + name);
	}
}