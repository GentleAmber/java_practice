package im_client.service;

import im_common.Message;
import im_common.MessageType;
import im_common.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.HashMap;
import java.util.HashSet;

// This class has the following functions:
// 1) user login verification, 2) user registration
public class UserClientService {

    private User user = new User();
    private Socket socket;

    public boolean verifyLogin(String userId, String pwd) {
        boolean result = false;
        user.setId(userId);
        user.setPwd(pwd);

        try {
            // Send the user instance to server and reads a message from the server
            socket = new Socket(InetAddress.getLocalHost(), 1997);
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(user);

            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            Message ms = (Message) ois.readObject();

            // If verification succeeds, start a thread to keep the socket for continuing communication
            if (ms.getMessageType().equals(MessageType.LOGIN_SUCCEED)) {
                ClientConnectServerThread ccst = new ClientConnectServerThread(socket);
                new Thread(ccst).start();
                // For further expansion, put the thread/socket in a collection to manage
                ManageClientConnectServerThread.addThread(userId, ccst);
                result = true;

            } else {
                socket.close();
            }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return result;
    }


    public void requestOnlineUserList() {

        Message message = new Message();
        message.setMessageType(MessageType.GET_ONLINE_USER);

        // Get socket from the manager class instead of from within this class
        ClientConnectServerThread thread = ManageClientConnectServerThread.getThread(user.getId());
        Socket socket = thread.getSocket();

        try {
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void userLogOut() {

        Message message = new Message();
        message.setMessageType(MessageType.CLIENT_EXIT);
        message.setSender(user.getId());

        // Inform the server about the log out
        try {
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(message);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Close the client and any thread that's running
        System.exit(0);

    }

    // Return true if message sent to a valid user, else return false.
    public void messageUser(String userId, String content) {

        Message message = new Message();
        message.setSender(user.getId());
        message.setReceiver(userId);
        message.setContent(content);
        message.setMessageType(MessageType.COMM_MES);

        try {
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(message);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public HashSet<String> copyStringHashSet(HashSet<String> hs) {
        HashSet<String> copyHs = new HashSet<>();
        if (hs.isEmpty()) {
            return copyHs;
        }

        if (hs == null) {
            return null;
        }

        for (String element : hs) {
            copyHs.add(element);
        }

        return copyHs;

    }
}
