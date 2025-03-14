package static_;

class Person {
    private int id;
    private static int total = 0;
    public static int getTotalPerson() {
        return total;
    }
    public Person() {
        total++;
        id = total;
    }
}
public class TestPerson {
    public static void main(String[] args) {
        System.out.println("Number of total is: " + Person.getTotalPerson());
        Person person = new Person();
        System.out.println("Number of total is: " + Person.getTotalPerson());

    }
}
