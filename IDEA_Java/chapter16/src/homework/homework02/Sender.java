package homework.homework02;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Sender {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(8889);
        byte[] question = "四大名著是哪些？".getBytes();
        DatagramPacket packetToBeSent = new DatagramPacket(question, question.length, InetAddress.getLocalHost(), 8888);

        socket.send(packetToBeSent);
        System.out.println("问题已发送");

        // 准备接收
        byte[] buf = new byte[1024]; // Should be less than 64K = 64 * 1024 bytes
        DatagramPacket packet = new DatagramPacket(buf, buf.length);
        System.out.println("在8889端口监听...");
        socket.receive(packet);
        byte[] received = packet.getData();
        int length = packet.getLength();
        String receivedString;
        System.out.println("接收到：" + (receivedString = new String(received, 0, length)));
        System.out.println("接收完毕，退出系统。");

        socket.close();

    }
}
