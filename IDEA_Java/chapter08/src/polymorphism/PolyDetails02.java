package polymorphism;

public class PolyDetails02 {
    public static void main(String[] args) {
        Cat k = new Cat("K");
        Object obj = null;

        //Introducing instanceof
        System.out.println("Cat k is class/subclass of Cat: " + (k instanceof Cat));
        System.out.println("Cat k is class/subclass of Animal: " + (k instanceof Animal));
        System.out.println("Object obj is class/subclass of Animal: " + (obj instanceof Animal));

        //instanceof checks the object's dynamic type
        Animal animal = new Cat("Jack");
        System.out.println("==================================");
        System.out.println("animal instanceof Animal: " + (animal instanceof Animal));
        System.out.println("animal instanceof Cat: " + (animal instanceof Cat));
            //if instanceof checks the static type (compile-time type), this should be false.

        //test something else
        float f = 3.4f;
        int i = (int)f;
        System.out.println("==================================");
        System.out.println("float 3.4 to int: " + i);

    }
}
