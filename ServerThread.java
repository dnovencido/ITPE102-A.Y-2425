package tcpsocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author denver
 */
class ServerThread extends Thread {
    private final Socket socket;

    public ServerThread(Socket socket) {
        this.socket = socket;
    }
    
    @Override
    public void run() {
        try {
            
            InputStreamReader inputStreamReader =  new InputStreamReader(socket.getInputStream());
            
            BufferedReader input = new BufferedReader(inputStreamReader);
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

            while(true) {
                String message = input.readLine();

                if(message.equals("exit")) {
                    break;
                }

                System.out.println("Message from client : " + message);
                output.println("Echo from server: " + message);
            }			
        } catch(IOException e){
            System.out.println("Error message : " + e.getMessage());
	} finally {
            try {
                socket.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
