package static_.singleton;

public class LazySingleton {
    public static void main(String[] args) {
//        System.out.println(Cat.n2);
        Cat cat = Cat.getInstance();
        System.out.println(cat.getName());

    }
}
class Cat {
    private String name;
    public static int n2 = 200;
    private static Cat cat;

    private Cat(String name) {
        this.name = name;
        System.out.println("Constructor is called.");
    }

    public static Cat getInstance() {
        if (cat == null) {
            cat = new Cat("Kitty");
        }
        return cat;
    }

    public String getName() {
        return name;
    }
}