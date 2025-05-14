package socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketTCP02Client {
    public static void main(String[] args) throws IOException {
        // The server listens at port 9999, when the client connects to it, the client sends
        // a message "Hello, server." Upon receiving it, the server sends a message back "He-
        // llo, client." And then both client and server exit.

        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        System.out.println("客户端 连接到服务端");
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("Hello, server.".getBytes());
        socket.shutdownOutput();

        InputStream inputStream = socket.getInputStream();
        int readLen;
        byte[] buf = new byte[1024];
        String messageReceived = "";

        while ((readLen = inputStream.read(buf)) != -1) {
            messageReceived += new String(buf, 0, readLen);
        }
        System.out.println(messageReceived);
        inputStream.close();


        if (messageReceived.equals("Hello, client.")) {
            System.out.println("客户端 握手成功");
        } else {
            System.out.println("客户端 握手失败");
        }


        socket.close();
    }
}
