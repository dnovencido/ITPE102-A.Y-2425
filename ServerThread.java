import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * ServerThread handles communication with a single client.
 * 
 * @author denver
 */
class ServerThread extends Thread {
    private final Socket socket;

    // Client's socket connection
    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Set up input and output streams for communication
            InputStreamReader inputStreamReader = new InputStreamReader(socket.getInputStream());
            BufferedReader input = new BufferedReader(inputStreamReader);
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true); // autoFlush is on

            // Keep reading messages from the client until "exit" is received
            while (true) {
                String message = input.readLine(); // Read a message from the client

                if (message == null || message.equals("exit")) {
                    break; // Exit loop if message is "exit" or client disconnects
                }

                // Print client message on server console
                System.out.println("Message from client : " + message);

                // Send response back to the client
                output.println("Echo from server: " + message);
            }
        } catch (IOException e) {
            System.out.println("Error message : " + e.getMessage()); // Handle error during communication
        } finally {
            try {
                socket.close(); // Close the connection when done
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
