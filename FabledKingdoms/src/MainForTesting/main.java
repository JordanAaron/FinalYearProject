package MainForTesting;

import InputHandling.MultiPlayerInputHandling;
import Maps.*;


public class main {
    public static void main(String[] args){
        MapFrame frame = new MapFrame();
        TestingMap testingMap = new TestingMap(frame);
        Blockage blockage = new Blockage(frame);
        //Pillars pillars = new Pillars(frame);

        MultiPlayerInputHandling.getMap("CenterCore");
        //CenterCore centerCore = new CenterCore(frame,true);
        //frame.add(centerCore);
        //frame.add(blockage);
        //frame.add(pillars);
        frame.pack();
        //System.out.println(frame.getContentPane().getSize());
    }
}
