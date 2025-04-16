package collection.generics;

import java.util.ArrayList;

public class Generics01 {
    public static void main(String[] args) {
        ArrayList<Dog> dogs = new ArrayList<>();
        dogs.add(new Dog("Browdie", 9));
//        dogs.add(2); //This won't do.
    }
}
class Dog {
    String name;
    int age;

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }
}