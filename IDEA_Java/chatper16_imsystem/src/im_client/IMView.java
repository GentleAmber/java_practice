package im_client;

import im_client.service.UserClientService;

import java.util.Scanner;

public class IMView {

    private boolean loop = true;
    private String key = "";
    private UserClientService userClientService = new UserClientService();

    public static void main(String[] args) {
        new IMView().mainMenu();
        System.out.println("Exits successfully. See you again.");
    }

    public void mainMenu() {
        while (loop) {

            System.out.println("======== Instant Message System ========");
            System.out.println("\t\t 1 Log in");
            System.out.println("\t\t 9 Exit");
            System.out.print("Please enter your choice: ");

            Scanner scanner = new Scanner(System.in);
            key = scanner.next();

            switch (key) {
                case "1":
                    System.out.print("Please enter user id:");
                    String userId = scanner.next();
                    System.out.print("Please enter password:");
                    String pwd = scanner.next();

                    if (userClientService.verifyLogin(userId, pwd)) {
                        System.out.println("======= Welcome, " + userId + " =======");
                        // Go into the secondary menu
                        while (loop) {
                            System.out.println("\t\t 1 Display online user list");
                            System.out.println("\t\t 2 Message all");
                            System.out.println("\t\t 3 Message someone");
                            System.out.println("\t\t 4 Send file(s)");
                            System.out.println("\t\t 9 Exit");
                            System.out.print("Please enter your choice: ");
                            key = scanner.next();
                            switch (key) {
                                case "1" :
                                    userClientService.requestOnlineUserList();
                                    try {
                                        Thread.sleep(1000);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                    break;
                                case "2" :
                                    break;
                                case "3" :
                                    break;
                                case "4" :
                                    break;
                                case "9" :
                                    loop = false;
                                    userClientService.userLogOut();
                                    break;
                                default :
                                    System.out.println("Wrong input. Please enter again.");

                            }
                        }
                    } else {
                        System.out.println("Wrong id or password. Fail to log in.");
                    }
                    break;
                case "9":
                    loop = false;
                    break;
                default:
                    System.out.println("Wrong input. Please enter again.");
            }
        }
    }
}
