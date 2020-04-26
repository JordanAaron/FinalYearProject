package OnlineConnectivity.Client;


import Maps.TestingMap;


import java.io.IOException;
import java.net.Socket;


public class Client /*implements AutoCloseable*/{
    final int port = 8888;

    Socket socket = new Socket("localhost", port);
    private GameServer gameServer;

    TestingMap testingMap;

    public Client() throws Exception {
        //mapSelection("TestingMap");

    }

    //make it so that if anything changes on the screen that's when you send a message

    public void playerCountRequest(){
        gameServer.send("PLAYERCOUNT");
    }

    public void playerMovement(int xPos, int yPos) {
        gameServer.send("POSITION " + xPos + " " + yPos);
    }

    public void mapSelection(String map){
        gameServer.send("MAP " + map);
    }

    public void giveMeMapReference(TestingMap testingMap) throws IOException {
        this.testingMap = testingMap;

        gameServer = new GameServer(socket, this.testingMap);
        Thread thread = new Thread(gameServer);
        thread.start();
    }

    public static boolean playerMoved(boolean status){
        return status;
    }
}
