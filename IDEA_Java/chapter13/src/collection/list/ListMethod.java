package collection.list;

import java.util.ArrayList;
import java.util.List;

public class ListMethod {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("Marie");
        list.add("Skyler");

//        list.add(4, "Jack");
//        System.out.println(list); INDEX cannot be greater than size (length)
        list.add(1, "Jack");

        List list2 = new ArrayList();
        list2.add("Gustavo");
        list2.add("Walt");

        list.addAll(2, list2);

        list.add("Walt");
        System.out.println(list);
        System.out.println(list.indexOf("Walt"));

        list.remove("Walt");
        System.out.println(list);

        list.set(2, "Walt");
        System.out.println(list);

        System.out.println(list.subList(0,2));//[0,2)
    }
}
