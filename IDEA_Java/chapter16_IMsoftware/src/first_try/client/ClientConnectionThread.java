package first_try.client;

import first_try.common.Message;
import first_try.common.User;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ClientConnectionThread implements Runnable{
    private Socket socket;
    private User user;
    private Message message;
    private int HEARTBEAT_INTERVAL = 5;// heartbeat interval = 5 secs

    public ClientConnectionThread(User user, Socket socket) {
        this.socket = socket;
        this.user = user;
    }

    /*
    When the thread starts, it starts a heartbeatSender thread to let the first_try.server know
    its (and the socket's) status in the background.
     */
    @Override
    public void run() {
        // Send heartbeat to the first_try.server
        HeartbeatSender heartbeatSender = new HeartbeatSender(socket, HEARTBEAT_INTERVAL);
        new Thread(heartbeatSender).start();

        int choice;
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            ClientFrame.secondaryMenu(user.getId());
            choice = scanner.nextInt();

            switch (choice) {
                case 1: // Friend list

                    break;
                case 9: // log out
                    try {
                        socket.close();
                        System.out.println("Log out successfully. See you again.");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    ClientConnectionThreadManager.removeConnection(user);
                    heartbeatSender.setIfRun(false);
                    loop = false;
                    break;
            }
        }
    }
}
