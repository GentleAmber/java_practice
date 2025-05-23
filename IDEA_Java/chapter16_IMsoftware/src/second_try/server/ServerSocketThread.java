package second_try.server;

import second_try.common.Message;
import second_try.common.MessageType;
import second_try.common.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Map;

public class ServerSocketThread implements Runnable{

    User user;
    Socket socket;
    boolean connected = true;

    public ServerSocketThread(User user, Socket socket) {
        this.user = user;
        this.socket = socket;
    }

    @Override
    public void run() {
        // Initialize i/o streams.
        System.out.println(user.getId() + "'s server socket thread is established.");
        ObjectInputStream objectInputStream = null;
        ObjectOutputStream objectOutputStream = null;
        Message received = null;
        Message sent = null;

        // While connected, always read client's msg first, and then respond.
        while (connected) {
            // Read
            try {
                objectInputStream = new ObjectInputStream(this.socket.getInputStream());
                received = (Message) objectInputStream.readObject();
                System.out.println(user.getId() + "'s server socket received a message from client.");
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            // Process and respond
            switch (received.getMsgType()) {
                case MessageType.REQUEST_ONLINE_USER_LIST:
                    sent = new Message();
                    sent.setContent(ServerSocketThreadManager.showOnlineUserList());
                    try {
                        objectOutputStream = new ObjectOutputStream(this.socket.getOutputStream());
                        objectOutputStream.writeObject(sent);
                        System.out.println(user.getId() + "'s server socket has sent " + user.getId() + " message.");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;

                case MessageType.MESSAGE_TO_ALL:
                    String userWhoSendsMessage = received.getSender();
                    for (Map.Entry<User, Socket> entry : ServerSocketThreadManager.connections.entrySet()) {
                        if (entry.getKey().equals(userWhoSendsMessage))
                            continue;
                        else {
                            sent = new Message(userWhoSendsMessage, entry.getKey().toString(),
                                    received.getContent(), MessageType.MESSAGE_FROM_OTHER_CLIENT);
                            try {
                                objectOutputStream = new ObjectOutputStream(entry.getValue().getOutputStream());
                                objectOutputStream.writeObject(sent);
                                System.out.println(user.getId() + "'s server socket has sent " + user.getId() + " message.");
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
            }
        }
    }
}
