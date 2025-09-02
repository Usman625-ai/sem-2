import java.io.*;
import java.net.*;

public class threadedsingleclientserver {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(5000);
            System.out.println("Server started on port 5000...");

            while (true) {
                System.out.println("Waiting for client...");
                Socket socket = serverSocket.accept();
                System.out.println("Client connected: " + socket.getInetAddress());

                // Create a worker thread for this client
                ClientHandler handler = new ClientHandler(socket);
                Thread t = new Thread(handler);
                t.start();

                // Wait until this thread finishes before accepting the next client
                t.join(); 
                System.out.println("Ready for next client...\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

// Worker thread (serves one client until "exit")
class ClientHandler implements Runnable {
    private Socket socket;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        ) {
            String message;
            while ((message = in.readLine()) != null) {
                System.out.println("Client: " + message);

                if (message.equalsIgnoreCase("exit")) {
                    System.out.println("Client disconnected.");
                    break;
                }

                out.println("Server received: " + message);
            }
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
