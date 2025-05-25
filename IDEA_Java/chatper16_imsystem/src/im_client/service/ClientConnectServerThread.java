package im_client.service;

import im_common.Message;
import im_common.MessageType;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashSet;

public class ClientConnectServerThread implements Runnable{
    private Socket socket;
    private boolean loop = true;

    public boolean isLoop() {
        return loop;
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }

    public ClientConnectServerThread(Socket socket) {
        this.socket = socket;
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

                switch (ms.getMessageType()) {
                    case MessageType.RETURN_ONLINE_USER:
                        if (!ms.getContent().equals("")) {
                            System.out.println("---------- Online user list ----------");
                            System.out.println(ms.getContent());
                        } else {
                            System.out.println("----------- No user online -----------");
                        }
                        System.out.println("--------------------------------------");
                        break;

                    case MessageType.COMM_MES:
                        System.out.println("\n" + ms.getTimestamp() + "\t" + ms.getSender());
                        System.out.println(ms.getContent());
                        break;

                    case MessageType.COMM_MES_SENT_SUCCEED:
                        System.out.println("Message sent.");
                        break;

                    case MessageType.COMM_MES_SENT_FAIL:
                        System.out.println("Failed to send message.");
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
