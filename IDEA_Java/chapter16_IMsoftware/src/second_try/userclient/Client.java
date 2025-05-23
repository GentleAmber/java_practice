package second_try.userclient;

import second_try.common.Message;
import second_try.common.MessageType;
import second_try.common.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
    private Socket socket;
    private User user;

    public Client(User user) throws IOException, ClassNotFoundException {
        // Send the user to the server for verification
        this.user = user;
        socket = new Socket(InetAddress.getByName("192.168.1.74"), 1997);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
        objectOutputStream.writeObject(user);
        ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
        Message verificationResult = (Message) objectInputStream.readObject();

        // Read and display the result
        if (verificationResult.getMsgType().equals(MessageType.USER_NOT_EXIST)) {
            System.out.println("User id doesn't exist.");
        } else if (verificationResult.getMsgType().equals(MessageType.VERIFICATION_FAIL)) {
            System.out.println("Password is wrong.");
        } else if (verificationResult.getMsgType().equals(MessageType.VERIFICATION_SUCCESS)){
            // If successful, start a thread to keep the socket
            System.out.println("Welcome, " + user.getId());
            new Thread(new ClientSocketThread(user, socket)).start();
            ClientSocketThreadManager.addConnection(user, socket);
        } else {
            System.out.println("Unknown error.");
        }
    }

    public User getUser() {
        return user;
    }

    public Socket getSocket() {
        return socket;
    }
}
