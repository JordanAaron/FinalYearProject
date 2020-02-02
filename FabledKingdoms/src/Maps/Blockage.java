package Maps;

import MapComponents.Component;
import MapComponents.Platform;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Blockage extends JPanel {
    private  MapFrame frame;
    //MapComponents
    public static Platform floor = new Platform(0,100-5,100,5, Color.gray);
    public static Platform block = new Platform(31,50,38,20,Color.white);
    public static Platform leftPlatform = new Platform(8,60,15,5,Color.white);
    public static Platform rightPlatform = new Platform(77,60,15,5,Color.white);
    public static Platform topPlatform = new Platform(37,35,26,5,Color.white);


    private ArrayList<MapComponents.Component> components = new ArrayList<>();

    public Blockage(MapFrame frame){
        this.frame = frame;
        setBackground(Color.BLACK);

        this.components.add(floor);
        this.components.add(block);
        this.components.add(leftPlatform);
        this.components.add(rightPlatform);
        this.components.add(topPlatform);
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
