package array_;
import java.util.Comparator;

public class ArrayExercise {
    public static void main(String[] args) {
        Book[] books = new Book[5];
        books[0] = new Book("Three Man In A Boat", 9.99);
        books[1] = new Book("The Housemaid's Secret", 7.95);
        books[2] = new Book("We Solve Murders", 6.78);
        books[3] = new Book("Small Things Like These", 6.99);
        books[4] = new Book("Guinness World Records 2025", 11.99);

        bubbleSort(books, true, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                double priceDiff = ((Book)o1).getPrice() - ((Book)o2).getPrice();
                if (priceDiff > 0) {
                    return 1;
                } else if (priceDiff == 0) {
                    return 0;
                } else {
                    return -1;
                }
            }
        });

        System.out.println("Price From big to small: ");
        Book.arrayToString(books);

        bubbleSort(books, false, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                double priceDiff = ((Book)o1).getPrice() - ((Book)o2).getPrice();
                if (priceDiff > 0) {
                    return 1;
                } else if (priceDiff == 0) {
                    return 0;
                } else {
                    return -1;
                }
            }
        });

        System.out.println("====================================");
        System.out.println("Price from small to big: ");
        Book.arrayToString(books);

        stringLengthSort(books, true, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                int lengthOf1stBook = ((Book)o1).getName().length();
                int lengthOf2ndBook = ((Book)o2).getName().length();
                return lengthOf1stBook - lengthOf2ndBook;
            }
        });

        System.out.println("====================================");
        System.out.println("Name from long to short: ");
        Book.arrayToString(books);


    }

    public static void stringLengthSort(Book[] books, boolean longToShort, Comparator c) {
        bubbleSort(books, longToShort, c);
    }

    public static void bubbleSort(Book[] books, boolean para, Comparator c) {
        for (int i = books.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (para) {//11.99, 9.99, 10, ...
                    if (c.compare(books[j], books[j + 1]) < 0) {
                        Book temp = books[j];
                        books[j] = books[j + 1];
                        books[j + 1] = temp;
                    }
                } else {//from small to big
                    if (c.compare(books[j], books[j + 1]) > 0) {
                        Book temp = books[j];
                        books[j] = books[j + 1];
                        books[j + 1] = temp;
                    }
                }
            }
        }
    }
}

class Book {
    private String name;
    private double price;

    public static void arrayToString(Book[] books) {
        for (int i = 0; i < books.length; i++) {
            System.out.println(books[i].toString());
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Book(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", price=" + price;
    }
}