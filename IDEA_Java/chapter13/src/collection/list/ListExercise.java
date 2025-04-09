package collection.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListExercise {
    //Add over 10 elements in a Arraylist, insert an element "Amber" at the second place,
    //obtain the 5th element, delete the 6th, amend the 7th, and iterate throught the list.

    public static void main(String[] args) {
        List list = new ArrayList();
        for (int i = 0; i < 11; i++) {
            list.add(2);
        }
        list.add(1, "Amber");
        System.out.println(list.get(4));
        list.remove(5);
        System.out.println(list);
        list.set(6, "The 7th");

        Iterator i = list.iterator();
        while (i.hasNext())
            System.out.print(i.next() + " ");
    }
}
