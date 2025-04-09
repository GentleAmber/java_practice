package collection.set;

import java.util.HashSet;
import java.util.Set;

public class SetMethods {
    public static void main(String[] args) {
        Set set = new HashSet();
        set.add(null);
        set.add("Jack");
        set.add("John");
        set.add("John");
        set.add("Amy");

        for (Object o : set) {
            System.out.println(o);
        }
    }
}
