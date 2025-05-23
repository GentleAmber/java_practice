package first_try.client;

import first_try.common.User;

import java.util.Scanner;

public class ClientFrame {
    /*
    Entry of the first_try.client programme.
    Either enter user name & password for further verification in the Client class,
    or simply exit.
     */

    public static void main(String[] args) {
        mainMenu();
        Scanner scanner = new Scanner(System.in);
        int choice;
        boolean loop = true;
        choice = scanner.nextInt();

        while (loop) {
            switch (choice) {
                case 1:
                    System.out.println("Please enter your username:");
                    String username = scanner.next();
                    System.out.println("Please enter your password:");
                    String password = scanner.next();
                    loop = false;
                    new Client(new User(username, password));
                    break;
                case 9:
                    loop = false;
                    System.out.println("Exit successfully");
                    break;
                default:
                    System.out.println("Wrong input. Enter again");
            }
        }
    }


    static void mainMenu() {
        System.out.println("--------Instant Messaging System--------");
        System.out.println("        1 Log in");
        System.out.println("        9 Exit");
        System.out.println("Please enter your choice: ");
    }

    static void secondaryMenu(String username) {
        System.out.println("--------Welcome, " + username + "--------");
        System.out.println("        1 Friend list");
        System.out.println("        9 Log out");
        System.out.println("Please enter your choice: ");
    }

    static void friendList() {

    }
}
