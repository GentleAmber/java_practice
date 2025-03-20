package abstract_;

import com.sun.java.swing.plaf.windows.WindowsInternalFrameTitlePane;

public class TestTemplate {
    //Different classes do different jobs and need to get the time for finishing each job.
    public static void main(String[] args) {
        AA aa = new AA();
        aa.calculateTime();

        BB bb = new BB();
        bb.calculateTime();
    }
}

abstract class Template {
    public void calculateTime() {
        long start = System.currentTimeMillis();
        job();
        long end = System.currentTimeMillis();
        System.out.println("Job takes " + (end - start) + " ms to finish.");
    }

    public abstract void job();
}

class AA extends Template{
    @Override
    public void job() {
        int num = 0;
        for (int i = 0; i < 10000000; i++) {
            num += i;
        }
    }
}

class BB extends Template{
    @Override
    public void job() {
        int num = 1;
        for (int i = 0; i < 5000000; i++) {
            num *= i;
        }
    }
}