package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static final int port = 8888;
    private static final Game game = new Game();

    public static void main(String[] args) {
        RunServer();
    }

    public static void RunServer(){
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Waiting for connections...");
            while (true) {
                Socket socket = serverSocket.accept();
                new Thread(new ClientHandler(socket, game)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
