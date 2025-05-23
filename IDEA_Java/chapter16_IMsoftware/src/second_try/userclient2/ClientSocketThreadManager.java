package second_try.userclient2;

import second_try.common.User;

import java.net.Socket;
import java.util.HashMap;

public class ClientSocketThreadManager {
    public static HashMap<User, Socket> connections = new HashMap<>();
    public static String userLog = "";

    public static void addConnection(User user, Socket socket) {
        connections.put(user, socket);
    }

    public static void removeConnection(User user) {
        connections.remove(user);
    }
}
