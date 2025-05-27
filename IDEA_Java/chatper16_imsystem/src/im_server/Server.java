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
                System.out.println("\t\t1 Message all users");
                System.out.println("\t\t9 Shut down the server");

                choice = scanner.next().charAt(0);
                switch (choice) {
                    case '9':

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
    private void messageAll() {

        Message message = new Message();
        message.setMessageType(MessageType.COMM_MES_TO_ALL);
        message.setSender("Admin");
        message.setContent("pseudo content.");

//        try {
//            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
//            oos.writeObject(message);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    public Server() {

        System.out.println("Server listens on port 1997...");
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
