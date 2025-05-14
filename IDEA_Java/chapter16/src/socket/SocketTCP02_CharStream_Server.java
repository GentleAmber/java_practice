package socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketTCP02_CharStream_Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务端 开始监听...");
        Socket socket = serverSocket.accept();
        System.out.println("服务端 连接到客户端");

        InputStream inputStream = socket.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String messageReceived;
        String messageSent = "Hello, client.";

        messageReceived = bufferedReader.readLine();
        System.out.println(messageReceived);

        if (messageReceived.equals("Hello, server.")) {
            System.out.println("服务端 握手成功");
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write(messageSent.getBytes());
            socket.shutdownOutput();
        } else {
            System.out.println("服务端 握手失败");
        }

        bufferedReader.close();

        socket.close();
        serverSocket.close();



    }
}
