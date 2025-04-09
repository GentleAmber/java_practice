package collection.set;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class HashSetIncrement {
    public static void main(String[] args) {
        /*
        HashSet is actually HashMap, the first time upon adding element, the table increments to 16,
        threshold = 16 * 0.75 (loadFactor) = 12
        If there are over or equal to 12 elements in the table, the table increments to twice the size (32)
        threshold = 32 * 0.75 = 24
        And then over and over...
         */

//        Set setIncrementExample = new HashSet();
//        for (int i = 0; i < 100; i++) {
//            setIncrementExample.add(i);
//        }

        /*
        If the size of the table is over 64, and there're more than 8 elements on a
        linked list, the linked list will be treeified.
         */
        Set treeifyExample = new HashSet();
        for (int i = 0; i < 12; i++) {
            treeifyExample.add(new A(i));
        }

    }
}

class A {
    private int n;

    public A(int n) {
        this.n = n;
    }

    @Override
    public int hashCode() {
        return 100;
    }
}