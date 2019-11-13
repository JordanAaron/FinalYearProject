package Maps;

import MapComponents.Component;
import MapComponents.Platform;
import PlayerCharacters.GenericPlayer;
import PlayerCharacters.Player;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;


public class TestingMap extends JPanel {
    private MapFrame frame;

    public static GenericPlayer p1 = new GenericPlayer(27,60-7,Color.cyan);

    public static Platform floor = new Platform(0,100 - 5,100,5,Color.green,true);
    public static Platform leftPlatform = new Platform(20,60,15,5,Color.white,true);
    public static Platform rightPlatform = new Platform(80 - 15,60,15,5,Color.white,true);

    //initialising lists for the components to be added to the map
    ArrayList<MapComponents.Component> components = new ArrayList<>();
    ArrayList<PlayerCharacters.Player> players = new ArrayList<>();


    public TestingMap(MapFrame frame){
        this.frame = frame;

        setBackground(Color.BLACK);

        //Map component positions
        this.components.add(floor);//floor
        this.components.add(leftPlatform);//left platform
        this.components.add(rightPlatform);//right platform

        //Player positions
        this.players.add(p1);
        //this.players.add(new GenericPlayer(spawnPointX(),60-7,Color.cyan));
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

//    public static boolean colliding(int x, int y, TestingMap m) {
//        for(Component c: m.components) {
//            if (c.colliding(x,y)) {
//                return true;
//            }
//        }
//        return false;
//    }

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

        //System.out.println("Drawing");
    }
}
