package threads;

public class Thread01 {
    public static void main(String[] args) {

        Cat cat = new Cat();
        //Start cat thread. Cannot use "run()" or it's treated as a sole method, so cat
        //thread won't be run with main thread at the same time.
        cat.start();
        int time = 0;
        for (int i = 0; i < 50; i++) {
            System.out.println("Main thread running" + (++time)
                    + "-" + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}

class Cat extends Thread {
    @Override
    public void run() {
        int time = 0;
        while (true) {
            System.out.println("Meow" + (++time) + "-" +
                    Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (time == 80)
                break;
        }
    }
}