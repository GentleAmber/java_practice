package homework;

public class TestAnimal {
    public static void main(String[] args) {
        Animal cat = new Cat();
        Animal dog = new Dog();

        cat.shout();
        dog.shout();
    }
}

abstract class Animal {
    abstract void shout();
}

class Cat extends Animal {
    @Override
    void shout() {
        System.out.println("Cats meow.");
    }
}

class Dog extends Animal {
    @Override
    void shout() {
        System.out.println("Dogs woof.");
    }
}