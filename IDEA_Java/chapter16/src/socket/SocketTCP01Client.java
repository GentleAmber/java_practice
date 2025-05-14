package socket;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketTCP01Client {
    public static void main(String[] args) throws IOException {
        // Connects to local host's port. If successful, return socket
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        // Generates an outputstream that connects with socket
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("Hello, server".getBytes());
        // Closes the socket and outputstream
        outputStream.close();
        socket.close();

    }
}
