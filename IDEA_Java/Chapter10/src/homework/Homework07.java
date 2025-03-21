package homework;

public class Homework07 {
    //There is a class Car, with a field temperature, and a inner class Air， which has
    //the function to flow air based on the current temperature.
    //Instantiate cars with different temperatures to see if the flow function works well.

    public static void main(String[] args) {
        Car car1 = new Car(39.9);
        Car car2 = new Car(-10);
        Car car3 = new Car(41.5);

        car1.new Air().flow();
        car2.new Air().flow();
        car3.new Air().flow();
    }

}

class Car {
    public double temperature;
    class Air {
        public void flow() {
            if (temperature >= 40) {
                System.out.println("Sending cool air..." + "Current temperature: " + temperature);
            } else if (temperature <= 0) {
                System.out.println("Sending hot air..." + "Current temperature: " + temperature);
            } else {
                System.out.println("Air conditioning is not working." + " Current temperature: " + temperature);
            }
        }
    }

    public Car(double temperature) {
        this.temperature = temperature;
    }
}