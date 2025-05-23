package second_try.userclient;

import second_try.common.User;

import java.io.IOException;
import java.util.Scanner;

public class ClientFrame {
    public static void main() {
        boolean loop = true;

        // Main menu
        while (loop) {
            System.out.println("--------Instant Messaging System--------");
            System.out.println("        1 Log in");
            System.out.println("        9 Exit");
            System.out.print("Please enter your choice:");
            Scanner scanner = new Scanner(System.in);

            switch (scanner.nextInt()) {
                case 1:
                    Scanner strScanner = new Scanner(System.in);
                    System.out.print("Please enter your user ID:");
                    String id = strScanner.nextLine();
                    System.out.print("Please enter your password:");
                    String pwd = strScanner.nextLine();
                    try {
                        new Client(new User(id, pwd));
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                    loop = false;
                    break;
                case 9:
                    System.out.println("Exit successfully.");
                    return;
                default:
                    System.out.println("Wrong input. Please enter again.");
            }
        }
    }
}
