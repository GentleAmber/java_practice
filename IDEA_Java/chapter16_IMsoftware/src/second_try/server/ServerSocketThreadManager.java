package second_try.server;

import second_try.common.User;

import java.net.Socket;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Set;

public class ServerSocketThreadManager {
    public static HashMap<User, Socket> connections = new HashMap<>();
    public static String userLog = "";

    public static void addConnection(User user, Socket socket) {
        connections.put(user, socket);
    }

    public static void removeConnection(User user) {
        connections.remove(user);
    }

    public static String showOnlineUserList() {
        Set<User> users = connections.keySet();
        String result = null;
        if (users.isEmpty()) {
            result = "========================\nNo user is online.\n========================";
        } else {
            result = "========================\n";
            for (User user : users) {
                result += (user + "\n");
            }
            result += "========================\n";
        }
        return result;
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
