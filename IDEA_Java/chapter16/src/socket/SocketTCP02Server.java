package socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketTCP02Server {
    // The server listens at port 9999, when the client connects to it, the client sends
    // a message "Hello, server." Upon receiving it, the server sends a message back "He-
    // llo, client." And then both client and server exit.

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务端 开始监听...");
        Socket socket = serverSocket.accept();
        System.out.println("服务端 连接到客户端");

        InputStream inputStream = socket.getInputStream();
        int readLen;
        byte[] buf = new byte[1024];
        String messageReceived = "";
        String messageSent = "Hello, client.";

        while ((readLen = inputStream.read(buf)) != -1) {
            messageReceived += new String(buf, 0, readLen);
        }
        System.out.println(messageReceived);

        if (messageReceived.equals("Hello, server.")) {
            System.out.println("服务端 握手成功");
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write(messageSent.getBytes());
            socket.shutdownOutput();
        } else {
            System.out.println("服务端 握手失败");
        }

        inputStream.close();

        socket.close();
        serverSocket.close();



    }
}
