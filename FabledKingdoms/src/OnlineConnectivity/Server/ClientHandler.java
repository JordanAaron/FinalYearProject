package OnlineConnectivity.Server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientHandler implements Runnable{
    private final Socket socket;
    private Game game;

    private Scanner reader;
    private PrintWriter writer;

    public int playerID;

    public ClientHandler(Socket socket, Game game) throws IOException {
        this.socket = socket;
        this.game = game;
        reader = new Scanner(socket.getInputStream());
        writer = new PrintWriter(socket.getOutputStream());

        playerID = game.newPlayer(this);
        System.out.println("Player "+ playerID +" Connected");
        send("JOINED " + playerID + " " + game.getPlayerCount());
    }

    @Override
    public void run() {
        try {
            while (true) {
                String line = reader.nextLine();
                //System.out.println("received: " + line);
                String[] word = line.split(" ");

                switch (word[0]){
                    case "MAP":
                        //System.out.println("map is " + line);
                        send("MAP " + word[1]);
                        break;
                    case "POSITION":
                        //System.out.println(this.playerID + ": xPos-" + word[1] + ", yPos-" + word[2]);
                        //send("PLAYERMOVED " + this.playerID + " " + word[1] + " " + word[2]);
                        game.messageOtherPlayers(this.playerID,"PLAYERMOVED " + this.playerID + " " + word[1] + " " + word[2]);
                        break;
                }
            }
        } catch (Exception e){}
    }

    void send(String data){
        writer.println(data);
        writer.flush();
    }
}