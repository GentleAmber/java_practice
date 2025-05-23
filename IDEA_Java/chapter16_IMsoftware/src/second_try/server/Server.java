package second_try.server;

import second_try.common.Message;
import second_try.common.MessageType;
import second_try.common.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.util.HashMap;


public class Server {
    private ServerSocket ss;
    private HashMap<String, String> userInfo = new HashMap<>();
    private boolean online = true;

    public Server() throws IOException, ClassNotFoundException {
        ss = new ServerSocket(1997);
        userInfo.put("100", "123456");
        userInfo.put("200", "123456");
        userInfo.put("Hank", "100000");
        userInfo.put("Marie", "100000");
        userInfo.put("Walter", "737737");
        userInfo.put("Skyler", "737737");

        while (online) {
            System.out.println("Server listens on the port 1997...");

            // When connected, verify the user first and return a result to the client
            Socket socket = ss.accept();
            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
            User user = (User) objectInputStream.readObject();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            Message verificationResult = verifyUser(user);
            objectOutputStream.writeObject(verificationResult);

            // If verification succeeds, start a thread to keep this socket
            if (verificationResult.getMsgType().equals(MessageType.VERIFICATION_SUCCESS)) {
                new Thread(new ServerSocketThread(user, socket)).start();
                ServerSocketThreadManager.addConnection(user, socket);
                ServerSocketThreadManager.userLogUpdate(user, LocalDateTime.now(), 1);
                System.out.println(user.getId() + " connects to the server.");
            } else {
                System.out.println(user.getId() + " fails to connect.");
            }
        }
    }

    public Message verifyUser(User user) {
        Message message = new Message();
        if (!userInfo.containsKey(user.getId())) {
            message.setMsgType(MessageType.USER_NOT_EXIST);
        } else if (user.getPwd().equals(userInfo.get(user.getId()))) {
            message.setMsgType(MessageType.VERIFICATION_SUCCESS);
        } else {
            message.setMsgType(MessageType.VERIFICATION_FAIL);
        }

        return message;
    }

    public boolean isOnline() {
        return online;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }
}
