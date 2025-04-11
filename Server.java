import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 ** Simple TCP Server that listens for a client connection,
 * 
 * @author denver
 */
public class Server {
    public static void main(String[] args){
        final int PORT = 6000; // Define the port the server will listen on

        try(ServerSocket serverSocket = new ServerSocket(PORT)) { // Start server socket
            System.out.println("Server started. Waiting for client");

            // Wait for a client connection
            Socket socket = serverSocket.accept();

            // Create a reader to receive data from the client
            InputStreamReader inputStreamReader =  new InputStreamReader(socket.getInputStream());
            BufferedReader input = new BufferedReader(inputStreamReader);

            // Create a writer to send data to the client
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

            // Infinite loop to keep reading and responding to client messages
            while(true) {
                String message = input.readLine(); // Read client message

                // Exit loop if message is "exit"
                if(message.equals("exit"))
                    break;

                // Print message from client to server console
                System.out.println("Message from client: " + message);

                // Echo the message back to the client with a prefix
                output.println("Message from server: " + message);
            } 

        } catch(IOException e) {
            // Print error if server fails to start or handle connections
            System.out.println("Server Error: " + e.getMessage());
        }
    }
}
