package homework;

import java.util.HashSet;
import java.util.Objects;

public class Homework04_CodeComprehension {
    public static void main(String[] args) {
        HashSet set = new HashSet();
        Person p1 = new Person(1001, "AA");
        Person p2 = new Person(1002, "BB");
        set.add(p1);
        set.add(p2);

        p1.name = "CC";
        set.remove(p1);

        System.out.println(set);//Only print p2's info

        set.add(new Person(1001,"CC"));
        System.out.println("==================");
        System.out.println(set);//Print 1001&CC and p2's info
        set.add(new Person(1001,"AA"));
        System.out.println("==================");
        System.out.println(set);//Print 1001&CC, 1001&AA and p2's info



    }
}

class Person {
    int id;
    String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return id == person.id &&
                Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}