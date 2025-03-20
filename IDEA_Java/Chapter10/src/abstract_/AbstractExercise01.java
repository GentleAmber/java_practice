package abstract_;

public class AbstractExercise01 {
    public static void main(String[] args) {
        Manager jack = new Manager("Jack", "000598", 56000, 4000);
        CommonEmployee jane = new CommonEmployee("Jane", "201607", 31000);

        jack.work();
        jane.work();
    }
}

abstract class Employee {
    private String name;
    private String id;
    private double salary;

    public Employee(String name, String id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    public abstract void work();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}

class Manager extends Employee{
    private double bonus;

    public Manager(String name, String id, double salary, double bonus) {
        super(name, id, salary);
        this.bonus = bonus;
    }

    @Override
    public void work() {
        System.out.println("Manager " + getName() + " is working.");
    }
}

class CommonEmployee extends Employee {

    public CommonEmployee(String name, String id, double salary) {
        super(name, id, salary);
    }

    @Override
    public void work() {
        System.out.println("Common employee " + getName() + "is working.");
    }
}
