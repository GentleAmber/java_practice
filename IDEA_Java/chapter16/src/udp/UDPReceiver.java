package udp;


import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPReceiver {
    public static void main(String[] args) throws IOException {
        // Initialize a datagramSocket that is ready to get data at port 9999
        DatagramSocket socket = new DatagramSocket(9999);

        byte[] buf = new byte[1024]; // Should be less than 64K = 64 * 1024 bytes
        DatagramPacket packet = new DatagramPacket(buf, buf.length);

        System.out.println("Waiting for message...");
        socket.receive(packet);

        int length = packet.getLength();
        byte[] data = packet.getData();

        String message = new String(data, 0, length);
        System.out.println("Received: " + message);

        byte[] messageToSend = "Thanks. Let's go to a Chinese restaurant tomorrow.".getBytes();
        DatagramPacket packet1 = new DatagramPacket(messageToSend,
                messageToSend.length, InetAddress.getLocalHost(), 9998);

        socket.send(packet1);

    }
}
