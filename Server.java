package tcpsocket;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author denver
 */
public class Server {
    public static void main(String[] args){
        final int PORT = 5000;
        
        try(ServerSocket serverSocket = new ServerSocket(PORT)) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");
            
            InputStreamReader inputStreamReader =  new InputStreamReader(socket.getInputStream());
            
            BufferedReader input = new BufferedReader(inputStreamReader);
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
            
            
            while(true) {
                String message = input.readLine();
                
                if(message.equals("exit"))
                  break;

                output.println("Message from server: " + message);
            } 
            
        } catch(IOException e) {
            System.out.println("Server Error: " + e.getMessage());
        }
    }
}
