package im_client;

import im_client.service.ManageClientConnectServerThread;
import im_client.service.UserClientService;
import im_server.service.ManageServerConnectClientThread;

import java.nio.file.InvalidPathException;
import java.util.HashSet;
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
                        // Go into the secondary menu
                        while (loop) {
                            System.out.println("======= Welcome, " + userId + " =======");
                            System.out.println("\t\t 1 Display online user list");
                            System.out.println("\t\t 2 Message all online users");
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
                                case "2" :// Message everyone
                                    System.out.println("Enter the content (one line) you want to send: ");
                                    Scanner contentScanner2 = new Scanner(System.in);
                                    String content2 = contentScanner2.nextLine();
                                    userClientService.messageAll(content2);
                                    try {
                                        Thread.sleep(500);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }

                                    break;
                                case "3" :// Message someone
                                    // First get a list of online users
                                    userClientService.requestOnlineUserList();
                                    try {
                                        Thread.sleep(500);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }

                                    System.out.print("Enter the id of the online user you want to message: ");
                                    String receiverId = scanner.next();
                                    // Prevent the user from entering his own id
                                    if (receiverId.equals(userId)) {
                                        System.out.println("Cannot send message to your self.");
                                    } else {
                                        System.out.println("Enter the content (one line) you want to send: ");
                                        Scanner contentScanner = new Scanner(System.in);
                                        String content = contentScanner.nextLine();
                                        userClientService.messageUser(receiverId, content);
                                        try {
                                            Thread.sleep(500);
                                        } catch (InterruptedException e) {
                                            e.printStackTrace();
                                        }
                                    }

                                    break;
                                case "4" :// Send file(s)
                                    userClientService.requestOnlineUserList();
                                    try {
                                        Thread.sleep(500);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }

                                    System.out.print("Enter the id of the online user you want to message: ");
                                    String receiverIdFile = scanner.next();

                                    // Prevent the user from entering his own id
                                    if (receiverIdFile.equals(userId)) {
                                        System.out.println("Cannot send message to your self.");
                                    } else {
                                        Scanner pathScanner = new Scanner(System.in);
                                        String path = null;
                                        String targetPath = null;
                                        try {
                                            System.out.print("Enter the file path (format: d:\\xxx.jpg): ");
                                            path = pathScanner.nextLine();
                                            System.out.print("Enter the target path on the receiver's pc (format: d:\\xxx.jpg): ");
                                            targetPath = pathScanner.nextLine();
                                        } catch (InvalidPathException e) {
                                            e.printStackTrace();
                                        }

                                        if (targetPath != null && path != null) {
                                            userClientService.sendFile(receiverIdFile, path, targetPath);
                                            try {
                                                Thread.sleep(500);
                                            } catch (InterruptedException e) {
                                                e.printStackTrace();
                                            }
                                        } else {
                                            System.out.println("Error. Please try again.");
                                        }
                                    }

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
