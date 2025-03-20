package interface_;

public class InterfaceClassDifference {
    public static void main(String[] args) {
        Macaque macaque = new Macaque("Hola",5);
        macaque.fly();
        Tool tool = new Tool();
        tool.everyoneFlies(macaque);
        tool.everyoneFlies(new Bird("Gigi"));

    }
}

interface AdvancedFunction {
    void fly();
}

class Monkey {
    String name;
    int age;

    void climb() {
        System.out.println(name + " climbs the tree.");
    }

    void eat() {
        System.out.println(name + " eats some food.");
    }

    void pickBanana() {
        System.out.println(name + " picks bananas from the trees.");
    }

    public Monkey(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

class Macaque extends Monkey implements AdvancedFunction{
    void swim(int hr) {
        System.out.println("Macaque " + name + " has swam for " + hr + " hours.");
    }

    @Override
    public void fly() {
        System.out.println("Macaque " + name + " is flying now!");
    }

    public Macaque(String name, int age) {
        super(name, age);
    }
}

class Bird implements AdvancedFunction{
    String name;
    @Override
    public void fly() {
        System.out.println("Bird " + name + " flies in the sky.");
    }

    public Bird(String name) {
        this.name = name;
    }
}

class Tool {
    void everyoneFlies(AdvancedFunction advancedFunction) {
        advancedFunction.fly();
    }
}