package GUI;

import InputHandling.MultiPlayerInputHandling;
import Maps.Blockage;
import Maps.MapFrame;
import Maps.Pillars;
import Maps.TestingMap;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;

public class MapSelectionMenu extends JPanel {
    //JFrame frame;
    JButton backBtn, mapBtn1, mapBtn2, mapBtn3;

    public MapSelectionMenu(/*JFrame frame*/){
        //this.frame = frame;
        setLayout(new BorderLayout());
        components();
    }

    public void components(){
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());
        add(topPanel,BorderLayout.NORTH);

        backBtn = new JButton("Go Back");
        topPanel.add(backBtn, BorderLayout.LINE_END);

        JPanel midPanel = new JPanel();
        midPanel.setLayout(new GridLayout(2,3));
        add(midPanel, BorderLayout.CENTER);

        mapBtn1 = new JButton("Map 1");
//        mapBtn1.setForeground(Color.white);
//        try{
//            Image img = ImageIO.read(new FileInputStream("C:\\Users\\JQuar\\Documents\\Work\\Uni\\3rdYear\\CE301-CapstoneProject\\ce301_quartey_j\\FabledKingdoms\\src\\Res\\map1.bmp"));
//            Image newImg = img.getScaledInstance(mapBtn1.getSize().width, mapBtn1.getSize().height,Image.SCALE_SMOOTH);
//            mapBtn1.setIcon(new ImageIcon(newImg));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        midPanel.add(mapBtn1);

        mapBtn2 = new JButton("Map 2");
        midPanel.add(mapBtn2);

        mapBtn3 = new JButton("Map 3");
        midPanel.add(mapBtn3);

        JButton mapBtn4 = new JButton("Map 4");
        midPanel.add(mapBtn4);
        JButton mapBtn5 = new JButton("Map 5");
        midPanel.add(mapBtn5);
        JButton mapBtn6 = new JButton("Map 6");
        midPanel.add(mapBtn6);

        JPanel bottomPanel = new JPanel();
        add(bottomPanel, BorderLayout.SOUTH);

        buttonListeners();
    }
    public void buttonListeners(){
        backBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainMenu.frame.setContentPane(new LocalPlayMenu());
                MainMenu.frame.invalidate();
                MainMenu.frame.validate();
            }
        });

        mapBtn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MultiPlayerInputHandling.getMap("TestingMap");
                MapFrame frame = new MapFrame();
                TestingMap testingMap = new TestingMap(frame,true);
                frame.add(testingMap);
                frame.pack();

                MainMenu.frame.dispose();
            }
        });

        mapBtn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MultiPlayerInputHandling.getMap("Blockage");
                MapFrame frame = new MapFrame();
                Blockage blockage = new Blockage(frame);
                frame.add(blockage);
                frame.pack();

                MainMenu.frame.dispose();
            }
        });

        mapBtn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                MapFrame frame = new MapFrame();
//                Pillars pillars = new Pillars(frame);
//                frame.add(pillars);
//                frame.pack();
//
//                MainMenu.frame.dispose();
            }
        });

    }

    private int getWindowWidth(){
        return MainMenu.frame.getContentPane().getSize().width;
    }

    private int getWindowHeight(){
        return MainMenu.frame.getContentPane().getSize().height;
    }

}
