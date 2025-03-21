package homework;

public class Homework06_TangSenTravels {
    public static void main(String[] args) {
        Person tangSen = new Person("Tangsen", VehicleFactory.getHorse());
        //Tang Sen rides a horse by default.
        String road = "stone";
        if (road.equals("river")) {
            tangSen.setVehicle(VehicleFactory.getBoat());
            tangSen.getVehicle().work(tangSen.getName());
        } else {
            tangSen.getVehicle().work(tangSen.getName());
        }

        VehicleFactory.getPlane().work("Tang Sen");
    }
}

interface Vehicles {
    void work(String passenger);
}

class Horse implements Vehicles {
    @Override
    public void work(String passenger) {
        System.out.println(passenger + " is riding a horse.");
    }

    public Horse() {
    }
}

class Boat implements Vehicles {
    @Override
    public void work(String passenger) {
        System.out.println(passenger + " is riding a boat.");
    }

    public Boat() {
    }
}

class Plane implements Vehicles {
    @Override
    public void work(String passenger) {
        System.out.println(passenger + " is taking a plane.");
    }

    public Plane() {
    }
}

class VehicleFactory {
    private static Boat boat = new Boat();
    private static Horse horse = new Horse();
    private static Plane plane = new Plane();

    public static Boat getBoat() {
        return boat;
    }

    public static Horse getHorse() {
        return horse;
    }

    public static Plane getPlane() {
        return plane;
    }
}

class Person {
    private String name;
    private Vehicles vehicle;

    public Person(String name, Vehicles vehicle) {
        this.name = name;
        this.vehicle = vehicle;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Vehicles getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicles vehicle) {
        this.vehicle = vehicle;
    }
}

