package homework;

public class Homework04 {
    public static void main(String[] args) {
        double a = 10, b = 40;
        Cellphone cellphone = new Cellphone();
        cellphone.testWork(new Calculator() {
            @Override
            public double work(double a, double b) {
                return a+b;
            }
        },a,b);
    }
}

interface Calculator {
    double work(double a, double b);
}

class Cellphone {

    public void testWork(Calculator cal, double a, double b) {
        double result = cal.work(a,b);
        System.out.println("Result is: " + result);
    }
}