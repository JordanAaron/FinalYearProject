package Maps;

import MapComponents.AngledPlatform;
import MapComponents.Component;
import MapComponents.Platform;
import MapComponents.Stairs;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Pillars extends JPanel {
    private MapFrame frame;
    //Map Components
    public static Platform floor = new Platform(0,100-5,100,5, Color.gray);
    public static Platform leftPillar = new Platform(0,65,15,35,Color.gray);
    public static Platform rightPillar = new Platform(85,65,15,35,Color.gray);
    public static AngledPlatform walkUp = new AngledPlatform(35,40, 65,80,Color.white);
    public static Stairs stairs = new Stairs(35,40,35,60,70,60,Color.white);

    private ArrayList<Component> components = new ArrayList<>();

    public Pillars(MapFrame frame){
        this.frame = frame;
        setBackground(Color.BLACK);

        this.components.add(floor);
        this.components.add(leftPillar);
        this.components.add(rightPillar);
        this.components.add(walkUp);
        this.components.add(stairs);
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
        g.setColor(Color.green);
        g.drawString(MapFrame.getFPS() + "fps", 0, 10);
    }
}
