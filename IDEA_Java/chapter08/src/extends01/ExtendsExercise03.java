package extends01;

public class ExtendsExercise03 {
    /*
    Write a Computer class with attributes such as CPU, memory, hard drive, etc.,
    and a getDetails method to return detailed information about the Computer.

    Write a PC subclass that inherits from the Computer class and adds
    a unique attribute: brand.

    Write a NotePad subclass that inherits from the Computer class and adds
    a unique attribute: colour.

    In the main method, create PC and NotePad objects,
    assign values to the unique attributes as well as the attributes inherited
    from the Computer class, and use the method to print the information.
    */
    public static void main(String[] args) {
        PC legion = new PC("AMD Ryzen 7 5800H with Radeon Graphics", 128,
                "00342-30503-04319-AAOEM", 64, "Legion");
        NotePad green = new NotePad("AMD Ryzen 7 5800H with Radeon Graphics", 128,
                "00342-30503-04319-AAOEM", 64, "Green");
        legion.getPCDetails();
        green.getNPDetails();
    }
}

class Computer{
    String cpu;
    int ram;
    String hardDrive;
    int systemType;//64 or 32

    public Computer(String cpu, int ram, String hardDrive, int systemType) {
        this.cpu = cpu;
        this.ram = ram;
        this.hardDrive = hardDrive;
        this.systemType = systemType;
    }

    public Computer() {
    }

    public void getDetails(){
        System.out.println("========Computer Details========");
        System.out.println("CPU: " + cpu + "\nRAM: " + ram + "\nHard Drive: " +
                hardDrive + "\nSystem Type: " + systemType);
    }
}

class PC extends Computer{
    String brand;

    public PC(String cpu, int ram, String hardDrive, int systemType, String brand) {
        super(cpu, ram, hardDrive, systemType);
        this.brand = brand;
    }

    public PC(String brand) {
        this.brand = brand;
    }

    public PC(String cpu, int ram, String hardDrive, int systemType) {
        super(cpu, ram, hardDrive, systemType);
    }

    public PC() {
    }

    public void getPCDetails(){
        getDetails();
        System.out.println("Brand: " + brand);
    }
}

class NotePad extends Computer{
    String colour;

    public NotePad(String cpu, int ram, String hardDrive, int systemType, String colour) {
        super(cpu, ram, hardDrive, systemType);
        this.colour = colour;
    }

    public NotePad(String colour) {
        this.colour = colour;
    }

    public NotePad(String cpu, int ram, String hardDrive, int systemType) {
        super(cpu, ram, hardDrive, systemType);
    }

    public NotePad() {
    }

    public void getNPDetails(){
        getDetails();
        System.out.println("Colour: " + colour);
    }
}
