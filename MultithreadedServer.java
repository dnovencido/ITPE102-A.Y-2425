import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Multi-threaded server that accepts multiple client connections.
 * 
 * @author denver
 */
public class MultiThreadedServer {
    public static void main(String[] args) {
        // Start a server socket listening on port 6000
        try(ServerSocket serverSocket = new ServerSocket(6000)) {
            System.out.println("Server started. Waiting for client");

            // Infinite loop to keep accepting clients
            while(true) {
                // Wait for a client to connect
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");

                // Create a new thread for this client
                ServerThread serverThread = new ServerThread(socket);

                // Start the thread in parallel
                serverThread.start();
            }
        } 
        catch (IOException e) {
            // Print error if server fails to start or handle connections
            System.out.println("Server exception " + e.getMessage());
        }
    }
}
