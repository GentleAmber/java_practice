package im_server.service;

import im_common.Message;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ManageStoredMessage {
    private static final ConcurrentHashMap<String, ArrayList<Message>> storedMessages = new ConcurrentHashMap<>();

    public static void storeMessage(String receiver, Message message) {
        if (!storedMessages.containsKey(receiver)) {
            storedMessages.put(receiver, new ArrayList<>());
        }

        storedMessages.get(receiver).add(message);
    }

    public static void tryDeliverStoredMessages(String receiver) {
        // If there hasn't been any message stored under this receiver, do nothing.
        if (!storedMessages.containsKey(receiver)) {
            return;
        }
        // If there isn't any stored message under this receiver for now, do nothing.
        if (storedMessages.get(receiver).isEmpty()) {
            return;
        }
        // Else, deliver his/her messages to her
        try {
            ObjectOutputStream oos = new ObjectOutputStream(ManageServerConnectClientThread.getThread(receiver).getSocket().getOutputStream());
            for (Message ms : storedMessages.get(receiver)) {
                oos.writeObject(ms);
                oos.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Delete these messages that have been delivered.
        storedMessages.get(receiver).clear();

//        for (Map.Entry<String, ArrayList<Message>> entry : storedMessages.entrySet()) {
//            // Check if the receiver is online. If he is, deliver him all the messages
//            if (ManageServerConnectClientThread.ifUserOnline(entry.getKey())) {
//
//                if (!entry.getValue().isEmpty()) {
//
//                    try {
//                        ObjectOutputStream oos = new ObjectOutputStream(ManageServerConnectClientThread.getThread(entry.getKey()).getSocket().getOutputStream());
//                        for (Message ms : entry.getValue()) {
//                            oos.writeObject(ms);
//                            oos.flush();
//                        }
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                    // Delete these messages that have been delivered.
//                    entry.getValue().clear();
//                }
//            }
//        }
    }
}
