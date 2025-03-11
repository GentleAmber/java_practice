package homework;

public class Homework04 {
    //Implement employee salary calculation and printing functionality through inheritance.
    public static void main(String[] args) {
        Employee jack_ma = new Manager("Jack Ma", 4000, 20);
        Employee jun_zhou = new commonEmployee("Jun Zhou", 1200, 25);
        Employee jack_turnipseed = new Employee("Jack Turnipseed", 1800, 20);

        System.out.println("Jack Ma's annual salary: " + jack_ma.annualSalary());
        System.out.println("Jun zhou's annual salary: " + jun_zhou.annualSalary());
        System.out.println("Jack Turnipseed's annual salary: " + jack_turnipseed.annualSalary());
    }
}

class Employee{
    private String name;
    private double salaryDaily;
    private int workingDays;

    public double annualSalary() {
        return getSalaryDaily() * getWorkingDays();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalaryDaily() {
        return salaryDaily;
    }

    public void setSalaryDaily(double salaryDaily) {
        this.salaryDaily = salaryDaily;
    }

    public int getWorkingDays() {
        return workingDays;
    }

    public void setWorkingDays(int workingDays) {
        this.workingDays = workingDays;
    }

    public Employee() {
    }

    public Employee(String name, double salaryDaily, int workingDays) {
        this.name = name;
        this.salaryDaily = salaryDaily;
        this.workingDays = workingDays;
    }
}

class commonEmployee extends Employee{
    private double grade = 1;

    public commonEmployee() {
    }

    public commonEmployee(String name, double salaryDaily, int workingDays) {
        super(name, salaryDaily, workingDays);
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    @Override
    public double annualSalary() {
        return getSalaryDaily() * getWorkingDays() * this.grade;
    }
}

class Manager extends Employee{
    private double grade = 1.2;

    public Manager() {
    }

    public Manager(String name, double salaryDaily, int workingDays) {
        super(name, salaryDaily, workingDays);
    }

    @Override
    public double annualSalary() {
        return 1000 + getSalaryDaily() * getWorkingDays() * this.grade;
    }
}