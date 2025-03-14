package static_;

public class CodeBlock {
    public static void main(String[] args) {
        new Movie("Tenet");
        new Movie("Titanic", 10.5);
        new Movie("Titanic", 10.5, "15 Sep 2022");

    }

}

class Movie {
    private String name;
    private double price;
    private String time;

    {
        System.out.println("Movie is ready to start.");
        System.out.println("Advertisement time...");
        System.out.println("Movie starts.");
    }

    public Movie(String name) {
        System.out.println("Movie(String name) is called.");
        this.name = name;
    }

    public Movie(String name, double price) {
        System.out.println("Movie(String name, double price) is called.");
        this.name = name;
        this.price = price;
    }

    public Movie(String name, double price, String time) {
        System.out.println("Movie(String name, double price, String time) is called.");
        this.name = name;
        this.price = price;
        this.time = time;
    }

    public Movie() {
        System.out.println("Movie() is called.");
    }
}