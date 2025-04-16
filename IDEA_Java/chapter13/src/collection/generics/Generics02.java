package collection.generics;

public class Generics02 {
    public static void main(String[] args) {
        Person<Integer> p1 = new Person<>(1);
        p1.showClass();
        Person<String> p2 = new Person<>("Jack");
        p2.showClass();
    }
}

class Person<E> {
    E s;

    Person(E s) {
        this.s = s;
    }

    void showClass() {
        System.out.println(s.getClass());
    }
}