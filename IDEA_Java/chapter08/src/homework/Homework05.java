package homework;

public class Homework05 {
    public static void main(String[] args) {
        Employee muhammad = new Worker("Muhammad", 100, 30);
        System.out.println("Worker Muhammad's annual salary: " + muhammad.annualSalary());

        Employee jay = new Peasant("Jay", 90, 30);
        System.out.println("Peasant Jay's annual salary: " + jay.annualSalary());

        Employee amy = new Teacher("Amy", 300, 21, 150);
        System.out.println("Teacher Amy's annual salary: " + amy.annualSalary());
    }
}

/*
Employee
    private String name;
    private double salaryDaily;
    private int workingDays;
*/

class Worker extends Employee{
    public Worker() {
    }

    public Worker(String name, double salaryDaily, int workingDays) {
        super(name, salaryDaily, workingDays);
    }
}

class Peasant extends Employee{
    public Peasant() {
    }

    public Peasant(String name, double salaryDaily, int workingDays) {
        super(name, salaryDaily, workingDays);
    }
}

class Teacher extends Employee{
    private double teachingPayment;// yuan/day

    public Teacher(double teachingPayment) {
        this.teachingPayment = teachingPayment;
    }

    public Teacher(String name, double salaryDaily, int workingDays, double teachingPayment) {
        super(name, salaryDaily, workingDays);
        this.teachingPayment = teachingPayment;
    }

    @Override
    public double annualSalary() {
        return super.annualSalary() + getWorkingDays() * teachingPayment;
    }
}

class Scientist extends Employee{
    private double annualBonus;

    public Scientist(double annualBonus) {
        this.annualBonus = annualBonus;
    }

    public Scientist(String name, double salaryDaily, int workingDays, double annualBonus) {
        super(name, salaryDaily, workingDays);
        this.annualBonus = annualBonus;
    }

    @Override
    public double annualSalary() {
        return super.annualSalary() + annualBonus;
    }
}

class Waiter extends Employee{
    public Waiter() {
    }

    public Waiter(String name, double salaryDaily, int workingDays) {
        super(name, salaryDaily, workingDays);
    }
}