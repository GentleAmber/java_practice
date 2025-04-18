package threads;

public class Interrupt {
    public static void main(String[] args) {
        TT tt = new TT();
        tt.start();

        //After 2 sec, interrupt the thread.
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        tt.interrupt();

    }
}

class TT extends Thread {
    int count = 0;
    @Override
    public void run() {
        while (true) {
            System.out.println("TT run()" + (++count));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Sleep is interrupted.");
//                e.printStackTrace();
            }

            if (count == 20) {
                break;
            }
        }
    }
}

