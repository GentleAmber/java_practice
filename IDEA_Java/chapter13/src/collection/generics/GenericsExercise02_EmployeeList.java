package collection.generics;

import java.util.ArrayList;
import java.util.Comparator;

public class GenericsExercise02_EmployeeList {
    public static void main(String[] args) {
        Employee jack = new Employee("Jack", 10200, new MyDate(1993, 12, 5));
        Employee tom = new Employee("Jack", 13000, new MyDate(1993, 12, 4));
        Employee marie = new Employee("Marie", 15000, new MyDate(1990, 3, 6));

        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(jack);
        employees.add(tom);
        employees.add(marie);

        employees.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                String o1Name = o1.getName();
                String o2Name = o2.getName();
                if (o1Name.compareTo(o2Name) == 0) {
                    MyDate o1B = o1.getBirthday();
                    MyDate o2B = o2.getBirthday();
                    if (o1B.getYear() == o2B.getYear()) {
                        if (o1B.getMonth() == o2B.getMonth()) {
                            if (o1B.getDay() == o2B.getDay()) {
                                return 0;
                            } else
                                return o1B.getDay() - o2B.getDay();
                        } else
                            return o1B.getMonth() - o2B.getMonth();
                    } else
                        return o1B.getYear() - o2B.getYear();

                }
                return o1Name.compareTo(o2Name);
            }
        });

        for (Employee em:
             employees) {
            System.out.println(em);
        }
    }
}

class Employee {
    private String name;
    private double sal;
    private MyDate birthday;

    public Employee() {
    }

    @Override
    public String toString() {
        return "Employee{" + name + ", " + sal +
                ", " + birthday + '}';
    }

    public Employee(String name, double sal, MyDate birthday) {
        this.name = name;
        this.sal = sal;
        this.birthday = birthday;
    }

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

    public MyDate getBirthday() {
        return birthday;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }


}

class MyDate {
    private int year;
    private int month;
    private int day;


    @Override
    public String toString() {
        return String.format("%d-%02d-%02d", year, month, day);
    }

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }
}