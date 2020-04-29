package Maps;

import MapComponents.Component;
import MapComponents.InGameMenu;
import MapComponents.Platform;
import PlayerCharacters.GenericPlayer;
import PlayerCharacters.Player;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class CenterCore extends JPanel {
    private MapFrame frame;

    static InGameMenu menu = new InGameMenu(40,20,20,40);
    public static boolean menuPaused = false;

    //Map Components
    public static Platform floor = new Platform(0,100 - 5,100,5, Color.gray);

    public static Platform middlePlatform = new Platform(34,77,32,7,Color.white);

    public static Platform LBase = new Platform(28,60,16,7,Color.white);
    public static Platform LHeight = new Platform(24,35,4,32,Color.white);

    public static Platform JBase = new Platform(56,60,16,7,Color.white);
    public static Platform JHeight = new Platform(72,35,4,32,Color.white);

    public static Platform leftWall = new Platform(15,80,4,15,Color.gray);
    public static Platform rightWall = new Platform(81,80,4,15,Color.gray);

    //Collision Components
    public static Platform middlePlatformTop = new Platform(middlePlatform.getLeftX()+2, middlePlatform.getTopY(), middlePlatform.w-3,1,Color.blue);
    public static Platform middlePlatformBottom = new Platform(middlePlatform.getLeftX()+2, middlePlatform.getBottomY(), middlePlatform.w-3,1,Color.blue);
    public static Platform middlePlatformLeft = new Platform(middlePlatform.getLeftX(), middlePlatform.getTopY(),1, middlePlatform.h,Color.blue);
    public static Platform middlePlatformRight = new Platform(middlePlatform.getRightX(), middlePlatform.getTopY(),1, middlePlatform.h,Color.blue);

    public static Platform LBaseTop = new Platform(LBase.getLeftX()+2,LBase.getTopY(),LBase.w-3,1,Color.blue);
    public static Platform LBaseBottom = new Platform(LBase.getLeftX()+2, LBase.getBottomY(), LBase.w-3,1,Color.blue);
    public static Platform LBaseLeft = new Platform(LBase.getLeftX(), LBase.getTopY(),1, LBase.h,Color.blue);
    public static Platform LBaseRight = new Platform(LBase.getRightX(), LBase.getTopY(),1, LBase.h,Color.blue);

    public static Platform LHeightTop = new Platform(LHeight.getLeftX()+2,LHeight.getTopY(),LHeight.w-3,1,Color.blue);
    public static Platform LHeightBottom = new Platform(LHeight.getLeftX()+2, LHeight.getBottomY(), LHeight.w-3,1,Color.blue);
    public static Platform LHeightLeft = new Platform(LHeight.getLeftX(), LHeight.getTopY(),1, LHeight.h,Color.blue);
    public static Platform LHeightRight = new Platform(LHeight.getRightX(),LHeight.getTopY(),1,LHeight.h - 2,Color.blue);

    public static Platform JBaseTop = new Platform(JBase.getLeftX()+2,JBase.getTopY(),JBase.w-3,1,Color.blue);
    public static Platform JBaseBottom = new Platform(JBase.getLeftX()+2, JBase.getBottomY(), JBase.w-3,1,Color.blue);
    public static Platform JBaseLeft = new Platform(JBase.getLeftX(), JBase.getTopY(),1, JBase.h,Color.blue);
    public static Platform JBaseRight = new Platform(JBase.getRightX(), JBase.getTopY(),1, JBase.h,Color.blue);

    public static Platform JHeightTop = new Platform(JHeight.getLeftX()+2,JHeight.getTopY(),JHeight.w-3,1,Color.blue);
    public static Platform JHeightBottom = new Platform(JHeight.getLeftX()+2, JHeight.getBottomY(), JHeight.w-3,1,Color.blue);
    public static Platform JHeightLeft = new Platform(JHeight.getLeftX(), JHeight.getTopY(),1, JHeight.h,Color.blue);
    public static Platform JHeightRight = new Platform(JHeight.getRightX(),JHeight.getTopY(),1,JHeight.h - 2,Color.blue);

    public static Platform leftWallTop = new Platform(leftWall.getLeftX()+2,leftWall.getTopY(),leftWall.w-3,1,Color.blue);
    public static Platform leftWallLeft = new Platform(leftWall.getLeftX(),leftWall.getTopY(),1,leftWall.h,Color.blue);
    public static Platform leftWallRight = new Platform(leftWall.getRightX(),leftWall.getTopY(),1,leftWall.h,Color.blue);

    public static Platform rightWallTop = new Platform(rightWall.getLeftX()+2,rightWall.getTopY(),rightWall.w-3,1,Color.blue);
    public static Platform rightWallLeft = new Platform(rightWall.getLeftX(),rightWall.getTopY(),1,rightWall.h,Color.blue);
    public static Platform rightWallRight = new Platform(rightWall.getRightX(),rightWall.getTopY(),1,rightWall.h,Color.blue);

    //Players
    public static GenericPlayer p1 = new GenericPlayer(90,60, Color.pink, "CenterCore");
    public static GenericPlayer p2 = new GenericPlayer(6,60, Color.cyan, "CenterCore");

    private ArrayList<Component> components = new ArrayList<>();
    private ArrayList<PlayerCharacters.Player> players = new ArrayList<>();

    public CenterCore(MapFrame frame, Boolean offline){
        this.frame = frame;
        setBackground(Color.black);

        this.components.add(floor);
        this.components.add(middlePlatform);
        this.components.add(LBase);
        this.components.add(LHeight);
        this.components.add(JBase);
        this.components.add(JHeight);
        this.components.add(leftWall);
        this.components.add(rightWall);

        this.players.add(p1);
        this.players.add(p2);
    }

    private int getWindowWidth(){
        return this.frame.getContentPane().getSize().width;
    }

    private int getWindowHeight(){
        return this.frame.getContentPane().getSize().height;
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

        if (menuPaused){
            menu.updateWidth(this.getWindowWidth());
            menu.updateHeight(this.getWindowHeight());
            menu.draw(g, Color.pink);
        } else {
            menu.updateWidth(this.getWindowWidth());
            menu.updateHeight(this.getWindowHeight());
            menu.draw(g, Color.black);
        }

        g.setColor(Color.green);
        g.drawString(MapFrame.getFPS()+ "fps",0,10);
    }

    public static void checkPause(boolean paused){
        if (paused){
            menuPaused = true;
        } else{
            menuPaused = false;
        }
    }
}
