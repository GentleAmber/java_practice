package im_client.service;

import java.util.HashMap;

public class ManageClientConnectServerThread {
    // key = userId
    private static HashMap<String, ClientConnectServerThread> hm = new HashMap<>();

    public static void addThread(String userId, ClientConnectServerThread thread) {
        hm.put(userId,thread);
    }

    public static ClientConnectServerThread getThread(String userId) {
        return hm.get(userId);
    }

    public static void terminateAllThread() {

    }

}
