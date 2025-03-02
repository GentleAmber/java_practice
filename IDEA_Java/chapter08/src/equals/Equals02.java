package equals;
//Rewrite equals method
public class Equals02 {
    //Determine if every fields of two objects of class Person are equal
    public static void main(String[] args) {
        Person person = new Person("Jack", 25, 'f');
        Person person1 = new Person("Jack", 25, 'f');

        System.out.println(person == person1);
        System.out.println(person.equals(person1));

    }
}

class Person{
    private String name;
    private int age;
    private char gender;

    public Person(String name, int age, char gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public boolean equals(Object anObject) {
        if (this == anObject) {
            return true;
        }else if (anObject instanceof Person){
            Person anotherPerson = (Person)anObject;
            return this.name.equals(anotherPerson.name) && this.age == anotherPerson.age
                    && this.gender == anotherPerson.gender;
        }

        return false;
    }
}
