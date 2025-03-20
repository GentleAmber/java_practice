package interface_;

public class InterfacePolymorphism02 {
    public static void main(String[] args) {
        USB[] electronics = new USB[5];
        electronics[0] = new Cellphone();
        electronics[1] = new ECamera();
        electronics[2] = new ECamera();
        electronics[3] = new Cellphone();
        electronics[4] = new Cellphone();

        for (int i = 0; i < 5; i++) {
            if (electronics[i] instanceof Cellphone) {
                System.out.print("ID: " + (i + 1) + " : ");
                ((Cellphone)electronics[i]).call("110");
            }
        }

    }
}

interface USB {
    void start();
    void stop();
}
class ECamera implements USB{
    @Override
    public void start() {
        System.out.println("E-camera starts.");
    }

    @Override
    public void stop() {
        System.out.println("E-camera stops.");
    }
}
class Cellphone implements USB{

    public void call(String number) {
        System.out.println("Cellphone is calling " + number + "...");
    }

    @Override
    public void start() {
        System.out.println("Cellphone starts.");
    }

    @Override
    public void stop() {
        System.out.println("Cellphone stops.");
    }
}