package first_try.server;

import first_try.common.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.time.LocalDateTime;

public class HeartbeatReceiver implements Runnable{
    User user;
    Socket socket;
    Long latestHeartBeat = 0l;
    int MAX_INTERVAL_NOT_RECEIVING_HEARTBEAT = 20;

    public HeartbeatReceiver(User user, Socket socket) {
        this.user = user;
        this.socket = socket;
    }

    @Override
    public void run() {
        BufferedReader reader = null;
        String message = null;

        try {
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (true) {
            try {
                if ((message = reader.readLine()) == null) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            if ("HEARTBEAT_KX".equals(message)) {
                latestHeartBeat = System.currentTimeMillis();
            }

            if (System.currentTimeMillis() - latestHeartBeat
            >= MAX_INTERVAL_NOT_RECEIVING_HEARTBEAT * 1000) {
                break;
            }
        }
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ServerConnectionThreadManager.userLogUpdate(user, LocalDateTime.now(), 0);
        ServerConnectionThreadManager.removeConnection(user);

    }
}
