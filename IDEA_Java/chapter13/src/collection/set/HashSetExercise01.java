package collection.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;

public class HashSetExercise01 {
    public static void main(String[] args) {
        /*
        Class Employee has two fields: name, age. When the two fields are equal, they
        are considered the same employee and cannot be both added to the hashset.

         */
        HashSet hashSet = new HashSet();
        Employee jack = new Employee("Jack", 31);
        Employee jack2 = new Employee("Jack", 31);
        Employee amy = new Employee("Amy", 28);
        Employee ben = new Employee("Ben", 30);

        System.out.println(hashSet.add(jack));
        System.out.println(hashSet.add(jack2));
        System.out.println(hashSet.add(amy));
        System.out.println(hashSet.add(ben));

        System.out.println("=================Employees added==================");
        Iterator i = hashSet.iterator();
        while (i.hasNext()) {
            System.out.println(i.next());
        }
    }
}

class Employee {
    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return age == employee.age &&
                name.equals(employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}