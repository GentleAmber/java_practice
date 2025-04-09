package collection.set;

import java.util.HashSet;
import java.util.Set;

public class HashSetDetails {
    public static void main(String[] args) {

        Set set = new HashSet();
        System.out.println("set= " + set);

        set.add("juicy");
        set.add("juicy");
        set.add(new Dog("Tom"));
        set.add(new Dog("Tom"));
        set.add(new String("java"));
        set.add(new String("java"));//Why this command fails? Check source code.


//        System.out.println((new String("java").hashCode()));
//        System.out.println((new String("java").hashCode()));
        System.out.println("set= " + set);

    }
}

class Dog {
    String name;

    public Dog(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                '}';
    }
}
