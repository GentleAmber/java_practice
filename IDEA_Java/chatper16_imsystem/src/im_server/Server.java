package im_server;

import im_common.Message;
import im_common.MessageType;
import im_common.User;
import im_server.service.ManageServerConnectClientThread;
import im_server.service.ManageStoredMessage;
import im_server.service.ServerConnectClientThread;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class Server {

    private ServerSocket serverSocket = null;
    private static HashMap<String , User> validUsers = new HashMap<>();

    private class ServerCommand implements Runnable{
        private boolean loop = true;

        @Override
        public void run() {
            Scanner scanner = new Scanner(System.in);
            char choice;

            while (loop) {
                System.out.println("=========== Hello, admin ===========");
                System.out.println("\t\t1 Message all users (including offline users)");
                System.out.println("\t\t9 Shut down the server");
                System.out.print("Please enter your choice: ");

                choice = scanner.next().charAt(0);
                switch (choice) {
                    case '9':
                        serverExit();
                        break;

                    case '1':
                        System.out.println("Please enter the content (in one line): ");
                        Scanner scanner1 = new Scanner(System.in);
                        String content = scanner1.nextLine();
                        messageAll_ServerEnd(content);
                        break;

                    default:
                        System.out.println("Wrong input. Please enter again.");

                }
            }
        }
    }

    static {
        validUsers.put("100", new User("100", "123456"));
        validUsers.put("200", new User("200", "000000"));
        validUsers.put("Jack", new User("Jack", "888888"));
        validUsers.put("Hank", new User("Hank", "999999"));
    }

    public static boolean userExist(String userId) {
        return validUsers.containsKey(userId);
    }

    private boolean checkUserValidity(String userId, String pwd) {
        User user = validUsers.get(userId);

        if (user == null) {
            return false;
        }
        if (!user.getPwd().equals(pwd)) {
            return false;
        }
        return true;

    }

    private void serverExit() {

        Set<String> onlineUserList = ManageServerConnectClientThread.onlineUserListExceptSender("");
        ObjectOutputStream oos = null;
        Message message = new Message();
        message.setMessageType(MessageType.SERVER_EXIT);

        for (String user : onlineUserList) {

            try {
                oos = new ObjectOutputStream(ManageServerConnectClientThread.getThread(user).getSocket().getOutputStream());
                oos.writeObject(message);

                ManageServerConnectClientThread.getThread(user).getSocket().close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Server exits successfully.");
        System.exit(0);

    }

    private void messageAll_ServerEnd(String content) {

        Set<String> allUserList = validUsers.keySet();
        ObjectOutputStream oos = null;

        for (String user : allUserList) {
            Message message = new Message("Admin", user, content, MessageType.COMM_MES);

            // If the user is online, send message to him/her directly.
            if (ManageServerConnectClientThread.ifUserOnline(user)) {
                try {
                    oos = new ObjectOutputStream(ManageServerConnectClientThread.getThread(user).getSocket().getOutputStream());
                    oos.writeObject(message);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                // If the user is offline, store the message for later delivery.
            } else {
                ManageStoredMessage.storeMessage(user, message);
            }
        }

        System.out.println("Message sent to all.");

    }

    public Server() {

        System.out.println("Server listens on port 1997...");
        new Thread(new ServerCommand()).start();

        try {
            serverSocket = new ServerSocket(1997);

            while (true) {
                Socket socket = serverSocket.accept();
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                User user = (User) ois.readObject();// For first time connecting, should verify the user
                Message message = new Message();
                ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

                if (checkUserValidity(user.getId(), user.getPwd())) {
                    message.setMessageType(MessageType.LOGIN_SUCCEED);
                    oos.writeObject(message);
                    ServerConnectClientThread scct = new ServerConnectClientThread(socket, user.getId());
                    new Thread(scct).start();
                    ManageServerConnectClientThread.addThread(user.getId(), scct);
                    ManageStoredMessage.tryDeliverStoredMessages(user.getId());


                } else {
                    message.setMessageType(MessageType.LOGIN_FAIL);
                    oos.writeObject(message);
                    socket.close();
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            // If server exits the while loop, it means it doesn't listen anymore
            try {
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
