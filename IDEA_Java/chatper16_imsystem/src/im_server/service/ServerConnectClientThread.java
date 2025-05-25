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
                ObjectOutputStream oos = null;

                switch (ms.getMessageType()) {
                    case MessageType.GET_ONLINE_USER:
                        String onlineUserList = ManageServerConnectClientThread.getOnlineUser();
                        Message returnedMessage = new Message();
                        returnedMessage.setContent(onlineUserList);
                        returnedMessage.setMessageType(MessageType.RETURN_ONLINE_USER);

                        oos = new ObjectOutputStream(socket.getOutputStream());
                        oos.writeObject(returnedMessage);
                        break;

                    case MessageType.CLIENT_EXIT:
                        String userId = ms.getSender();
                        ManageServerConnectClientThread.closeThread(userId);
                        break;

                    case MessageType.COMM_MES:
                        Message returnedMs = new Message();

                        // First verify if the receiver is online/valid
                        if (ManageServerConnectClientThread.ifUserOnline(ms.getReceiver())) {
                            Message message = new Message(ms.getSender(), ms.getReceiver(), ms.getContent(), ms.getMessageType());
                            oos = new ObjectOutputStream(ManageServerConnectClientThread.getThread(ms.getReceiver()).getSocket().getOutputStream());
                            oos.writeObject(message);

                            // Tells the sender the message was sent successfully
                            returnedMs.setMessageType(MessageType.COMM_MES_SENT_SUCCEED);
                        } else {
                            returnedMs.setMessageType(MessageType.COMM_MES_SENT_FAIL);
                        }

                        oos = new ObjectOutputStream(ManageServerConnectClientThread.getThread(ms.getSender()).getSocket().getOutputStream());
                        oos.writeObject(returnedMs);
                        break;


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
