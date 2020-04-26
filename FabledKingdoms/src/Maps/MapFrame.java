package Maps;

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
    private Thread thread;
    private boolean running;
    private static int fps;

    private Client client;

    InputHandler input;
    MultiPlayerInputHandling multiInput;

    private BufferedImage spriteSheet = null;

    protected BufferedImage player;

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

        //add if statement to distinguish multi from single
        //addKeyListener(input = new InputHandler());
        addKeyListener(multiInput = new MultiPlayerInputHandling());
        startThread();
    }

    public void init(){
        BufferedImageLoader loader = new BufferedImageLoader();
        try {
            spriteSheet = loader.loadImage("FabledKingdoms\\Res\\SpriteSheets\\genPlayerSpriteSheet.png");
        } catch (IOException e){
            e.printStackTrace();
        }

        SpriteSheet ss = new SpriteSheet(spriteSheet);

        player = ss.getImage(1,1,32,32);

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

    private void stop() {
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
        }
    }

    //listen to the server in this run method

    @Override
    public void run() {
        init();
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
                thread.sleep(35);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void runTestingMap(){
        TestingMap.p1.movement();
        TestingMap.p2.movement();

        if (input.playerID == 1){
            client.playerMovement(TestingMap.p1.xPosPlayer, TestingMap.p1.yPosPlayer);
        } else if (input.playerID == 2){
            client.playerMovement(TestingMap.p2.xPosPlayer, TestingMap.p2.yPosPlayer);
        }
    }

    private void runBlockage(){
        Blockage.p1.movement();
        Blockage.p2.movement();
    }

    private void runPillars(){
        Pillars.p1.movement();
        Pillars.p2.movement();
    }

    private void runCenterCore(){
        CenterCore.p1.movement();
        CenterCore.p2.movement();
    }

    public static String getFPS(){
        return  Integer.toString(fps);
    }
}
