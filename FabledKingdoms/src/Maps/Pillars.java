package Maps;

import GameModes.Hardpoint.CapturePoint;
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

    //Collision stuff
    public static Platform leftPillarTop = new Platform(leftPillar.getLeftX()+2,leftPillar.getTopY(),leftPillar.w-3,1,Color.blue);
    public static Platform leftPillarRight = new Platform(leftPillar.getRightX(),leftPillar.getTopY(),1,leftPillar.h,Color.blue);

    public static Platform rightPillarTop = new Platform(rightPillar.getLeftX()+2,rightPillar.getTopY(),leftPillar.w-3,1,Color.blue);
    public static Platform rightPillarLeft = new Platform(rightPillar.getLeftX(),rightPillar.getTopY(),1,rightPillar.h,Color.blue);

    public static Platform middleLeftPillarTop = new Platform(middleLeftPillar.getLeftX()+2, middleLeftPillar.getTopY(),middleLeftPillar.w-3,1,Color.blue);
    public static Platform middleLeftPillarLeft = new Platform(middleLeftPillar.getLeftX(),middleLeftPillar.getTopY(),1,middleLeftPillar.h,Color.blue);
    public static Platform middleLeftPillarRight = new Platform(middleLeftPillar.getRightX(),middleLeftPillar.getTopY(),1,middleLeftPillar.h,Color.blue);

    public static Platform middleRightPillarTop = new Platform(middleRightPillar.getLeftX()+2, middleRightPillar.getTopY(),middleRightPillar.w-3,1,Color.blue);
    public static Platform middleRightPillarLeft = new Platform(middleRightPillar.getLeftX(),middleRightPillar.getTopY(),1,middleRightPillar.h,Color.blue);
    public static Platform middleRightPillarRight = new Platform(middleRightPillar.getRightX(),middleRightPillar.getTopY(),1,middleRightPillar.h,Color.blue);


    //Players
    public static GenericPlayer p1 = new GenericPlayer(85, 60-7, Color.pink, "Pillars");
    public static GenericPlayer p2 = new GenericPlayer(15, 60-7, Color.cyan, "Pillars");

    public ArrayList<Component> components = new ArrayList<>();
    public ArrayList<CapturePoint> capturePoints = new ArrayList<>();
    private ArrayList<PlayerCharacters.Player> players = new ArrayList<>();

    public Pillars(MapFrame frame){
        this.frame = frame;
        setBackground(Color.BLACK);

        this.components.add(floor);
        this.components.add(leftPillar);
        this.components.add(rightPillar);
        this.components.add(middleLeftPillar);
        this.components.add(middleRightPillar);

//        collision plats
//        this.components.add(leftPillarTop);
//        this.components.add(leftPillarRight);
//
//        this.components.add(rightPillarTop);
//        this.components.add(rightPillarLeft);
//
//        this.components.add(middleLeftPillarTop);
//        this.components.add(middleLeftPillarLeft);
//        this.components.add(middleLeftPillarRight);
//
//        this.components.add(middleRightPillarTop);
//        this.components.add(middleRightPillarLeft);
//        this.components.add(middleRightPillarRight);

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

        for (CapturePoint cp: capturePoints){
            cp.updateWidth(this.getWindowWidth());
            cp.updateHeight(this.getWindowHeight());
            cp.draw(g);
        }

        g.drawImage(frame.player,p1.xPos,p1.yPos,p1.w,p1.h,this);

        g.setColor(Color.green);
        g.drawString(MapFrame.getFPS() + "fps", 0, 10);

//        try {
//            runHardPoint();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }

    private void runHardPoint() throws InterruptedException {
        CapturePoint hill1 = new CapturePoint(10,10);
        CapturePoint hill2 = new CapturePoint(20,10);
        capturePoints.add(hill1);
        capturePoints.add(hill2);

        for (CapturePoint cp: capturePoints){
           cp.setActive(true);
           Thread.sleep(5000);
           cp.setActive(false);
        }
        //add components and then take them away after a set amount of time

        //when a component is removed add the next one
    }
}
