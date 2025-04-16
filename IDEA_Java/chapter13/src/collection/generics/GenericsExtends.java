package collection.generics;

import java.util.ArrayList;
import java.util.List;

public class GenericsExtends {
    public static void main(String[] args) {
        //Can't write like this:
        //ArrayList<Object> list = new ArrayList<String>();

        ArrayList<Object> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        ArrayList<AA> list3 = new ArrayList<>();
        ArrayList<BB> list4 = new ArrayList<>();
        ArrayList<CC> list5 = new ArrayList<>();

        printCollection(list1);
        printCollection(list2);
        printCollection(list3);

        printCollection2(list4);
        printCollection2(list5);

//        printCollection3(list5);
        printCollection3(list4);
        printCollection3(list3);


    }

    public static void printCollection(List<?> c) {
        for (Object o : c) {//Wildcard character matches Object
            System.out.println(o);
        }
    }

    public static void printCollection2(List<? extends BB> c) {
        //Lists of BB or CC can be the parameters
        for (Object o : c) {
            System.out.println(o);
        }
    }

    public static void printCollection3(List<? super BB> c) {
        //Lists of BB or AA can be the parameters
        for (Object o : c) {
            System.out.println(o);
        }
    }
}

class AA {}
class BB extends AA {}
class CC extends BB {}