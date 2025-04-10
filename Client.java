package tcpsocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author denver
 */
public class Client {
    public static void main(String[] args) {
        try(Socket socket = new Socket("127.0.0.1", 5000)) {
            
            InputStreamReader inputStreamReader =  new InputStreamReader(socket.getInputStream());
           
            BufferedReader input = new BufferedReader(inputStreamReader);
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
            
            Scanner scanner = new Scanner(System.in);
            String message;
            String response;

            do {
                System.out.print("Enter message >> ");
                message = scanner.nextLine();

                output.println(message);

                if(!message.equals("exit")) {
                    response = input.readLine();
                    System.out.println(response);
                }
                
            } while(!message.equals("exit"));
                        
        } catch(IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
