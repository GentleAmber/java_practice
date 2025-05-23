package first_try.client;

import first_try.common.User;

import java.net.Socket;
import java.util.HashMap;

public class ClientConnectionThreadManager {
    public static final HashMap<User, Socket> clientConnections = new HashMap<>();

    public static void addConnection(User user, Socket socket) {
        clientConnections.put(user, socket);
    }

    public static void removeConnection(User user) {
        clientConnections.remove(user);
    }
}
