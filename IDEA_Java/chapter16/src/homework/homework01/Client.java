package homework.homework01;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    /*
        字符流编写客户端和服务端程序
        客户端发送“name”，服务端返回“我是nova”
        客户端发送“hobby”，服务端返回“编写java程序”
        对于其他问题，服务端返回“什么？”
         */

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(), 8888);
        System.out.println("Client is connected.");

        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        String question = "hobb";
        System.out.println("Question: " + question);
        bufferedWriter.write(question);
        bufferedWriter.newLine();
        bufferedWriter.flush();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String messageReceived;
        messageReceived = bufferedReader.readLine();
        System.out.println("Response: " + messageReceived);

        socket.close();
    }
}
