package homework;

public class Homework11 {
    public static void main(String[] args) {
        HW11Person pS = new HW11Student();//upcasting
        pS.run();
        pS.eat();

        System.out.println("---------Downcasting---------");
        HW11Student tempS = (HW11Student)pS;
        tempS.run();
        tempS.eat();
        tempS.study();

    }
}

class HW11Person {
    public void eat() {
        System.out.println("Person is eating.");
    }

    public void run() {
        System.out.println("Person is running.");
    }
}

class HW11Student extends HW11Person{
    @Override
    public void run() {
        System.out.println("Student is running.");
    }

    public void study() {
        System.out.println("Student is studying.");
    }
}
