package homework;

public class Homework04 {
    //Implement employee salary calculation and printing functionality through inheritance.
    public static void main(String[] args) {
        Employee jack_ma = new Manager("Jack Ma", 4000, 20);
        Employee jun_zhou = new commonEmployee("Jun Zhou", 1200, 25);
        Employee jack_turnipseed = new Employee("Jack Turnipseed", 1800, 20);

        jack_ma.printSalary();
        jun_zhou.printSalary();
        jack_turnipseed.printSalary();
    }
}

class Employee{
    private String name;
    private double salaryDaily;
    private int workingDays;

    public void printSalary() {
        System.out.println("For an employee, monthly salary is: " +
                getSalaryDaily() * getWorkingDays());
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
    public void printSalary() {
        System.out.println("For a common employee, monthly salary is: " +
                "\ndaily salary * working days * grade\n" + getSalaryDaily() *
                getWorkingDays() * this.grade);
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
    public void printSalary() {
        System.out.println("For a manager, monthly salary is: " +
                "\n1000 + daily salary * working days * grade\n" + (1000 + getSalaryDaily() *
                getWorkingDays() * this.grade));
    }
}