package Maps;

import MapComponents.AngledPlatform;
import MapComponents.Component;
import MapComponents.Platform;
import MapComponents.Stairs;
import PlayerCharacters.GenericPlayer;
import PlayerCharacters.Player;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Pillars extends JPanel {
    private MapFrame frame;
    //Map Components
    public static Platform floor = new Platform(0,93,100,7, Color.gray);
    public static Platform leftPillar = new Platform(0,55,10,45,Color.gray);
    public static Platform rightPillar = new Platform(90,55,11,45,Color.gray);
    //public static AngledPlatform walkUp = new AngledPlatform(50,40, 20,10, 0, Color.white);
    //public static Stairs stairs = new Stairs(35,40,35,80,65,80,Color.white);
    public static Platform middleLeftPillar = new Platform(25, 86, 12, 11, Color.gray);
    public static Platform middleRightPillar = new Platform(63, 86,12, 11, Color.gray);
    //public static Platform middlePillar = new Platform();


    //Players
    public static GenericPlayer p1 = new GenericPlayer(85, 60-7, Color.pink, "Pillars");
    public static GenericPlayer p2 = new GenericPlayer(15, 60-7, Color.cyan, "Pillars");

    public static ArrayList<Component> components = new ArrayList<>();
    private ArrayList<PlayerCharacters.Player> players = new ArrayList<>();

    public Pillars(MapFrame frame){
        this.frame = frame;
        setBackground(Color.BLACK);

        this.components.add(floor);
        this.components.add(leftPillar);
        this.components.add(rightPillar);
        this.components.add(middleLeftPillar);
        this.components.add(middleRightPillar);
        //this.components.add(walkUp);
        //this.components.add(stairs);

        this.players.add(p1);
        this.players.add(p2);
    }

    private int getWindowWidth(){
        return this.frame.getContentPane().getSize().width;
    }

    private int getWindowHeight(){
        return this.frame.getContentPane().getSize().height;
    }

    public void paint(Graphics g){
        super.paint(g);

        for (Component c: this.components){
            c.updateWidth(this.getWindowWidth());
            c.updateHeight(this.getWindowHeight());
            c.draw(g);
        }

        for(Player p: this.players){
            p.updateWidth(this.getWindowWidth());
            p.updateHeight(this.getWindowHeight());
            p.draw(g);
        }

        g.drawImage(frame.player,p1.xPos,p1.yPos,p1.w,p1.h,this);

        g.setColor(Color.green);
        g.drawString(MapFrame.getFPS() + "fps", 0, 10);
    }
}
