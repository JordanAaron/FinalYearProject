package OnlineConnectivity.Client;

import Maps.TestingMap;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class GameServer implements Runnable{
    private Scanner reader;
    private PrintWriter writer;

    TestingMap testingMap;

    GameServer(Socket socket, TestingMap testingMap) throws IOException {
        this.reader = new Scanner(socket.getInputStream());
        this.writer = new PrintWriter(socket.getOutputStream());
        this.testingMap = testingMap;
    }




    @Override
    public void run() {
        try{
            while (true){
                String line = reader.nextLine();
                String[] words = line.split(" ");

                switch(words[0]){
                    case "JOINED":
                        int id = Integer.parseInt(words[1]);
                        int playerCount = Integer.parseInt(words[2]);
                        System.out.println("You are player " + id);
                        testingMap.addPlayers(id, playerCount);
                        break;
                    case "DISCONNECTED":
                        break;
                    case "MAP":
                        System.out.println("Map is " + words[1]);
                        if (words[1].equals("TestingMap")){
                            System.out.println("it worked");
                            //runTestingMap();
                        }
                        break;
                    case "PLAYERMOVED":
                        int playerID = Integer.parseInt(words[1]);
                        int xPos = Integer.parseInt(words[2]), yPos = Integer.parseInt(words[3]);

                        if (playerID == 1){
                            testingMap.p1.onlineMovement(xPos, yPos);
                        }

                        if (playerID == 2){
                            testingMap.p2.onlineMovement(xPos,yPos);
                        }
                        break;
                }
            }
        } catch (java.util.NoSuchElementException e){

        } catch (Exception e){

        }
    }

    void send(String data){
        this.writer.println(data);
        this.writer.flush();
    }

}
