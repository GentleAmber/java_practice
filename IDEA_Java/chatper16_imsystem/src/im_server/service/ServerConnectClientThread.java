package im_server.service;

import im_common.Message;
import im_common.MessageType;
import im_server.Server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Set;

public class ServerConnectClientThread implements Runnable {

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

                if (ms.getMessageType().equals(MessageType.GET_ONLINE_USER)) {
                    String onlineUserList = ManageServerConnectClientThread.getOnlineUserStringList();
                    Message returnedMessage = new Message();
                    returnedMessage.setContent(onlineUserList);
                    returnedMessage.setMessageType(MessageType.RETURN_ONLINE_USER);

                    oos = new ObjectOutputStream(socket.getOutputStream());
                    oos.writeObject(returnedMessage);

                } else if (ms.getMessageType().equals(MessageType.CLIENT_EXIT)) {

                    String userId = ms.getSender();
                    ManageServerConnectClientThread.closeThread(userId);

                } else if (ms.getMessageType().equals(MessageType.COMM_MES)) {
                    Message returnedMs = new Message();

                    // First verify if the receiver is online
                    if (ManageServerConnectClientThread.ifUserOnline(ms.getReceiver())) {
                        Message message = new Message(ms.getSender(), ms.getReceiver(), ms.getContent(), ms.getMessageType());
                        oos = new ObjectOutputStream(ManageServerConnectClientThread.getThread(ms.getReceiver()).getSocket().getOutputStream());
                        oos.writeObject(message);

                        // Tells the sender the message was sent successfully
                        returnedMs.setMessageType(MessageType.COMM_MES_SENT_SUCCEED);

                        // If the receiver is not online and is a valid user, store the message
                        // in the server for later delivery.
                    } else if (Server.userExist(ms.getReceiver())) {
                        ManageStoredMessage.storeMessage(ms.getReceiver(), ms);
                        returnedMs.setMessageType(MessageType.COMM_MES_STORED_IN_SERVER);

                    } else {
                        returnedMs.setMessageType(MessageType.COMM_MES_SENT_FAIL);
                    }

                    oos = new ObjectOutputStream(ManageServerConnectClientThread.getThread(ms.getSender()).getSocket().getOutputStream());
                    oos.writeObject(returnedMs);

                } else if (ms.getMessageType().equals(MessageType.COMM_MES_TO_ALL)) {
                    Message returnedMs2 = new Message();
                    // Pull a set of all online users except the sender
                    Set<String> onlineUserListExceptSender = ManageServerConnectClientThread.onlineUserListExceptSender(ms.getSender());
                    if (onlineUserListExceptSender == null) {
                        returnedMs2.setMessageType(MessageType.COMM_MES_SENT_FAIL);
                    } else {
                        for (String user : onlineUserListExceptSender) {
                            Message message = new Message(ms.getSender(), user, ms.getContent(), MessageType.COMM_MES);
                            oos = new ObjectOutputStream(ManageServerConnectClientThread.getThread(user).getSocket().getOutputStream());
                            oos.writeObject(message);
                        }
                        returnedMs2.setMessageType(MessageType.COMM_MES_SENT_SUCCEED);
                    }
                    oos = new ObjectOutputStream(ManageServerConnectClientThread.getThread(ms.getSender()).getSocket().getOutputStream());
                    oos.writeObject(returnedMs2);

                } else if (ms.getMessageType().equals(MessageType.SEND_FILE)) {
                    Message returnedMsFile = new Message();

                    if (ManageServerConnectClientThread.ifUserOnline(ms.getReceiver())) {
                        oos = new ObjectOutputStream(ManageServerConnectClientThread.getThread(ms.getReceiver()).getSocket().getOutputStream());
                        oos.writeObject(ms);

                        // Tell the sender the message was sent successfully
                        returnedMsFile.setMessageType(MessageType.FILE_SENT_SUCCEED);
                    } else if (Server.userExist(ms.getReceiver())) {
                        ManageStoredMessage.storeMessage(ms.getReceiver(), ms);
                        returnedMsFile.setMessageType(MessageType.FILE_STORED_IN_SERVER);

                    } else {
                        returnedMsFile.setMessageType(MessageType.FILE_SENT_FAIL);
                    }

                    oos = new ObjectOutputStream(ManageServerConnectClientThread.getThread(ms.getSender()).getSocket().getOutputStream());
                    oos.writeObject(returnedMsFile);

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
