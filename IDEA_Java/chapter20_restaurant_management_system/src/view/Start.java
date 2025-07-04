package view;

import utils.IOUtils;
import utils.MySQLUtils;

public class Start {
    public static void main(String[] args) {
        System.out.println("Welcome to the restaurant management system.");
        System.out.println("Anytime you want to exit the system, enter \"exit\".");
        System.out.println("\nPlease enter your account number and password to log in: ");

        System.out.print("Account: ");
        String account = IOUtils.takeStringWithExitCheck();
        System.out.print("Password: ");
        String password = IOUtils.takeStringWithExitCheck();

        Object ifAdmin = MySQLUtils.loginVerification(account, password); // return null if no such record

        if (ifAdmin == null) {
            System.out.println("Wrong account or password");

        } else if (ifAdmin instanceof Boolean){
            Menus menus = new Menus();
            // Show admin and non-admin different menus

            if ((Boolean) ifAdmin) {
                char selection = ' ';

                while (selection != '6') {
                    System.out.println("Welcome, admin " + account + "!");
                    System.out.println("===========Admin Management Interface===========");
                    System.out.println("\t\t1 Human Resource Management");
                    System.out.println("\t\t2 Login Account Management");
                    System.out.println("\t\t3 Modify Restaurant Menu");
                    System.out.println("\t\t4 Statistics");
                    System.out.println("\t\t5 Cost Registration");
                    System.out.println("\t\t6 Exit");
                    System.out.println("================================================");
                    System.out.print("Please enter your selection: ");

                    selection = IOUtils.takeCharacter();

                    switch (selection) {
                        case '1':
                            menus.humanResourceManage();
                            break;

                        case '2':
                            menus.loginManage();
                            break;

                        case '3':
                            menus.modifyRestaurantMenu();
                            break;

                        case '4':
                            menus.statistics();// not developed
                            break;

                        case '5':
                            menus.costControl();// not developed
                            break;

                        case '6':
                            System.out.println("Bye.");
                            break;

                        default:
                            System.out.println("Wrong input. Please enter again.");
                    }
                }

            } else {
                char selection = ' ';

                while (selection != '7') {
                    System.out.println("Welcome, user " + account + "!");
                    System.out.println("===========POS system===========");
                    System.out.println("\t\t1 Show tables");
                    System.out.println("\t\t2 Reserve table");
                    System.out.println("\t\t3 Show reservation");
                    System.out.println("\t\t4 Take order");
                    System.out.println("\t\t5 Show menu");
                    System.out.println("\t\t6 Checkout");
                    System.out.println("\t\t7 Exit");
                    System.out.println("================================================");
                    System.out.print("Please enter your selection: ");

                    selection = IOUtils.takeCharacter();

                    switch (selection) {
                        case '1':
                            menus.showTable();
                            break;

                        case '2':
                            menus.reserve();
                            break;

                        case '3':
                            menus.showReservations();

                        case '4':
                            menus.takeOrder();
                            break;

                        case '5':
                            menus.showMenu();
                            break;

                        case '6':
                            menus.checkOut();// not developed
                            break;

                        case '7':
                            System.out.println("Bye.");
                            break;

                        default:
                            System.out.println("Wrong input. Please enter again.");
                    }
                }
            }
        } else {
            System.out.println("Unknown error");
        }
    }
}
