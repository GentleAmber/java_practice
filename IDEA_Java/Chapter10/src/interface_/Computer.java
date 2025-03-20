package interface_;

class InterfaceTest {
    public static void main(String[] args) {
        Computer computer = new Computer();
        Phone phone = new Phone();
        Camera camera = new Camera();
        computer.work(phone);
        computer.work(camera);
    }
}

class Computer {
    public void work(Usb usb) {
        usb.start();
        usb.stop();
    }
}
