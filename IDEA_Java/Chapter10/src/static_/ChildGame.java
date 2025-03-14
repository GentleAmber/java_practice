package static_;

public class ChildGame {
    public static void main(String[] args) {
        Child jack = new Child("Jack");
        Child muhammad = new Child("Muhammad");
        Child jacy = new Child("Jacy");

        jack.join();
        jack.count++;

        muhammad.join();
        muhammad.count++;

        jacy.join();
        jack.count++;

        System.out.println("Shared count = " + Child.count);
    }

}

class Child {
    private String name;
    public static int count = 0;//It's shared by all objects of Child class

    public Child(String name) {
        this.name = name;
    }

    public void join() {
        System.out.println(name + " has joined the game.");
    }
}
