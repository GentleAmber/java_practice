package polymorphism;

public class PolyDetails01 {
    //Upcasting and downcasting
    public static void main(String[] args) {
        //Upcasting
        System.out.println("==========Upcasting============");
        Animal animal = new Cat("Yummy kittie");
        //animal.catchMouse(); Wrong syntax because static type is Animal. The object cannot
        //visit unique methods in Cat class.
        animal.eat();//will run eat() in Cat class, because when it runs it's based on
        //the dynamic type, which is cat. (new Cat(...);)
        animal.sleep();

        System.out.println("==========Downcasting============");
        //Downcasting
        Cat cat = (Cat) animal;
        cat.catchMouse();
        cat.eat();
        cat.sleep();
    }




}
