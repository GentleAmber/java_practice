package homework.homework02;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Receiver {
    public static void main(String[] args) throws IOException {
        /*
        编写一个接收端A和一个发送端B，用UDP协议完成
        接收端在8888端口等待接受数据
        发送端向接收端发送问题“四大名著是哪些？”
        接收端接收到问题后，返回“四大名著是《红楼梦》...”，否则返回“什么？”
        两个程序退出
         */
        DatagramSocket socket = new DatagramSocket(8888);

        byte[] buf = new byte[1024]; // Should be less than 64K = 64 * 1024 bytes
        DatagramPacket packet = new DatagramPacket(buf, buf.length);

        System.out.println("在8888端口监听...");
        socket.receive(packet);

        byte[] received = packet.getData();
        int length = packet.getLength();
        String receivedString;

        System.out.println("接收到：" + (receivedString = new String(received, 0, length)));
        String answer = "四大名著是《红楼梦》、《西游记》、《水浒传》、《三国演义》。";
        byte[] answerByte;

        if ("四大名著是哪些？".equals(receivedString)) {
            answerByte = answer.getBytes();
            DatagramPacket packetToBeSent = new DatagramPacket(answerByte, answerByte.length, InetAddress.getLocalHost(), 8889);
            socket.send(packetToBeSent);
        } else {
            answer = "什么？";
            answerByte = answer.getBytes();
            DatagramPacket packetToBeSent = new DatagramPacket(answerByte, answerByte.length, InetAddress.getLocalHost(), 8889);
            socket.send(packetToBeSent);
        }

        System.out.println("应答完毕。退出。");
        socket.close();
    }
}
