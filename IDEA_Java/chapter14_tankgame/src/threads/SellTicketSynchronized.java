package threads;

public class SellTicketSynchronized {
    public static void main(String[] args) {
        SellTicket02 sellTicket02 = new SellTicket02();
        Thread sellStation01 = new Thread(sellTicket02);
        Thread sellStation02 = new Thread(sellTicket02);
        Thread sellStation03 = new Thread(sellTicket02);

        sellStation01.start();
        sellStation02.start();
        sellStation03.start();

    }
}

class SellTicket02 implements Runnable {
    private int ticketNum = 70;
    private boolean ifSoldOut = false;

    public synchronized void sell() {
        //At the same time, only at most one thread can execute sell()
        if (ticketNum <= 0) {
            ifSoldOut = true;
            return;
        }

        System.out.println(Thread.currentThread().getName() + " sold 1 ticket. The rest: "
                + (--ticketNum));
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {

        while (true) {
            sell();
            if (ifSoldOut)
                break;
        }
    }
}