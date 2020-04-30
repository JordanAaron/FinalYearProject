package Maps;

import GameModes.Hardpoint.HardPointMode;
import OnlineConnectivity.Client.Client;
import InputHandling.InputHandler;
import InputHandling.MultiPlayerInputHandling;
import Sprites.BufferedImageLoader;
import Sprites.SpriteSheet;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;


public class MapFrame extends JFrame implements Runnable {
    private static Thread thread;
    public static boolean running;
    public boolean paused;
    private static int fps;

    private Client client;

    InputHandler input;
    public static MultiPlayerInputHandling multiInput = new MultiPlayerInputHandling();

    private BufferedImage spriteSheet_Gen = null;
    private BufferedImage spriteSheet_TrainingPlayer = null;
    private BufferedImage spriteSheet_Orange = null;
    private BufferedImage spriteSheet_GreenBlocBoy = null;


    public static BufferedImage genPlayer, trainingPlayer,orange,greenBlocBoy;
    public SpriteSheet genericPlayerSS, trainingPlayerSS,orangeSS,greenBlocBoySS;

    private HardPointMode hardPointMode;
    public void getHardPointMode(HardPointMode hardPointMode){this.hardPointMode = hardPointMode;}


    public boolean upArrow, rightArrow = false, leftArrow = false;

    public MapFrame(Client client) throws IOException {
        this.client = client;

        setPreferredSize(new Dimension(800, 600));
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setFocusable(true);

        //add if statement to distinguish multi from single
        addKeyListener(input = new InputHandler());
        //addKeyListener(new MultiPlayerInputHandling());

        //start();
    }

    public MapFrame() {
        setPreferredSize(new Dimension(800, 600));
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setFocusable(true);

        paused = false;

        //add if statement to distinguish multi from single
        //addKeyListener(input = new InputHandler());
        addKeyListener(multiInput);
        addMouseListener(multiInput);
        multiInput.getMapFrame(this);

        upArrow = false;

        startThread();
    }

    public void init(){
        BufferedImageLoader loader = new BufferedImageLoader();
        try {
            spriteSheet_Gen = loader.loadImage("FabledKingdoms\\Res\\SpriteSheets\\SpriteSheet_Gen.png");
            spriteSheet_TrainingPlayer = loader.loadImage("FabledKingdoms\\Res\\SpriteSheets\\SpriteSheet_TrainingPlayer.png");
            spriteSheet_Orange = loader.loadImage("FabledKingdoms\\Res\\SpriteSheets\\SpriteSheet_Orange.png");
            spriteSheet_GreenBlocBoy = loader.loadImage("FabledKingdoms\\Res\\SpriteSheets\\SpriteSheet_GreenBlocBoy.png");
        } catch (IOException e){
            e.printStackTrace();
        }

        genericPlayerSS = new SpriteSheet(spriteSheet_Gen);
        trainingPlayerSS = new SpriteSheet(spriteSheet_TrainingPlayer);
        orangeSS = new SpriteSheet(spriteSheet_Orange);
        greenBlocBoySS = new SpriteSheet(spriteSheet_GreenBlocBoy);
    }

    public void startThread() {
        if (running) {
            return;
        } else {
            running = true;
            thread = new Thread(this);
            thread.start();
            System.out.println("Running...");
        }
    }

    public void pauseGame() {
        if (paused){
            return;
        } else {
            paused = true;
            if(HardPointMode.running){
                hardPointMode.paused = true;
            }
        }
    }

    public void resumeGame() throws InterruptedException {
        if (!paused){
            return;
        } else{
            paused = false;
            if (HardPointMode.running){
                hardPointMode.paused = false;
            }
        }
    }

    public void endThread() {
        if (!running) {
            return;
        } else {
            running = false;
            try {
                thread.join();
            } catch (Exception e) {
                e.printStackTrace();
                System.exit(0);
            }
            this.dispose();
        }
    }

    //listen to the server in this run method

    @Override
    public void run() {
        init();
        genPlayer = genericPlayerSS.getImage(1,1,32,32);
        trainingPlayer = trainingPlayerSS.getImage(5,1,32,32);
        orange = orangeSS.getImage(1,1,32,32);
        greenBlocBoy = greenBlocBoySS.getImage(1,1,32,32);


        int frames = 0;
        double unprocessedSeconds = 0;
        long previousTime = System.nanoTime();
        double secondsPerTick = 1/60.0;
        int tickCount = 0;
        boolean ticked = false;

        while(running) {

            long currentTime = System.nanoTime();
            long passedTime = currentTime - previousTime;
            previousTime = currentTime;
            unprocessedSeconds += passedTime / 1000000000.0;
            while (unprocessedSeconds > secondsPerTick) {
                unprocessedSeconds -= secondsPerTick;
                ticked = true;
                tickCount++;
                if (tickCount % 60 == 0) {
                    //System.out.println(frames + "fps");
                    fps = frames;
                    previousTime += 1000;
                    frames = 0;
                }
            }
            if (ticked) {
                frames += 2;
            }


            if (upArrow){
                System.out.println("up arrow pressed");
            }

            if (multiInput.mapSelection.equals("TestingMap")){
                runTestingMap();
            } else if (multiInput.mapSelection.equals("Blockage")){
                runBlockage();
            } else if (multiInput.mapSelection.equals("Pillars")){
                runPillars();
            } else if (multiInput.mapSelection.equals("CenterCore")){
                runCenterCore();
            }

            repaint();

            try {
                thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void runTestingMap(){
        TestingMap.p1.movement();
        TestingMap.p2.movement();
        TestingMap.checkPause(paused);
        multiInput.getInGameMenu(TestingMap.menu);
        if (input.playerID == 1){
            client.playerMovement(TestingMap.p1.xPosPlayer, TestingMap.p1.yPosPlayer);
        } else if (input.playerID == 2){
            client.playerMovement(TestingMap.p2.xPosPlayer, TestingMap.p2.yPosPlayer);
        }
    }

    private void runBlockage(){
        Blockage.p1.movement();
        Blockage.p2.movement();
        Blockage.checkPause(paused);
        multiInput.getInGameMenu(Blockage.menu);
    }

    private void runPillars(){
        Pillars.p1.movement();
        Pillars.p2.movement();
        Pillars.checkPause(paused);
        multiInput.getInGameMenu(Pillars.menu);
    }

    private void runCenterCore(){
        CenterCore.p1.movement();
        CenterCore.p2.movement();
        CenterCore.checkPause(paused);
        multiInput.getInGameMenu(CenterCore.menu);
    }

    public static String getFPS(){
        return Integer.toString(fps);
    }
}
