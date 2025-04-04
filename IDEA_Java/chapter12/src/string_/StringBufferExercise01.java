package string_;

import java.util.Scanner;

public class StringBufferExercise01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the product name: ");
        String name = scanner.next();
        System.out.println("Please enter the product price: ");
        double priceNum = scanner.nextDouble();
        String priceStr = String.valueOf(priceNum);

        StringBuffer priceSB = new StringBuffer(priceStr);
        int indexOfDot = priceSB.indexOf(".");

        if (indexOfDot > 3) {
            for (int i = indexOfDot - 3; i > 0; i -= 3) {
                priceSB.insert(i ,',');
            }
        }

        System.out.println("Item\tPrice");
        System.out.println(name + "\t" + priceSB);



    }

}
