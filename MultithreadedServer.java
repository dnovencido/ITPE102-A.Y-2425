package tcpsocket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author denver
 */
public class MultithreadedServer {
    public static void main(String[] args) {
        try(ServerSocket serverSocket = new ServerSocket(5000)) {
            while(true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");

                ServerThread serverThread = new ServerThread(socket);
                serverThread.start();
            }
        } 
        catch (IOException e) {
            System.out.println("Server exception " + e.getMessage());
        }
    }
}
