package Maps;

import GameModes.Hardpoint.CapturePoint;
import GameModes.Hardpoint.HardPointMode;
import InputHandling.MultiPlayerInputHandling;
import MapComponents.Component;
import MapComponents.InGameMenu;
import MapComponents.Platform;
import PlayerCharacters.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class CenterCore extends JPanel {
    private MapFrame frame;

    static InGameMenu menu = new InGameMenu(40,20,20,40);
    public static boolean menuPaused = false;

    public static CapturePoint middleCP = new CapturePoint(45,94,10);
    public static CapturePoint LBaseCP = new CapturePoint(28,59,16);
    public static CapturePoint rightSpawnCP = new CapturePoint(85,94,15);
    public static CapturePoint leftSpawnCP = new CapturePoint(0,94,15);
    public static CapturePoint JBaseCP = new CapturePoint(56,59,16);

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
    public static GenericPlayer gen;
    public static TrainingPlayer purp;
    public static Orange orange;
    public static GreenBlocBoy gbb;

    private ArrayList<Component> components = new ArrayList<>();
    private ArrayList<PlayerCharacters.Player> players = new ArrayList<>();
    public static ArrayList<CapturePoint> capturePoints = new ArrayList<>();

    public CenterCore(MapFrame frame){
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

        if (MultiPlayerInputHandling.characters.get(0).equals("Gen")){
            gen = new GenericPlayer(90, 60, Color.pink, "CenterCore", frame);
            this.players.add(gen);
        } else if (MultiPlayerInputHandling.characters.get(1).equals("Gen")){
            gen = new GenericPlayer(6, 60, Color.pink, "CenterCore", frame);
            this.players.add(gen);
        }

        if (MultiPlayerInputHandling.characters.get(0).equals("Purp")){
            purp = new TrainingPlayer(90, 60, Color.cyan, "CenterCore", frame);
            this.players.add(purp);
        } else if (MultiPlayerInputHandling.characters.get(1).equals("Purp")){
            purp = new TrainingPlayer(6, 60, Color.cyan, "CenterCore", frame);
            this.players.add(purp);
        }

        if (MultiPlayerInputHandling.characters.get(0).equals("Orange")){
            orange = new Orange(90, 60,Color.orange,"CenterCore", frame);
            this.players.add(orange);
        } else if (MultiPlayerInputHandling.characters.get(1).equals("Orange")){
            orange = new Orange(6, 60, Color.orange,"CenterCore", frame);
            this.players.add(orange);
        }

        if (MultiPlayerInputHandling.characters.get(0).equals("GreenBlocBoy")){
            gbb = new GreenBlocBoy(90, 60, Color.green, "CenterCore", frame);
            this.players.add(gbb);
        } else if (MultiPlayerInputHandling.characters.get(1).equals("GreenBlocBoy")){
            gbb = new GreenBlocBoy(6, 60, Color.green, "CenterCore", frame);
            this.players.add(gbb);
        }
    }

    public CenterCore(MapFrame frame, String gameMode){
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

        if (MultiPlayerInputHandling.characters.get(0).equals("Gen")){
            gen = new GenericPlayer(90, 60, Color.pink, "CenterCore", frame);
            this.players.add(gen);
        } else if (MultiPlayerInputHandling.characters.get(1).equals("Gen")){
            gen = new GenericPlayer(6, 60, Color.pink, "CenterCore", frame);
            this.players.add(gen);
        }

        if (MultiPlayerInputHandling.characters.get(0).equals("Purp")){
            purp = new TrainingPlayer(90, 60, Color.cyan, "CenterCore", frame);
            this.players.add(purp);
        } else if (MultiPlayerInputHandling.characters.get(1).equals("Purp")){
            purp = new TrainingPlayer(6, 60, Color.cyan, "CenterCore", frame);
            this.players.add(purp);
        }

        if (MultiPlayerInputHandling.characters.get(0).equals("Orange")){
            orange = new Orange(90, 60,Color.orange,"CenterCore", frame);
            this.players.add(orange);
        } else if (MultiPlayerInputHandling.characters.get(1).equals("Orange")){
            orange = new Orange(6, 60, Color.orange,"CenterCore", frame);
            this.players.add(orange);
        }

        if (MultiPlayerInputHandling.characters.get(0).equals("GreenBlocBoy")){
            gbb = new GreenBlocBoy(90, 60, Color.green, "CenterCore", frame);
            this.players.add(gbb);
        } else if (MultiPlayerInputHandling.characters.get(1).equals("GreenBlocBoy")){
            gbb = new GreenBlocBoy(6, 60, Color.green, "CenterCore", frame);
            this.players.add(gbb);
        }

        new HardPointMode("CenterCore");

        if (gameMode.equals("HardPoint")){
            capturePoints.add(middleCP);
            capturePoints.add(LBaseCP);
            capturePoints.add(rightSpawnCP);
            capturePoints.add(leftSpawnCP);
            capturePoints.add(JBaseCP);
        }
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
        }

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

            }
//            if (cp.playerOnPoint(gen.getLeftX(), gen.getRightX(), gen.getBottomY())){
//                Pillars.addPoint.onPoint = true;
//                gen.capturePoints(Pillars.addPoint.getCount());
//            } else {
//                Pillars.addPoint.onPoint = false;
//            }
        }

        g.setColor(Color.green);
        g.drawString(MapFrame.getFPS()+ "fps",0,10);

//        g.setColor(Color.pink);
//        g.drawString("Player 1 points: " + gen.points,updateX(80),updateY(10));
    }


    private int updateX(int x){
        return (int)(((double) x/100) * getWindowWidth());
    }
    private int updateY(int y){
        return (int)(((double) y/100) * getWindowHeight());
    }
    public static void checkPause(boolean paused){
        if (paused){
            menuPaused = true;
        } else{
            menuPaused = false;
        }
    }
}
