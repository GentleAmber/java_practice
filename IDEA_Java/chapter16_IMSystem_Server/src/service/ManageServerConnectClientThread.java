package service;

import java.util.HashMap;

public class ManageServerConnectClientThread {
    private static HashMap<String, ServerConnectClientThread> hm = new HashMap<>();

    public static void addThread(String userId, ServerConnectClientThread thread) {
        hm.put(userId,thread);
    }

    public static ServerConnectClientThread getThread(String userId) {
        return hm.get(userId);
    }
}
