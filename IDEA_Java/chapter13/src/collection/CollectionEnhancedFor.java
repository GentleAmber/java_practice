package collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CollectionEnhancedFor {
    public static void main(String[] args) {
        Collection col = new ArrayList();
        col.add(new Book("三国演义", "罗贯中", 68.5));
        col.add(new Book("红楼梦", "曹雪芹", 70));
        col.add(new Book("西游记", "吴承恩", 65));

        for (Object book : col) {
            System.out.println(book);
        }
    }
}
