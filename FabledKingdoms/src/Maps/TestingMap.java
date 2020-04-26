package Maps;

import InputHandling.InputHandler;
import MapComponents.Component;
import MapComponents.Platform;
import PlayerCharacters.GenericPlayer;
import PlayerCharacters.Player;
import PlayerCharacters.TrainingPlayer;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;


public class TestingMap extends JPanel {
    private MapFrame frame;
    //Map Components
    public static Platform floor = new Platform(0,100 - 5,100,5,Color.gray);
    public static Platform leftPlatform = new Platform(20,60,15,5,Color.white);
    public static Platform rightPlatform = new Platform(80 - 15,60,15,5,Color.white);

    //Collision Components
    public static Platform leftPlatformTop = new Platform(leftPlatform.getLeftX()+1,leftPlatform.getTopY(),leftPlatform.w-2,1,Color.blue);
    public static Platform leftPlatformBottom = new Platform(leftPlatform.getLeftX()+1,leftPlatform.getBottomY(),leftPlatform.w-2,1,Color.blue);
    public static Platform leftPlatformLeft = new Platform(leftPlatform.getLeftX(),leftPlatform.getTopY(),1,leftPlatform.h,Color.blue);
    public static Platform leftPlatformRight = new Platform(leftPlatform.getRightX(),leftPlatform.getTopY(),1,leftPlatform.h,Color.blue);

    public static Platform rightPlatformTop = new Platform(rightPlatform.getLeftX()+1,rightPlatform.getTopY(),rightPlatform.w-2,1,Color.blue);
    public static Platform rightPlatformBottom = new Platform(rightPlatform.getLeftX()+1,rightPlatform.getBottomY(),rightPlatform.w-2,1,Color.blue);
    public static Platform rightPlatformLeft  = new Platform(rightPlatform.getLeftX(),rightPlatform.getTopY(),1,rightPlatform.h,Color.blue);
    public static Platform rightPlatformRight = new Platform(rightPlatform.getRightX(),rightPlatform.getTopY(),1,rightPlatform.h,Color.blue);

    //Players
    public static GenericPlayer p1 = new GenericPlayer(72,60-7, Color.pink, "TestingMap");
    public static GenericPlayer p2 = new GenericPlayer(27,60-7, Color.cyan, "TestingMap");
    public static TrainingPlayer trainingPlayer = new TrainingPlayer(57,100-5-7,Color.red);

    private ArrayList<MapComponents.Component> components = new ArrayList<>();
    private ArrayList<PlayerCharacters.Player> players = new ArrayList<>();



    public TestingMap(MapFrame frame){
        this.frame = frame;
        setBackground(Color.BLACK);

        this.components.add(floor);
        this.components.add(leftPlatform);
        this.components.add(rightPlatform);

//        this.players.add(p1);
//        this.players.add(p2);
        //this.players.add(trainingPlayer);

        //future note: depending on how many players are selected for the game
        // in the menu is how many will be added to the list
    }

    public TestingMap(MapFrame frame, Boolean offline){
        this.frame = frame;
        setBackground(Color.BLACK);

        this.components.add(floor);
        this.components.add(leftPlatform);
        this.components.add(rightPlatform);

        this.players.add(p1);
        this.players.add(p2);
        //this.players.add(trainingPlayer);

        //future note: depending on how many players are selected for the game
        // in the menu is how many will be added to the list
    }

    public void addPlayers(int playerID, int playerCount){
        this.players.add(p1);
        this.players.add(p2);
        InputHandler.getPlayerID(playerID);
    }

    private int getWindowWidth(){
        return this.frame.getContentPane().getSize().width;
    }

    private int getWindowHeight(){
        return this.frame.getContentPane().getSize().height;
    }

    private int spawnPointX(){
        Random r = new Random();
        int spawnLocation = r.nextInt(2);
        if(spawnLocation == 0){
            return 27;
        } else {
            return 72;
        }
    }
    private void spawnPointY(){

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        for(Component c: this.components){
            c.updateWidth(this.getWindowWidth());
            c.updateHeight(this.getWindowHeight());
            c.draw(g);
        }

        for(Player p: this.players){
            p.updateWidth(this.getWindowWidth());
            p.updateHeight(this.getWindowHeight());
            p.draw(g);
        }
        g.setColor(Color.green);
        g.drawString(MapFrame.getFPS()+ "fps",0,10);
    }
}

