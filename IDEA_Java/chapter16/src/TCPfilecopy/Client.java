package TCPfilecopy;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    /*
    Client connects to the server, and sends a picture whose path is "E:\GFRI5391.JPG"
    The server receives it and saves it under the path "src\", and sends "received" to
    the client, and quit.
    Upon getting the message "received", the client quits.
     */
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        System.out.println("Client connects.");

        // 1. Read the pic into buf
        int readLen;
        byte[] buf = new byte[2048];
        BufferedInputStream bIS = new BufferedInputStream(new FileInputStream("E:\\GFRI5391.JPG"));

        // 2. Write buf to the socket.getOutputStream
        OutputStream socketOS = socket.getOutputStream();
        while ((readLen = bIS.read(buf)) != -1) {
            socketOS.write(buf, 0, readLen);
        }
        socketOS.flush();

        bIS.close();
        socket.shutdownOutput();
        System.out.println("Client sent the picture");

        // 3. Receives response from server
        InputStream socketIS = socket.getInputStream();
        StringBuilder messageReceived = new StringBuilder();
        while ((readLen = socketIS.read(buf)) != -1) {
            messageReceived.append(new String(buf, 0, readLen));
        }

        // 4. Check if server has received the picture
        if (messageReceived.toString().equals("received"))
            System.out.println("Client handshake successful");
        else
            System.out.println("Fail");

        socket.close();

    }
}
