import java.io.*;
import java.net.*;

class ClientHandler extends Thread {
    private Socket clientSocket;

    public ClientHandler(Socket socket) {
        this.clientSocket = socket;
    }

    @Override
    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            out.println("Connected. Type 'exit' to quit");

            String message;
            while ((message = in.readLine()) != null) {
                if (message.equalsIgnoreCase("exit")) {
                    out.println("Goodbye");
                    break;
                }
                out.println(message);
            }

            clientSocket.close();
            System.out.println("disconnected");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

public class MultiClientServer {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(5000)) {
            System.out.println("Server started");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected");

                ClientHandler handler = new ClientHandler(clientSocket);
                handler.start(); 
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
