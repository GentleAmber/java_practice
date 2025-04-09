package collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CollectionIterator {
    public static void main(String[] args) {
        Collection col = new ArrayList();
        col.add(new Book("三国演义", "罗贯中", 68.5));
        col.add(new Book("红楼梦", "曹雪芹", 70));
        col.add(new Book("西游记", "吴承恩", 65));

        Iterator iterator = col.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        iterator = col.iterator();
        // After exiting the while loop, the pointer of the iterator points to the last ele
        // If you want to iterate again, the iterator should be reinitialised

    }
}

class Book {
    String name;
    String author;
    double price;

    public Book(String name, String author, double price) {
        this.name = name;
        this.author = author;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                '}';
    }
}
