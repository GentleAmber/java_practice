package udp;

import java.io.IOException;
import java.net.*;

public class UDPSender {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(9998);

        byte[] data = "Welcome to Octopus Energy.".getBytes();
        DatagramPacket packet = new DatagramPacket(data,
                data.length, InetAddress.getByName("192.168.1.74"), 9999);

        socket.send(packet);

        System.out.println("Message sent, waiting for message...");

        byte[] receive = new byte[1024];
        DatagramPacket packet1 = new DatagramPacket(receive, receive.length);

        socket.receive(packet1);
        int length = packet1.getLength();
        byte[] data1 = packet1.getData();

        String received = new String(data1, 0, length);
        System.out.println("Received: "+ received);

    }

}
