package map;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class MapExercise01_EmployeeManagement {
    public static void main(String[] args) {
        HashMap employees = new HashMap();
        Employee jack = new Employee("Jack", 33000, "e00493");
        Employee marie = new Employee("Marie", 36000, "e00410");
        Employee skyler = new Employee("Skyler", 35000, "e00394");

        employees.put(jack.getId(), jack);
        employees.put(marie.getId(), marie);
        employees.put(skyler.getId(), skyler);

        System.out.println("Employees whose salary is over 34000 (method 1): ");
        Set entrySet = employees.entrySet();
        for (Object entry :
                entrySet) {
            Map.Entry m = (Map.Entry) entry;
            Employee e = (Employee) m.getValue();
            if (e.getSal() > 34000)
                System.out.println(m.getKey() + "-" + e);
        }

        System.out.println("======================");
        System.out.println("Employees whose salary is over 34000 (method 2): ");
        Set set = employees.keySet();
        for (Object id : set) {
            Employee e = (Employee) employees.get(id);
            if (e.getSal() > 34000)
                System.out.println(id + "-" + employees.get(id));
        }
    }
}

class Employee {
    private String name;
    private double sal;
    private String id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Employee(String name, double sal, String id) {
        this.name = name;
        this.sal = sal;
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return Objects.equals(name, employee.name) &&
                Objects.equals(id, employee.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", sal=" + sal +
                '}';
    }
}