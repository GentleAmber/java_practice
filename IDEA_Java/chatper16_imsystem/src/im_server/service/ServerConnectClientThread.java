package im_server.service;

import im_common.Message;
import im_common.MessageType;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ServerConnectClientThread implements Runnable{

    private Socket socket;
    private String userId;// So that server knows who it's connecting to via this socket
    private boolean loop = true;

    public boolean isLoop() {
        return loop;
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public ServerConnectClientThread(Socket socket, String userId) {
        this.socket = socket;
        this.userId = userId;
    }


    @Override
    public void run() {
        System.out.println("Communicating with " + userId + "...");
        while (loop) {
            try {
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                Message ms = (Message) ois.readObject();

                switch (ms.getMessageType()) {
                    case MessageType.GET_ONLINE_USER:
                        String onlineUserList = ManageServerConnectClientThread.getOnlineUser();
                        Message returnedMessage = new Message();
                        returnedMessage.setContent(onlineUserList);
                        returnedMessage.setMessageType(MessageType.RETURN_ONLINE_USER);

                        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                        oos.writeObject(returnedMessage);
                        break;

                    case MessageType.CLIENT_EXIT:
                        String userId = ms.getSender();
                        ManageServerConnectClientThread.closeThread(userId);


                }
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
