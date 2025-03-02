package polymorphism.polyparameters;

import javax.tools.Tool;

public class PolyParameters {
    public static void main(String[] args) {
        Employee[] empList = new Employee[4];

        empList[0] = new Employee("Amy Leonard", 3300);
        empList[1] = new Manager("Jack Ma", 100000, 400000);
        empList[2] = new CommonEmployee("Ben Turnipseed", 5000);
        empList[3] = new CommonEmployee("Unimportant", 1000);

        PolyParameters pol = new PolyParameters();

        for (int i = 0; i < empList.length; i++) {
            System.out.println(empList[i].getName() + "'s annual salary: "
             + pol.showEmpAnnual(empList[i]));
            pol.testWork(empList[i]);
            System.out.println();
        }
    }

    public double showEmpAnnual(Employee e) {
        return e.getAnnual();
    }

    public void testWork(Employee e){
        if(e instanceof CommonEmployee){
            ((CommonEmployee) e).work();
        }else if (e instanceof Manager){
            ((Manager) e).manage();
        }else{
            System.out.println("...");
        }
    }
}

class Employee {
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getAnnual() {
        return 12 * salary;
    }
}

class CommonEmployee extends Employee {
    public CommonEmployee(String name, double salary) {
        super(name, salary);
    }

    public void work() {
        System.out.println("Common employee " + getName() + " is working.");
    }

    @Override
    public double getAnnual() {
        return getSalary() * 11.5;//Minus a forfeit for not working hard enough
    }
}

class Manager extends Employee {
    private double bonus;

    public Manager(String name, double salary, double bonus) {
        super(name, salary);
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public void manage() {
        System.out.println("Manager " + getName() + " is managing employees.");
    }

    @Override
    public double getAnnual() {
        return super.getAnnual() + bonus;
    }
}