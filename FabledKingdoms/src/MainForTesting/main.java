package MainForTesting;

import Maps.*;


public class main {

    public static void main(String[] args){
        MapFrame frame = new MapFrame();
        TestingMap testingMap = new TestingMap(frame);
        frame.add(testingMap);
        frame.pack();
        //System.out.println(frame.getContentPane().getSize());
    }
}
