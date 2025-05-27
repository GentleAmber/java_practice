package im_server.service;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class ManageServerConnectClientThread {
    private static HashMap<String, ServerConnectClientThread> hm = new HashMap<>();

    public static void addThread(String userId, ServerConnectClientThread thread) {
        hm.put(userId,thread);
    }

    public static ServerConnectClientThread getThread(String userId) {
        return hm.get(userId);
    }

    public static String getOnlineUserStringList() {
        String onlineUserList = "";
        if (!hm.keySet().isEmpty()) {
            for (String userId : hm.keySet()) {
                onlineUserList += (userId + " ");
            }
        }

        return onlineUserList;
    }

    public static void closeThread(String userId) {
        ServerConnectClientThread thread = hm.get(userId);
        thread.setLoop(false);

        hm.remove(userId);
        System.out.println(userId + " has logged out.");
    }

    public static boolean ifUserOnline(String userId) {
        return hm.containsKey(userId);
    }

    public static Set<String> onlineUserListExceptSender(String userId) {
        Set<String> onlineUsers = hm.keySet();
        Set<String> copiedOnlineUsers = new HashSet<>();

        for (String user : onlineUsers) {
            copiedOnlineUsers.add(user);
        }

        copiedOnlineUsers.remove(userId);

        if (copiedOnlineUsers == null || copiedOnlineUsers.isEmpty()) {
            return null;
        }

        return copiedOnlineUsers;
    }
}
