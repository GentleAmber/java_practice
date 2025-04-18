package threads;

public class ThreadExit {
    public static void main(String[] args) {
        T t = new T();
        t.start();

        //Let t run for 10 sec and then terminate it.
        try {
            Thread.sleep(10 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t.setLoop(false);
    }
}

class T extends Thread {
    private int count = 0;
    private boolean loop = true;

    @Override
    public void run() {
        while (loop) {
            System.out.println("T run() is running..." + (++count));
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("T run() is terminated");
    }

    public boolean isLoop() {
        return loop;
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }
}