import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Simple TCP Client that connects to the server, 
 * sends user input, and prints responses from the server.
 * 
 * @author denver
 */
public class Client {
    public static void main(String[] args) {
        // Try to connect to the server at localhost (127.0.0.1) on port 6000
        try(Socket socket = new Socket("127.0.0.1", 6000)) {

            // Read messages sent from the server
            InputStreamReader inputStreamReader = new InputStreamReader(socket.getInputStream());
            BufferedReader input = new BufferedReader(inputStreamReader);

            // Send messages to the server 
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true); // 'true' means autoFlush is enabled (sends message right away)

            // Scanner is used to read input from the user
            Scanner scanner = new Scanner(System.in);
            String message;   // message from user
            String response;  // response from server

            do {
                // Ask the user to type a message
                System.out.print("Enter message >> ");
                message = scanner.nextLine();  // Read user's message

                output.println(message); // Send message to server

                // If the message is not "exit", wait for a response
                if(!message.equals("exit")) {
                    response = input.readLine();     // Read server's reply
                    System.out.println(response);    // Show reply
                }

            } while(!message.equals("exit")); // Stop when user types "exit"

        } catch(IOException e) {
            // Print any connection or I/O errors
            System.out.println(e.getMessage());
        }   
    }
}
