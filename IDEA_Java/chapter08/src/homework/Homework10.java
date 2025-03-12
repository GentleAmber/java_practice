package homework;

import javax.print.Doc;
import java.util.Objects;

public class Homework10 {
    public static void main(String[] args) {
        Doctor a = new Doctor("Nono", 40, "Assistant", 'f', 40000);
        Doctor a1 = new Doctor("Nono", 40, "Assistant", 'f', 40000);
        Doctor b = new Doctor("Nono1", 40, "Assistant", 'f', 40000);

        System.out.println("a equals a1: " + a.equals(a1));
        System.out.println("a equals b: " + a.equals(b));
    }
}

class Doctor{
    private String name;
    private int age;
    private String job;
    private char gender;
    private double sal;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Doctor)) return false;
        Doctor doctor = (Doctor) o;
        return getAge() == doctor.getAge() &&
                getGender() == doctor.getGender() &&
                Double.compare(doctor.getSal(), getSal()) == 0 &&
                getName().equals(doctor.getName()) &&
                getJob().equals(doctor.getJob());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAge(), getJob(), getGender(), getSal());
    }

    public Doctor(String name, int age, String job, char gender, double sal) {
        this.name = name;
        this.age = age;
        this.job = job;
        this.gender = gender;
        this.sal = sal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }
}