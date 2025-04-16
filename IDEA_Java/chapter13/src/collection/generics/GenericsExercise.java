package collection.generics;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class GenericsExercise {
    public static void main(String[] args) {
        HashMap<String, Student> students = new HashMap<>();
        Student jack = new Student(1001, "Jack");
        Student tom = new Student(1011, "Tom");
        Student marie = new Student(1012, "Marie");

        students.put(jack.name, jack);
        students.put(tom.name, tom);
        students.put(marie.name, marie);

        System.out.println(students);
        System.out.println("====================");

        Set<String> studentNames = students.keySet();
        Iterator<String> iterator = studentNames.iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            System.out.println(key + "-" + students.get(key));
        }

        System.out.println("====================");



    }
}

class Student {
    int id;
    String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}