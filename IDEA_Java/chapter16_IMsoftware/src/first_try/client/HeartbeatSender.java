package first_try.client;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class HeartbeatSender implements Runnable {
    Socket socket;
    int heartbeatInterval;
    boolean ifRun = true;

    public void setIfRun(boolean ifRun) {
        this.ifRun = ifRun;
    }

    public HeartbeatSender(Socket socket, int heartbeatInterval) {
        this.socket = socket;
        this.heartbeatInterval = heartbeatInterval;
    }

    @Override
    public void run() {
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            while (ifRun) {
                writer.write("HEARTBEAT_KX");
                writer.newLine();
                writer.flush();
                Thread.sleep(heartbeatInterval * 1000);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

    }
}
