package static_;

public class ClassIntialisedTime {
    public static void main(String[] args) {
        Cat.meow();
    }
}

class Animal {
    static {
        System.out.println("Class Animal is initialised.");
    }
}

class Cat extends Animal{
    public static void meow() {
        System.out.println("Static method meow() is called.");
    }

    static {
        System.out.println("Class Cat is initialised.");
    }
}