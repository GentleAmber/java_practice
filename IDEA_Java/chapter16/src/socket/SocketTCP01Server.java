package socket;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketTCP01Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("Server listens at port 9999...");

        // ServerSocket is like a teacher giving class, Socket is like a single student.
        // A ServerSocket can connect to several Sockets.
        Socket accept = serverSocket.accept();
        InputStream inputStream = accept.getInputStream();

        int dataLen;
        byte[] buf = new byte[1024];
        while ((dataLen = inputStream.read(buf)) != -1) {
            System.out.println(new String(buf, 0, dataLen));
        }

        inputStream.close();
        accept.close();
        serverSocket.close();
    }
}
