package abstract_;

public class AbstractDetails {
    public static void main(String[] args) {
        Animal a = new Dog();
        a.roar();
        System.out.println(a.n);
    }
}

abstract class Animal {
    public int n = 100;
    public static String name;
    public abstract void eat();

    public Animal() {
    }
    public static void roar() {
        System.out.println("Woahhhhhhhhh");
    }
}

class Dog extends Animal {
    public int n = 200;
    @Override
    public void eat() {
        System.out.println("Dog eats bones.");
    }
    public static void roar() {
        System.out.println("Wof wof");
    }
}

class Cat extends Animal{
    @Override
    public void eat() {
        System.out.println("Cat eats fish.");
    }
}