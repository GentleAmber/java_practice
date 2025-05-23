package first_try.server;

import first_try.common.User;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;

public class Server {

    ServerSocket ss;

    /*
    When first_try.server is initialized,
     */

    public Server() throws IOException {
        this.ss = new ServerSocket(1997);

        while (true) {
            String verificationResult = "";
            User user = null;
            System.out.println("Server listens on port 1997...");
            Socket socket = this.ss.accept();
            ObjectInputStream oIS = new ObjectInputStream(socket.getInputStream());
            try {
                user = (User) oIS.readObject();
                verificationResult = logInVerification(user.getId(), user.getPassword());
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                bufferedWriter.write(verificationResult);
                bufferedWriter.newLine();
                bufferedWriter.flush();

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            if ("pass".equals(verificationResult)) {
                ServerConnectionThread connection = new ServerConnectionThread(user, socket);
                new Thread(connection).start();
                ServerConnectionThreadManager.addConnection(user, socket);
                ServerConnectionThreadManager.userLogUpdate(user, LocalDateTime.now(), 1);

                System.out.println("Server connects to " + user.getId());
            } else {
                System.out.println(user.getId() + " fails to connect.");
                socket.close();
            }
        }
    }

    public static String logInVerification(String username, String pwd) {
        if ("100".equals(username) && "123456".equals(pwd)) {
            return "pass";
        }
        return "fail";
    }
}
