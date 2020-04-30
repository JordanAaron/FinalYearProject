package Maps;

import MapComponents.Component;
import MapComponents.InGameMenu;
import MapComponents.Platform;
import PlayerCharacters.GenericPlayer;
import PlayerCharacters.Player;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Blockage extends JPanel {
    private  MapFrame frame;

    static InGameMenu menu = new InGameMenu(40,20,20,40);
    public static boolean menuPaused = false;

    //MapComponents
    public static Platform floor = new Platform(0,100-5,100,5, Color.gray);
    public static Platform block = new Platform(31,50,38,25, Color.white); //height is 20
    public static Platform leftPlatform = new Platform(8,60,15,5, Color.white);
    public static Platform rightPlatform = new Platform(77,60,15,5, Color.white);
    public static Platform topPlatform = new Platform(37,35,26,5, Color.white);

    //Collision Checkers
    public static Platform blockTop = new Platform(block.getLeftX()+2,block.getTopY(),block.w-3,1,Color.blue);
    public static Platform blockBottom = new Platform(block.getLeftX()+2,block.getBottomY(),block.w-3,1,Color.blue);
    public static Platform blockLeft = new Platform(block.getLeftX(),block.getTopY(),1,block.h,Color.blue);
    public static Platform blockRight = new Platform(block.getRightX(),block.getTopY(),1,block.h,Color.blue);

    public static Platform leftPlatformTop = new Platform(leftPlatform.getLeftX()+2,leftPlatform.getTopY(),leftPlatform.w-3,1,Color.blue);
    public static Platform leftPlatformBottom = new Platform(leftPlatform.getLeftX()+2,leftPlatform.getBottomY(),leftPlatform.w-3,1,Color.blue);
    public static Platform leftPlatformLeft = new Platform(leftPlatform.getLeftX(),leftPlatform.getTopY(),1,leftPlatform.h,Color.blue);
    public static Platform leftPlatformRight = new Platform(leftPlatform.getRightX(),leftPlatform.getTopY(),1,leftPlatform.h,Color.blue);

    public static Platform rightPlatformTop = new Platform(rightPlatform.getLeftX()+2,rightPlatform.getTopY(),rightPlatform.w-3,1,Color.blue);
    public static Platform rightPlatformBottom = new Platform(rightPlatform.getLeftX()+2,rightPlatform.getBottomY(),rightPlatform.w-3,1,Color.blue);
    public static Platform rightPlatformLeft = new Platform(rightPlatform.getLeftX(),rightPlatform.getTopY(),1,rightPlatform.h,Color.blue);
    public static Platform rightPlatformRight = new Platform(rightPlatform.getRightX(),rightPlatform.getTopY(),1,rightPlatform.h,Color.blue);

    public static Platform topPlatformTop = new Platform(topPlatform.getLeftX() + 2,topPlatform.getTopY(),topPlatform.w-3,1,Color.blue);
    public static Platform topPlatformBottom = new Platform(topPlatform.getLeftX() + 2,topPlatform.getBottomY(),topPlatform.w-3,1,Color.blue);
    public static Platform topPlatformLeft = new Platform(topPlatform.getLeftX(),topPlatform.getTopY(),1,topPlatform.h,Color.blue);
    public static Platform topPlatformRight = new Platform(topPlatform.getRightX(),topPlatform.getTopY(),1,topPlatform.h,Color.blue);

    //Players
    public static GenericPlayer p1 = new GenericPlayer(85, 60-7, Color.pink, "Blockage", null);
    public static GenericPlayer p2 = new GenericPlayer(15, 60-7, Color.cyan, "Blockage", null);


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

        if (menuPaused){
            menu.updateWidth(this.getWindowWidth());
            menu.updateHeight(this.getWindowHeight());
            menu.draw(g, Color.pink);
        }

        g.setColor(Color.green);
        g.drawString(MapFrame.getFPS() + "fps", 0, 10);
    }

    public static void checkPause(boolean paused){
        if (paused){
            menuPaused = true;
        } else{
            menuPaused = false;
        }
    }
}
