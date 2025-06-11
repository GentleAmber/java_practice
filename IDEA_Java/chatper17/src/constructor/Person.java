package constructor;

public class Person {

    private int age = 10;// private
    public String name = "Jason";// public
    double salary = 1000.1;// default
    protected String surname = "Watson";// protected

    private Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public Person(String name) {
        this.name = name;
    }

    public Person() {}

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", surname='" + surname + '\'' +
                '}';
    }
}
