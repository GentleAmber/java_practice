package threads;

public class ProxySim {
    public static void main(String[] args) {
        ThreadProxy proxy = new ThreadProxy(new Target());
        proxy.start();
    }
}

class ThreadProxy implements Runnable {
    private Runnable target = null;

    @Override
    public void run() {
        if (target != null) {
            System.out.println("Proxy run()");
            target.run();
        }
    }

    public ThreadProxy(Runnable target) {
        this.target = target;
    }

    public void start() {
        System.out.println("Proxy start()");
        start0();//Most important method that achieves multithreading.
    }

    public void start0() {
        System.out.println("Proxy start0()");
        run();
    }
}

class Target implements Runnable{
    @Override
    public void run() {
        int count = 0;
        while (true) {
            System.out.println("Target.run()" + (++count) + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (count == 20) {
                break;
            }
        }
    }
}