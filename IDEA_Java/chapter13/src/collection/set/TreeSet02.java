package collection.set;

import java.util.TreeSet;

public class TreeSet02 {
    public static void main(String[] args) {
        TreeSet treeSet = new TreeSet();
        treeSet.add(new Person());
    }
}
class Person implements Comparable{
    String name;

    public Person() {
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
