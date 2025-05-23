package second_try.userclient;

import second_try.common.Message;
import second_try.common.MessageType;
import second_try.common.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientSocketThread implements Runnable{
    User user;
    Socket socket;
    boolean connected = true;

    public ClientSocketThread(User user, Socket socket) {
        this.user = user;
        this.socket = socket;
    }

    @Override
    public void run() {
        ObjectInputStream objectInputStream = null;
        ObjectOutputStream objectOutputStream = null;
        Message received = null;
        Message sent = null;

        // While connected, send message to the server and hears response.
        while (connected) {

            System.out.println("--------" + user.getId() + "--------");
            System.out.println("        1 View all online users");
            System.out.println("        2 Message all");
            System.out.println("        3 Private chat with someone");
            System.out.println("        4 Send a file");
            System.out.println("        9 Log out");
            System.out.print("Please enter your choice:");

            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            switch (choice) {
                case 1: // view online users
                    sent = new Message();
                    sent.setMsgType(MessageType.REQUEST_ONLINE_USER_LIST);
                    try {
                        objectOutputStream = new ObjectOutputStream(this.socket.getOutputStream());
                        objectOutputStream.writeObject(sent);
                        System.out.println(user.getId() + "'s client has sent a message.");
                        objectInputStream = new ObjectInputStream(this.socket.getInputStream());
                        received = (Message) objectInputStream.readObject();
                        System.out.println(user.getId() + "'s client has received a message.");
                    } catch (IOException | ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                    System.out.println(received.getTimestamp());
                    System.out.println(received.getContent());
                    break;

                case 2: // message all
                    System.out.print("Please enter the message you want to send:");
                    String messageContent = scanner.nextLine();
                    sent = new Message(user.getId(), "all", messageContent, MessageType.MESSAGE_TO_ALL);

                    try {
                        objectOutputStream = new ObjectOutputStream(this.socket.getOutputStream());
                        objectOutputStream.writeObject(sent);
                        objectInputStream = new ObjectInputStream(this.socket.getInputStream());
                        received = (Message) objectInputStream.readObject();
                    } catch (IOException | ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                    break;

                case 9: // log out
                    sent = new Message();
                    sent.setMsgType(MessageType.CLIENT_REQUEST_EXIT);
                    try {
                        objectOutputStream = new ObjectOutputStream(this.socket.getOutputStream());
                        objectOutputStream.writeObject(sent);
                        objectInputStream = new ObjectInputStream(this.socket.getInputStream());
                        received = (Message) objectInputStream.readObject();
                    } catch (IOException | ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                    if (received.getMsgType().equals(MessageType.CLIENT_CAN_EXIT)) {
                        connected = false;
                        ClientSocketThreadManager.removeConnection(user);
                        System.out.println("Log out successfully. Look forward to seeing you again!");
                    } else {
                        System.out.println("Server is busy. Please try again.");
                    }
                    break;

                default:
                    System.out.println("Wrong input. Please enter again.");
            }
        }



    }
}
