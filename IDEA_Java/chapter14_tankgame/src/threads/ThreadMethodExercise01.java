package threads;

public class ThreadMethodExercise01 {
    public static void main(String[] args) throws InterruptedException {
        /*
        Main thread print "hi" every 1s for 10 times
        When 5 "hi"s get printed, start a sub-thread (implements Runnable) that
        print "hello" every 1s for 10 times, and then exit
        After the sub-thread exits, main continues printing "hi" until it exits
         */

        SubThread sub = new SubThread();
        Thread thread = new Thread(sub);

        for (int i = 0; i < 10; i++) {
            System.out.println("hi" + (i + 1));
            Thread.sleep(1000);
            if (i == 4) {
                thread.start();
                thread.join();
            }
        }

        System.out.println("Main thread is over...");
    }
}
class SubThread implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("hello" + (i + 1));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Sub thread is over...");
    }
}