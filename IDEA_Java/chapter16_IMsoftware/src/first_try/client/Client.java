package first_try.client;

import first_try.common.Message;
import first_try.common.User;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
    private User user;
    private Message message;

    /*
    Upon initialized, connect to the first_try.server. Send the user's info for the first_try.server to verify,
    and only starts a thread to put the socket in for them to communicate when first_try.server sends
    back "pass". Also put the object of user and the socket in the Client Connection Thread
    Manager for further management.
     */
    public Client(User user) {
        this.user = user;
        String verificationResult = "";
        Socket socket = null;
        try {
            socket = new Socket(InetAddress.getByName("192.168.1.74"), 1997);
            // Verify user info first, after connecting to the first_try.server
            ObjectOutputStream oOS = new ObjectOutputStream(socket.getOutputStream());
            oOS.writeObject(user);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            verificationResult = bufferedReader.readLine();

            if ("pass".equals(verificationResult)) {
                System.out.println(user.getId() + " connects to the first_try.server!");
                ClientConnectionThread connection = new ClientConnectionThread(user, socket);
                new Thread(connection).start();
                ClientConnectionThreadManager.addConnection(user, socket);

            } else {
                System.out.println(user.getId() + " fails to connect.");
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
