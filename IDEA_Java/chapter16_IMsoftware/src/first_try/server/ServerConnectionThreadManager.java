package first_try.server;

import first_try.common.User;

import java.net.Socket;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Set;

public class ServerConnectionThreadManager {
    public static final HashMap<User, Socket> serverConnections = new HashMap<>();
    public static String userLog = "";

    public static void addConnection(User user, Socket socket) {
        serverConnections.put(user, socket);
    }

    public static void removeConnection(User user) {
        serverConnections.remove(user);
    }

    public static void showOnlineUserList() {
        Set<User> users = serverConnections.keySet();
        if (users.isEmpty()) {
            System.out.println("========================");
            System.out.println("No user is online.");
            System.out.println("========================");
        } else {
            System.out.println("========================");
            for (User user : users) {
                System.out.println(user);
            }
            System.out.println("========================");
        }
    }

    // type : 0: log out, 1: log in
    public static void userLogUpdate(User user, LocalDateTime now, int type) {
        switch (type) {
            case 1:
                userLog += (now.toString() + " " +  user + " is online.\n");
                break;
            case 0:
                userLog += (now.toString() + " " +  user + " is offline.\n");
                break;
        }
    }
}
