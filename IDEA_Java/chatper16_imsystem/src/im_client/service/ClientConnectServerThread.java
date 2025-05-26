package im_client.service;

import im_common.Message;
import im_common.MessageType;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class ClientConnectServerThread implements Runnable{
    private Socket socket;
    private boolean loop = true;

    public boolean isLoop() {
        return loop;
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }

    public ClientConnectServerThread(Socket socket) {
        this.socket = socket;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    // Keep listening from the server
    @Override
    public void run() {
        while (loop) {
            try {
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                Message ms = (Message) ois.readObject();

                switch (ms.getMessageType()) {
                    case MessageType.RETURN_ONLINE_USER:
                        if (!ms.getContent().equals("")) {
                            System.out.println("---------- Online user list ----------");
                            System.out.println(ms.getContent());
                        } else {
                            System.out.println("----------- No user online -----------");
                        }
                        System.out.println("--------------------------------------");
                        break;

                    case MessageType.COMM_MES:
                        System.out.println("\n" + ms.getTimestamp() + "\t" + ms.getSender());
                        System.out.println(ms.getContent());
                        break;

                    case MessageType.COMM_MES_SENT_SUCCEED:
                        System.out.println("Message sent.");
                        break;

                    case MessageType.COMM_MES_SENT_FAIL:
                        System.out.println("Failed to send message.");
                        break;

                    case MessageType.SEND_FILE:
                        System.out.print(ms.getSender() + " sends you a file to " +
                                ms.getTargetPath() + ". Accept it? (Y/N)");
                        Scanner scanner = new Scanner(System.in);
                        boolean innerLoop = true;

                        // The IMView will take the first input so need to enter twice here
                        while (innerLoop) {
                            char choice = scanner.next().charAt(0);
                            switch (choice) {
                                case 'Y':
                                case 'y':
                                    System.out.println("Saving the file...");
                                    Path path = Paths.get(ms.getTargetPath());
                                    try {
                                        Files.write(path, ms.getFile());
                                        System.out.println("Wrote " + ms.getFile().length + " bytes to file.");
                                        innerLoop = false;
                                    } catch (NoSuchFileException | InvalidPathException e) {
                                        e.printStackTrace();
                                    }

                                    break;

                                case 'n':
                                case 'N':
                                    System.out.println("File reception cancelled.");
                                    innerLoop = false;
                                    break;

                                default:
                                    System.out.println("Wrong input. Please enter again.");

                            }
                        }

                        break;

                    case MessageType.FILE_SENT_SUCCEED:
                        System.out.println("File is sent successfully.");
                        break;

                    case MessageType.FILE_SENT_FAIL:
                        System.out.println("Failed to send the file.");
                        break;

                }

            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }

        }

        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
