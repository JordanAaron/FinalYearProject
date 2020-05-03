package GameModes.Hardpoint;

import Maps.CenterCore;
import Maps.MapFrame;
import Maps.Pillars;

import java.util.ArrayList;

public class HardPointMode implements Runnable {
    public static Thread thread;
    public static boolean running;

    private String map;
    public boolean paused;

    public static ArrayList<CapturePoint> capturePoints = new ArrayList<>();

    private MapFrame mapFrame;
    public void getMapFrame(MapFrame frame){
        this.mapFrame = frame;
    }

    Pillars pillars;
    public void getPillars(Pillars pillars){
        this.pillars = pillars;
    }

    public HardPointMode(String map){
        this.map = map;

        paused = false;

        if (map.equals("Pillars")){
            capturePoints.add(Pillars.centerCP);
            capturePoints.add(Pillars.leftPillarCP);
            capturePoints.add(Pillars.rightPillarCP);

        }
        if (map.equals("CenterCore")){
            capturePoints.add(CenterCore.middleCP);
            capturePoints.add(CenterCore.LBaseCP);
            capturePoints.add(CenterCore.rightSpawnCP);
            capturePoints.add(CenterCore.leftSpawnCP);
            capturePoints.add(CenterCore.JBaseCP);
        }
        start();
    }

    private void start(){
        if (running){
            return;
        } else {
            thread = new Thread(this);
            thread.start();
            running = true;
            if (map.equals("Pillars")){
                //Pillars.addPoint.startThread();
                Pillars.points.start();
            } else if (map.equals("CenterCore")){
                //CenterCore.points.start();
            }
        }
    }

//    public void pause(){
//        if (mapFrame.paused){
//            return;
//        } else {
//            paused = true;
//        }
//    }

//    public void resume(){
//        if (!mapFrame.paused){
//            return;
//        } else {
//            paused = false;
//        }
//    }

    public void stopThread() throws InterruptedException {
        if (!running){
            return;
        } else {
            System.out.println("Stopping hardpoint");
            running = false;
            try{
                thread.join();
                Pillars.addPoint.stopThread();
                System.out.println("pillars point stopped");
            } catch (Exception e) {
                e.printStackTrace();
                System.exit(0);
            }

//            try {
//                Pillars.points.interrupt();
//            } catch(InterruptedException e){
//
//            }

//            if (map.equals("Pillars")){
//                Pillars.points.join();
//                System.out.println("pillars point stopped");
//            } else if (map.equals("CenterCore")){
//                //CenterCore.points.join();
//            }

            //Pillars.points.join();



        }




    }

    @Override
    public void run() {

        while (running) {
            if (this.paused) {
                System.out.println("hardpoint paused");
                //return;
            } else {
                System.out.println("hardpoint running");
                for (CapturePoint cp : capturePoints) {

                    cp.setActive(true);
                    try {
                        this.thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    cp.setActive(false);
                }
            }
        }
    }
}
