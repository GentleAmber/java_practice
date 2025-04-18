package threads.homework;

import java.util.Scanner;

public class Homework01 {
    public static void main(String[] args) {
        /*
        Start two threads in main. The first thread prints random int within 100,
        until the second receives "Q" from keyboard input.

        Analyse: Daemon thread
         */

        Thread randomNum = new Thread(new RandomNum());
        Thread receiveQ = new Thread(new ReceiveQ());

        randomNum.setDaemon(true);
        randomNum.start();
        receiveQ.start();

    }
}
class RandomNum implements Runnable{
    @Override
    public void run() {
        while (true) {
            System.out.println((int)(Math.random() * 100) + 1);//random() * 100 = [0, 100)
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class ReceiveQ implements Runnable{
    private boolean ifReceivesQ = false;
    private Scanner sc = new Scanner(System.in);
    private char c = ' ';
    @Override
    public void run() {
        while (!(c == 'q' || c == 'Q')) {
            System.out.println("Please type in a char: ");
            c = sc.next().charAt(0);
        }
    }
}