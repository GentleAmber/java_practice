package array_;

import java.util.Arrays;

public class ArrayMethods {
    public static void main(String[] args) {
        int[] num = {1, 2, 5, 3};
        Arrays.fill(num, 88);
        System.out.println(Arrays.toString(num));

        int[] num2 = {1, 2, 5, 3};
        System.out.println(Arrays.equals(num, num2));
    }
}
