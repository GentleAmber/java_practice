package first_try.server;

import first_try.common.User;

import java.net.Socket;
import java.util.Collection;
import java.util.HashMap;
import java.util.Scanner;

public class ServerAdmin implements Runnable{
    HashMap<User, Socket> serverConnections = ServerConnectionThreadManager.serverConnections;

    @Override
    public void run() {
        boolean loop = true;
        int choice;
        Scanner scanner = new Scanner(System.in);

        while (loop) {
            mainMenu();
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    ServerConnectionThreadManager.showOnlineUserList();
                    break;
                case 2:
                    String userLog = ServerConnectionThreadManager.userLog;
                    if ("".equals(userLog)) {
                        System.out.println("========================");
                        System.out.println("No user log yet.");
                        System.out.println("========================");
                    } else {
                        System.out.println("========================");
                        System.out.print (ServerConnectionThreadManager.userLog);
                        System.out.println("========================");
                    }
                    break;
                case 3:
                    if (serverConnections.isEmpty()) {
                        System.out.println("No user online. Cannot send message.");
                    } else {
                        System.out.println("Enter the message: ");
                        String broadcastMessage = scanner.nextLine();
                        broadcastMessage(broadcastMessage);
                    }
                    break;
                case 9:

                    break;
                default:
                    System.out.println("Wrong input. Enter again");
            }

        }
    }

    public void mainMenu() {
        System.out.println("=======Instant Messaging System Admin=======");
        System.out.println("        1 Online user list");
        System.out.println("        2 User status log");
        System.out.println("        3 Broadcast message");
        System.out.println("        9 Exit");
        System.out.println("Please enter your choice: ");
    }

    public void broadcastMessage(String broadcastMessage) {
        Collection<Socket> sockets = serverConnections.values();
        for (Socket socket : sockets) {

        }
    }

}
