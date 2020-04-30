package Maps;

import GameModes.Hardpoint.CapturePoint;
import GameModes.Hardpoint.HardPointMode;
import MapComponents.*;
import MapComponents.Component;
import PlayerCharacters.GenericPlayer;
import PlayerCharacters.Player;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Pillars extends JPanel {
    private MapFrame frame;

    static InGameMenu menu = new InGameMenu(40,20,20,40);
    public static boolean menuPaused = false;

    public static CapturePoint centerCP = new CapturePoint(43,92, 16);
    public static CapturePoint leftPillarCP = new CapturePoint(0,54, 10);
    public static CapturePoint rightPillarCP = new CapturePoint(90,54,10);

    public static Thread points;


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
    public static GenericPlayer p1 /*= new GenericPlayer(85, 60-7, Color.pink, "Pillars",frame)*/;
    public static GenericPlayer p2;

    public ArrayList<Component> components = new ArrayList<>();
    public static ArrayList<CapturePoint> capturePoints = new ArrayList<>();
    private ArrayList<PlayerCharacters.Player> players = new ArrayList<>();

    public Pillars(MapFrame frame, String gameMode){
        this.frame = frame;
        setBackground(Color.BLACK);

        p1 = new GenericPlayer(85, 60-7, Color.pink, "Pillars",frame);
        p2 = new GenericPlayer(15, 60-7, Color.cyan, "Pillars",frame);

        this.components.add(floor);
        this.components.add(leftPillar);
        this.components.add(rightPillar);
        this.components.add(middleLeftPillar);
        this.components.add(middleRightPillar);

        this.players.add(p1);
        this.players.add(p2);



        if (gameMode.equals("HardPoint")){
            points = new Thread(new addPoint());
            HardPointMode hardPointMode = new HardPointMode("Pillars");
            hardPointMode.getMapFrame(frame);
            hardPointMode.getPillars(this);

            frame.multiInput.getHardPointMode(hardPointMode);
            frame.getHardPointMode(hardPointMode);



            capturePoints.add(centerCP);
            capturePoints.add(leftPillarCP);
            capturePoints.add(rightPillarCP);
        }

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

        for (CapturePoint cp : capturePoints){
            if (cp.active){
                cp.updateWidth(this.getWindowWidth());
                cp.updateHeight(this.getWindowHeight());
                cp.draw(g,Color.yellow);
                //int count = 0;
                //Timer timer = new Timer();
                if (cp.playerOnPoint(p1.getLeftX(),p1.getRightX(),p1.getBottomY())){
                    addPoint.onPoint = true;
                    p1.capturePoints(addPoint.getCount());
                } else {
                    addPoint.onPoint = false;
                }
            }
        }
        //System.out.println(addPoint.getCount());

        g.drawImage(frame.genPlayer, p1.xPos, p1.yPos, p1.w, p1.h,this);

        g.setColor(Color.green);
        g.drawString(MapFrame.getFPS() + "fps", 0, 10);

        g.setColor(Color.pink);
        g.drawString("Player 1 points: " + p1.points,updateX(80),updateY(10));

    }

    public static void checkPause(boolean paused){
        menuPaused = paused;
    }

    private int updateX(int x){
        return (int)(((double) x/100) * getWindowWidth());
    }
    private int updateY(int y){
        return (int)(((double) y/100) * getWindowHeight());
    }


    public void stopPoints() throws InterruptedException {
        points.join();
        //System.out.println("stopped point addition");
    }

    public static class addPoint implements Runnable {
        static int count = 0;
        static boolean onPoint;

        static boolean running = true;

        @Override
        public void run() {
            while (running){

                if (onPoint){
                    count = count + 1;
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }

        public static void startThread(){
            if (running){
                return;
            } else {
                //Thread.start();
                points.start();
                running = true;
            }
        }

        public static void stopThread() throws InterruptedException {
            running = false;


            if (!running) {
                return;
            } else {
                running = false;
//                try {
//                    thread.join();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                    System.exit(0);
//                }
//                this.dispose();
                points.join();
            }
        }

        public static int getCount(){
            return count;
        }
    }
}
