package OnlineConnectivity.Server;


import java.util.HashMap;
import java.util.Map;

//update players positions in this class
public class Game {
    //private ArrayList<ClientHandler> players;
    private Map<Integer,ClientHandler> players;
    int count, playerID;

    Game(){
       players = new HashMap<>();
       count = 0;
    }

    int newPlayer(ClientHandler player){
        count++;
        //playerID = new Random().nextInt(11);
        playerID = count;
        if (players.containsKey(playerID)){
            //Check if the max number of players have been added
            //If it has then print lobby full or something like that
            //Otherwise generate a new number
        }
        players.put(playerID, player);
        return playerID;
    }

    int getPlayerCount(){
        //System.out.println("No. of players: "+ players.size());
        return players.size();
    }

    void directMessage(int playerID, String data){
        players.get(playerID).send(data);
    }

    void messageOtherPlayers(int playerSending, String data){
        for (ClientHandler c : players.values()){
            if (c.playerID != playerSending){
                c.send(data);
            }
        }
    }
}
