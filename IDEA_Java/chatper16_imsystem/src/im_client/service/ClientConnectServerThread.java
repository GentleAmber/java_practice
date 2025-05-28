package im_client.service;

import im_common.Message;
import im_common.MessageType;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class ClientConnectServerThread implements Runnable{
    private Socket socket;
    private boolean loop = true;
    private String userId;

    public boolean isLoop() {
        return loop;
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }

    public ClientConnectServerThread(Socket socket, String userId) {
        this.socket = socket;
        this.userId = userId;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    // Keep listening from the server
    @Override
    public void run() {
        while (loop) {
            try {
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                Message ms = (Message) ois.readObject();

                if (ms.getMessageType().equals(MessageType.RETURN_ONLINE_USER)) {
                    if (!ms.getContent().equals("")) {
                        System.out.println("---------- Online user list ----------");
                        System.out.println(ms.getContent());
                    } else {
                        System.out.println("----------- No user online -----------");
                    }
                    System.out.println("--------------------------------------");
                } else if (ms.getMessageType().equals(MessageType.COMM_MES)) {
                    System.out.println("\n" + ms.getTimestamp() + "\t" + ms.getSender());
                    System.out.println(ms.getContent());
                } else if (ms.getMessageType().equals(MessageType.COMM_MES_SENT_SUCCEED)) {
                    System.out.println("Message sent.");
                } else if (ms.getMessageType().equals(MessageType.COMM_MES_SENT_FAIL)) {
                    System.out.println("Failed to send message.");
                } else if (ms.getMessageType().equals(MessageType.COMM_MES_STORED_IN_SERVER)) {
                    System.out.println("Message received by the server. It " +
                            "will be delivered when the receiver is back online.");
                } else if (ms.getMessageType().equals(MessageType.SEND_FILE)) {
                    System.out.println(ms.getSender() + " sends you a file to " + ms.getTargetPath());

                    System.out.println("Saving the file...");
                    Path path = Paths.get(ms.getTargetPath());
                    try {
                        Files.write(path, ms.getFile());
                        System.out.println("Wrote " + ms.getFile().length + " bytes to file.");
                    } catch (InvalidPathException | IOException e) {
                        e.printStackTrace();
                    }

                } else if (ms.getMessageType().equals(MessageType.FILE_SENT_SUCCEED)) {
                    System.out.println("File is sent successfully.");
                } else if (ms.getMessageType().equals(MessageType.FILE_SENT_FAIL)) {
                    System.out.println("Failed to send the file.");
                } else if (ms.getMessageType().equals(MessageType.FILE_STORED_IN_SERVER)) {
                    System.out.println("File received by the server. It " +
                            "will be delivered when the receiver is back online.");
                } else if (ms.getMessageType().equals(MessageType.SERVER_EXIT)) {
                    System.out.println("Lost the connection with server... Will exit soon.");
                    ManageClientConnectServerThread.removeThread(userId);
                    this.socket.close();
                    System.exit(0);

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
