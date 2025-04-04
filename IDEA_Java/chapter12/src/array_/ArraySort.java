package array_;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

public class ArraySort {
    public static void main(String[] args) {
        int[] arr = {1, -1, 8, 0, 20};
        bubbleSort02(arr, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Integer i1 = (Integer)o1;
                Integer i2 = (Integer)o2;
                return i2 - i1;
            }
        });

        System.out.println(Arrays.toString(arr));
    }

    public static void bubbleSort(int[] arr) {
        for (int i = arr.length - 2; i > 0; i--) {
            for (int j = 0; j <= i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    //Combines bubble sort + customised sort
    public static void bubbleSort02(int[] arr, Comparator c) {
        for (int i = arr.length - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                if (c.compare(arr[j], arr[j + 1]) > 0) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

}
