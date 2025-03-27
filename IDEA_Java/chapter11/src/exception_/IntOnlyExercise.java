package exception_;

import java.util.Scanner;

public class IntOnlyExercise {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type in an integer.");
        int num;
        while (true) {
            try {
                num = Integer.parseInt(scanner.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("This is not an integer. Please type in an integer.");
            }
        }
        System.out.println("The integer you typed in is: " + num);
    }

}

