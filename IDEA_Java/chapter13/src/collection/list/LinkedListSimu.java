package collection.list;

import java.util.ArrayList;
import java.util.Iterator;

public class LinkedListSimu {
    public static void main(String[] args) {
        Node tom = new Node("Tom");
        Node jack = new Node("Jack");
        Node sam = new Node("Sam");

        tom.next = jack;
        jack.next = sam;

        sam.pre = jack;
        jack.pre = tom;

        Node first = tom;
        Node last = sam;

        ArrayList arrayList = new ArrayList(3);
        arrayList.add("Tom");
        arrayList.add("Jack");
        arrayList.add("Sam");

        //Delete the element "jack" , and then add two, and then go through the list

        long startTimeForLinked = System.currentTimeMillis();
        tom.next = sam;
        sam.pre = tom;//deleted

        Node node = new Node(10);
        Node node2 = new Node("Over");
        sam.next = node;
        node.next = node2;

        node.pre = sam;
        node2.pre = node;

        last = node2;//added

        while (true) {
            if (first == null) {
                break;
            }
            System.out.println(first);
            first = first.next;
        }

        long endTimeForLinked = System.currentTimeMillis();

        System.out.println("Time cost by linked list: " + (endTimeForLinked - startTimeForLinked));

        System.out.println("==============================");
        long startTimeForArray = System.currentTimeMillis();

        arrayList.remove("Jack");
        arrayList.add(10);
        arrayList.add("Over");

        Iterator obj = arrayList.iterator();
        while (obj.hasNext()) {
            System.out.println(obj.next());
        }

        long endTimeForArray = System.currentTimeMillis();
        System.out.println("Time cost by array list: " + (endTimeForArray - startTimeForArray));

    }
}

class Node {
    Object item;
    Node pre;
    Node next;

    public Node(Object item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "Node{" +
                "item=" + item +
                '}';
    }
}
