package threads;

public class JoinMethod {
    public static void main(String[] args) throws InterruptedException {
        Sub sub = new Sub();
        sub.start();
        for (int i = 0; i < 10; i++) {
            System.out.println("Main " + (i + 1));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (i == 4) {
                sub.join();
            }
        }

    }
}

class Sub extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Sub thread " + (i + 1));
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}