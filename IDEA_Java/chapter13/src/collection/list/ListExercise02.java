package collection.list;

import java.util.ArrayList;
import java.util.List;

public class ListExercise02 {
    public static void main(String[] args) {
        List books = new ArrayList();
        books.add(new Book("三国演义", "罗贯中", 68.5));
        books.add(new Book("红楼梦", "曹雪芹", 70));
        books.add(new Book("西游记", "吴承恩", 65));

        priceSort(books);
        for (Object book:
             books) {
            System.out.println(book);
        }
    }

    public static void priceSort(List books) {
        int size = books.size();
        for (int i = size - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                Book b1 = (Book)books.get(j);
                Book b2 = (Book)books.get(j + 1);

                if (b1.price > b2.price) {
                    Book temp = b1;
                    books.set(j, b2);
                    books.set(j + 1, temp);
                }
            }
        }
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
        return "Name: " + name + "\t" + "Price: " + price + "\t" + "Author: " + author;
    }
}