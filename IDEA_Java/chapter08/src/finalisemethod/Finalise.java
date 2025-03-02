package finalisemethod;

public class Finalise {
    public static void main(String[] args) {
        Car bmw = new Car("BMW");
        bmw = null;

        Car ford = new Car("Ford");
        System.gc();
    }
}

class Car{
    String name;

    public Car(String name) {
        this.name = name;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Object " + name + " is destroyed.");
    }
}
