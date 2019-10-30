package Maps;

import InputHandling.InputHandler;

import javax.swing.*;
import java.awt.*;

public class MapFrame extends JFrame implements Runnable  {
    private Thread thread;
    private boolean running;

    private static int fps;



    public MapFrame(){
        setPreferredSize(new Dimension(800,600));
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);



        setFocusable(true);
        addKeyListener(new InputHandler());

        start();
    }
    private void start(){
        if (running) {
            return;
        } else {
            running = true;
            thread = new Thread(this);
            thread.start();
            System.out.println("Running...");
        }
    }
    private void stop(){
        if (!running){
            return;
        } else {
            running = false;
            try{
                thread.join();
            } catch (Exception e){
                e.printStackTrace();
                System.exit(0);
            }
        }
    }
    @Override
    public void run() {
        int frames = 0;
        double unprocessedSeconds = 0;
        long previousTime = System.nanoTime();
        double secondsPerTick = 1/60.0;
        int tickCount = 0;
        boolean ticked = false;
        while(running){
            long currentTime = System.nanoTime();
            long passedTime = currentTime - previousTime;
            previousTime = currentTime;
            unprocessedSeconds += passedTime / 1000000000.0;
            while (unprocessedSeconds > secondsPerTick){
                unprocessedSeconds -= secondsPerTick;
                ticked = true;
                tickCount++;
                if (tickCount % 60 == 0){
                    //System.out.println(frames + "fps");
                    fps = frames;
                    previousTime += 1000;
                    frames = 0;
                }
            }
            if (ticked){
                frames +=2;
            }

            TestingMap.p1.movement();
            repaint();

            try {
                thread.sleep(33);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //frames++;
        }
    }

    public static String getFPS(){
        return  Integer.toString(fps);
    }

}
