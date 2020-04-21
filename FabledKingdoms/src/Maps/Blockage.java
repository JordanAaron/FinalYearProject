package Maps;

import MapComponents.Component;
import MapComponents.Platform;
import PlayerCharacters.GenericPlayer;
import PlayerCharacters.Player;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Blockage extends JPanel {
    private  MapFrame frame;
    //MapComponents
    public static Platform floor = new Platform(0,100-5,100,5, Color.gray);
    public static Platform block = new Platform(31,50,38,5, Color.white); //height is 20
    public static Platform leftPlatform = new Platform(8,60,15,5, Color.white);
    public static Platform rightPlatform = new Platform(77,60,15,5, Color.white);
    public static Platform topPlatform = new Platform(37,35,26,5, Color.white);

    //Players
    public static GenericPlayer p1 = new GenericPlayer(85, 60-7, Color.pink, "Blockage");
    public static GenericPlayer p2 = new GenericPlayer(15, 60-7, Color.cyan, "Blockage");


    private ArrayList<MapComponents.Component> components = new ArrayList<>();
    private ArrayList<PlayerCharacters.Player> players = new ArrayList<>();

    public Blockage(MapFrame frame){
        this.frame = frame;
        setBackground(Color.BLACK);

        this.components.add(floor);
        this.components.add(block);
        this.components.add(leftPlatform);
        this.components.add(rightPlatform);
        this.components.add(topPlatform);

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

        g.setColor(Color.green);
        g.drawString(MapFrame.getFPS() + "fps", 0, 10);
    }
}
