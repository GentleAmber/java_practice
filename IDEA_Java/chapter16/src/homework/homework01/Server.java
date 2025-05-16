package homework.homework01;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Server {
    /*
        字符流编写客户端和服务端程序
        客户端发送“name”，服务端返回“我是nova”
        客户端发送“hobby”，服务端返回“编写java程序”
        对于其他问题，服务端返回“什么？”
         */
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8888);
        System.out.println("Server starts listening on port 8888...");

        Socket accept = serverSocket.accept();
        System.out.println("Server is connected.");

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(accept.getInputStream()));
        String messageReceived;
        messageReceived = bufferedReader.readLine();

        String messageSent;

        switch(messageReceived) {
            case "name" :
                messageSent = "I'm Yenna.";
                break;
            case "hobby" :
                messageSent = "Write Java Program.";
                break;
            default:
                messageSent = "What?";
        }

        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(accept.getOutputStream()));
        bufferedWriter.write(messageSent);
        bufferedWriter.newLine();
        bufferedWriter.flush();

        System.out.println("Question answered. Disconnect.");

        accept.close();


    }
}
