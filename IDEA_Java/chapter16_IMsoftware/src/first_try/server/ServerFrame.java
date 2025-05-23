package first_try.server;

import java.io.IOException;

public class ServerFrame {
    public static void main(String[] args) {
        try {
            new Thread(new ServerAdmin()).start();
            new Server();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
