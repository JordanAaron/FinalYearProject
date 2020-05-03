package Maps;

import GameModes.Hardpoint.CapturePoint;
import GameModes.Hardpoint.HardPointMode;
import InputHandling.MultiPlayerInputHandling;
import MapComponents.*;
import MapComponents.Component;
import PlayerCharacters.*;

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
    public static GenericPlayer gen;
    public static TrainingPlayer purp;
    public static Orange orange;
    public static GreenBlocBoy gbb;

    public ArrayList<Component> components = new ArrayList<>();
    public static ArrayList<CapturePoint> capturePoints = new ArrayList<>();
    private ArrayList<PlayerCharacters.Player> players = new ArrayList<>();


    public static String gamemode;

    public Pillars(MapFrame frame, String gameMode){
        this.frame = frame;
        this.gamemode = gameMode;
        setBackground(Color.BLACK);

//        gen = new GenericPlayer(85, 60-7, Color.pink, "Pillars",frame);
//        purp = new TrainingPlayer(15,60-7,Color.cyan,"Pillars", frame);

        this.components.add(floor);
        this.components.add(leftPillar);
        this.components.add(rightPillar);
        this.components.add(middleLeftPillar);
        this.components.add(middleRightPillar);

//        this.players.add(gen);
//        this.players.add(purp);


        if (gameMode.equals("HardPoint")){
            capturePoints.add(centerCP);
            capturePoints.add(leftPillarCP);
            capturePoints.add(rightPillarCP);

            points = new Thread(new addPoint());
            HardPointMode hardPointMode = new HardPointMode("Pillars");
            hardPointMode.getMapFrame(frame);
            hardPointMode.getPillars(this);

            frame.multiInput.getHardPointMode(hardPointMode);
            frame.getHardPointMode(hardPointMode);


        }
        if (MultiPlayerInputHandling.characters.get(0).equals("Gen")){
            gen = new GenericPlayer(85, 60-7, Color.pink, "Pillars", frame);
            this.players.add(gen);
        } else if (MultiPlayerInputHandling.characters.get(1).equals("Gen")){
            gen = new GenericPlayer(15, 60-7, Color.pink, "Pillars", frame);
            this.players.add(gen);
        }

        if (MultiPlayerInputHandling.characters.get(0).equals("Purp")){
            purp = new TrainingPlayer(85, 60-7, Color.cyan, "Pillars", frame);
            this.players.add(purp);
        } else if (MultiPlayerInputHandling.characters.get(1).equals("Purp")){
            purp = new TrainingPlayer(15, 60-7, Color.cyan, "Pillars", frame);
            this.players.add(purp);
        }

        if (MultiPlayerInputHandling.characters.get(0).equals("Orange")){
            orange = new Orange(85,60-7,Color.orange,"Pillars", frame);
            this.players.add(orange);
        } else if (MultiPlayerInputHandling.characters.get(1).equals("Orange")){
            orange = new Orange(15,60-7,Color.orange,"Pillars", frame);
            this.players.add(orange);
        }

        if (MultiPlayerInputHandling.characters.get(0).equals("GreenBlocBoy")){
            gbb = new GreenBlocBoy(85, 60-7, Color.green, "Pillars", frame);
            this.players.add(gbb);
        } else if (MultiPlayerInputHandling.characters.get(1).equals("GreenBlocBoy")){
            gbb = new GreenBlocBoy(15, 60-7, Color.green, "Pillars", frame);
            this.players.add(gbb);
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



        //System.out.println(addPoint.getCount());

        if (MultiPlayerInputHandling.characters.contains("Gen")){
            g.drawImage(frame.genPlayer, gen.xPos,gen.yPos,gen.w,gen.h,this);
        }

        if (MultiPlayerInputHandling.characters.contains("Purp")){
            g.drawImage(frame.purp, purp.xPos,purp.yPos,purp.w,purp.h,this);
        }

        if (MultiPlayerInputHandling.characters.contains("Orange")){
            g.drawImage(frame.orange, orange.xPos,orange.yPos,orange.w,orange.h,this);
        }

        if (MultiPlayerInputHandling.characters.contains("GreenBlocBoy")){
            g.drawImage(frame.greenBlocBoy, gbb.xPos,gbb.yPos,gbb.w,gbb.h,this);
        }


        for (CapturePoint cp : capturePoints){
            if (cp.active){
                cp.updateWidth(this.getWindowWidth());
                cp.updateHeight(this.getWindowHeight());
                cp.draw(g,Color.yellow);
                if (cp.playerOnPoint(gen.getLeftX(), gen.getRightX(), gen.getBottomY())){
                    addPoint.onPointP1 = true;
                    gen.capturePoints(addPoint.getCountP1());
                    //addPoint.setOnPointP1(true);
                } else {
                    addPoint.onPointP1 = false;
                }
                //System.out.println(gen.points);

                if (cp.playerOnPoint(purp.getLeftX(), purp.getRightX(), purp.getBottomY())){
                    addPoint.onPointP2 = true;
                    purp.capturePoints(addPoint.getCountP2());
                    //addPoint.setOnPointP1(true);
                } else {
                    addPoint.onPointP2 = false;
                    //addPoint.setOnPointP1(false);
                }
            }
        }


        //System.out.println(addPoint.getCount());

//        g.drawImage(frame.genPlayer, gen.xPos, gen.yPos, gen.w, gen.h,this);
//        g.drawImage(frame.purp, purp.xPos, purp.yPos, purp.w, purp.h,this);

        g.setColor(Color.green);
        g.drawString(MapFrame.getFPS() + "fps", 0, 10);

        g.setColor(Color.pink);
        g.drawString("Gen points: " + gen.points,updateX(80),updateY(10));

        g.setColor(Color.magenta);
        g.drawString("Purp points: " + purp.points,updateX(20),updateY(10));

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
        static int countP1 = 0, countP2 = 0;
        public static boolean onPointP1, onPointP2;

        static boolean running = true;



        @Override
        public void run() {
            while (running){
//                System.out.println("points.........");

                if (onPointP1){
                    countP1 = countP1 + 1;
                }

                if (onPointP2){
                    countP2 = countP2 + 1;
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

        public static int getCountP1(){
            return countP1;
        }

        public static int getCountP2(){
            return countP2;
        }
    }
}
