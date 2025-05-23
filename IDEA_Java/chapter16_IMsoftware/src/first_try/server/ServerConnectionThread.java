package first_try.server;

import first_try.common.User;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ServerConnectionThread implements Runnable{
    private Socket socket;
    private User user;

    public ServerConnectionThread(User user, Socket socket) {
        this.socket = socket;
        this.user = user;
    }

    /*
    The heartbeatReceiver can make sure to close the socket when the first_try.server loses connection
    to the first_try.client. So the other parts of the run() method don't have to deal with this logic,
    but will keep listening from the first_try.client.
     */
    @Override
    public void run() {
        new Thread(new HeartbeatReceiver(user, socket)).start();
        BufferedInputStream bIS = null;
        BufferedOutputStream bOS = null;
        int readLen = 0;
        byte[] buf = new byte[4096];// 4 kb

        try {
            bIS = new BufferedInputStream(socket.getInputStream());
            bOS = new BufferedOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
