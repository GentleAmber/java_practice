package TCPfilecopy;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    /*
    Client connects to the server, and sends a picture whose path is "E:\GFRI5391.JPG"
    The server receives it and saves it under the path "src\", and sends "received" to
    the client, and quit.
    Upon getting the message "received", the client quits.
     */

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        Socket socket = serverSocket.accept();
        System.out.println("Server connects.");

        // 1. Receive the picture
        InputStream socketIS = socket.getInputStream();
        int readLen;
        byte[] buf = new byte[2048];

        // 2. Write the picture to local file
        BufferedOutputStream bOS = new BufferedOutputStream(new FileOutputStream("src\\Received_GFRI5391.JPG"));
        while ((readLen = socketIS.read(buf)) != -1) {
            bOS.write(buf, 0, readLen);
        }
        bOS.flush();
        bOS.close();
        System.out.println("Server receives and saves the picture");

        // 3. Return message
        OutputStream socketOS = socket.getOutputStream();
        socketOS.write("received".getBytes());
        socket.shutdownOutput();

        // 4. quit
        socket.close();


    }
}
