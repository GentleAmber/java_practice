package collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DogIterator {
    public static void main(String[] args) {
        List lst = new ArrayList();
        lst.add(new Dog("Browdie", 10));
        lst.add(new Dog("Orange", 3));
        lst.add(new Dog("Yume", 6));

        Iterator i = lst.iterator();
        while (i.hasNext())
            System.out.println(i.next());
    }
}

class Dog {
    String name;
    int age;

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}