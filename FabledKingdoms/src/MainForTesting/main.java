package MainForTesting;

import InputHandling.InputHandler;
import Maps.Frame;
import Maps.TestingMap;


public class main {

    public static void main(String[] args){
        Frame frame = new Frame();
        TestingMap testingMap = new TestingMap(frame);
        frame.add(testingMap);
        frame.pack();
        //System.out.println(frame.getContentPane().getSize());
    }
}
