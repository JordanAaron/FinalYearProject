package Maps;

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
    //Players
    public static GenericPlayer p1 = new GenericPlayer(27,60-7,Color.cyan);
    public static TrainingPlayer trainingPlayer = new TrainingPlayer(57,100-5-7,Color.red);
    //MapComponents
    public static Platform floor = new Platform(0,100 - 5,100,5,Color.gray);
    public static Platform leftPlatform = new Platform(20,60,15,5,Color.white);
    public static Platform rightPlatform = new Platform(80 - 15,60,15,5,Color.white);

    private ArrayList<MapComponents.Component> components = new ArrayList<>();
    private ArrayList<PlayerCharacters.Player> players = new ArrayList<>();


    public TestingMap(MapFrame frame){
        this.frame = frame;
        setBackground(Color.BLACK);

        this.components.add(floor);
        this.components.add(leftPlatform);
        this.components.add(rightPlatform);

        this.players.add(p1);
        this.players.add(trainingPlayer);
        //future note: depending on how many players are selected for the game
        // in the menu is how many will be added to the list
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
