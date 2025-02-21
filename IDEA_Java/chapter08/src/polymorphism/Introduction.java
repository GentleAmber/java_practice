package polymorphism;

public class Introduction {
    //Master feeds his animals different food
    //Traditional coding: create many classes for animals and food, and a class for master.
        //Then create methods in master class to feed a certain animal certain food.
    //This makes coding very redundant
    //But with polymorphic object this can be tackled with.
    public static void main(String[] args) {
        Master master = new Master();
        Animal doggy = new Dog("doggy");
        Animal kitty = new Cat("kitty");
        Dog mordie = new Dog("Mordie");
        Food bone = new Bone("bone");
        Food fish = new Fish("fish");
        master.feed(doggy,bone);
        master.feed(kitty,fish);
        master.feed(mordie,bone);

        mordie.bark();
        ((Dog)doggy).bark();//Notice the difference.
    }
}
class Master{
    public void feed(Animal animal, Food food){
        System.out.println("Master feeds " + animal.getName() + " " + food.getName() + ".");
    }
}

class Food{
    private String name;

    public Food(String name){
        this.name = name;
    }
    public Food(){

    }

    public String getName(){
        return name;
    }
}
class Bone extends Food{
    public Bone(String name){
        super(name);
    }
}
class Fish extends Food{
    public Fish(String name){
        super(name);
    }
}

class Animal{
//    public void say(){
//        System.out.println("Animal is saying...");
//    }
    private String name;
    public String getName(){
        return name;
    }

    public Animal(String name){
        this.name = name;
    }
    public Animal(){ }

    public void sleep(){
        System.out.println("Animal is sleeping.");
    }
    public void eat(){
        System.out.println("Animal is eating.");
    }
}
class Dog extends Animal{
//    @Override
//    public void say() {
//        System.out.println("Dog is saying...");
//    }
    public Dog(String name){
        super(name);
    }
    public void bark(){
        System.out.println(getName() + " barks: worf worf!");
    }
}
class Cat extends Animal{
    public Cat(String name){
        super(name);
    }
    public void catchMouse(){
        System.out.println(getName() + " catches a mice!");
    }

    @Override
    public void eat() {
        System.out.println("Cat " + getName() + " is eating.");
    }
    //    @Override
//    public void say() {
//        System.out.println("Cat is saying...");
//    }
}
