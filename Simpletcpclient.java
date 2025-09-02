import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Simpletcpclient {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 5000);
            System.out.println("Connected to server!");

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            Scanner sc = new Scanner(System.in);

            String input;
            while (true) {
                System.out.print("You: ");
                input = sc.nextLine();
                out.println(input);

                if (input.equalsIgnoreCase("exit")) {
                    System.out.println("Exiting...");
                    break;
                }

                String response = in.readLine();
                System.out.println("Server: " + response);
            }

            socket.close();
            sc.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
// client code will be same Simpletcpclient