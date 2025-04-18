package threads;

public class SellingTickets {
    public static void main(String[] args) {
        SellTicket01 sellTicket01_1 = new SellTicket01();
        SellTicket01 sellTicket01_2 = new SellTicket01();
        SellTicket01 sellTicket01_3 = new SellTicket01();

        sellTicket01_1.start();
        sellTicket01_2.start();
        sellTicket01_3.start();
    }
}
class SellTicket01 extends Thread {
    private static int ticketNum = 100;

    @Override
    public void run() {
        while (true) {
            if (ticketNum <= 0) {
                System.out.println("All sold out.");
                break;
            }
            //Rest 50 ms
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Station " + Thread.currentThread().getName() + " sold one ticket." +
                    " Tickets left: " + (--ticketNum));
        }
    }
}