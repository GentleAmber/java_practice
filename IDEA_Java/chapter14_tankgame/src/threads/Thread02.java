package threads;

public class Thread02 {
    public static void main(String[] args) {
        Thread thread = new Thread(new Dog());
        thread.start();//Cannot write "dog.start()", there's no start method in Runnable interface

    }
}

class Dog implements Runnable {

    @Override
    public void run() {
        int count = 0;
        while (true) {
            System.out.println("Woof" + (++count) + "-" + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (count == 10)
                break;
        }
    }
}