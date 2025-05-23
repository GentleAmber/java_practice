package second_try.server;

import java.io.IOException;

public class ServerFrame {
    public static void main(String[] args) {
        try {
            new Server();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
