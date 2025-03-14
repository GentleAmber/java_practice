package static_;
class Dog {
    private int id;
    private static int total = 0;
    public static void setTotalPerson(int total) {
        Dog.total = total;
    }
    public static int getTotalPerson() {
        return total;
    }
    public Dog() {
        total++;
        id = total;
    }

    public int getId() {
        return id;
    }
}
public class TestDog {
    public static void main(String[] args) {
        Dog.setTotalPerson(3);
        Dog dog = new Dog();
        System.out.println("Dog's id: " + dog.getId());//4
        System.out.println("Dog's total: " + Dog.getTotalPerson());//4
    }
}
