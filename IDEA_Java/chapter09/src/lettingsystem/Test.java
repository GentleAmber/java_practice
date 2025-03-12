package lettingsystem;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type in something without space: ");
        String a = scanner.nextLine();
        System.out.println("Type in something else: ");
        String  b = scanner.nextLine();

        System.out.println("You've just typed: " + a + " " + b);

    }
}
