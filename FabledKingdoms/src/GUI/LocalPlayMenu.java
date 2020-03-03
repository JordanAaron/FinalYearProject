package GUI;

import Maps.MapFrame;
import Maps.TestingMap;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LocalPlayMenu extends JPanel {
    //MapFrame frame;
    JButton backBtn, trainingBtn, multiBtn;

    public LocalPlayMenu(/*MapFrame frame*/){
        //this.frame = frame;
        setLayout(new BorderLayout());
        components();
    }

    public void components(){
        JPanel topPanel = new JPanel();
        topPanel.setBorder(BorderFactory.createLineBorder(Color.green));
        topPanel.setLayout(new BorderLayout());
        add(topPanel,BorderLayout.NORTH);

        backBtn = new JButton("Go Back");
        topPanel.add(backBtn, BorderLayout.LINE_END);

        JPanel midPanel = new JPanel();
        midPanel.setBorder(BorderFactory.createLineBorder(Color.pink));
        midPanel.setLayout(new GridLayout(3,0));
        add(midPanel,BorderLayout.CENTER);

        JPanel emptyPanel = new JPanel();
        JPanel emptyPanel2 = new JPanel();
        JPanel emptyPanel3 = new JPanel();
        JPanel emptyPanel4 = new JPanel();

        midPanel.add(emptyPanel);

        JPanel btnPanel = new JPanel();
        btnPanel.setLayout(new GridLayout(0,5));

        midPanel.add(btnPanel);

        btnPanel.add(emptyPanel2);

        trainingBtn = new JButton("Training");
        btnPanel.add(trainingBtn);

        btnPanel.add(emptyPanel3);

        multiBtn = new JButton("2 Player");
        btnPanel.add(multiBtn);

        btnPanel.add(emptyPanel4);

        buttonListeners();
    }

    public void buttonListeners(){

        trainingBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainMenu.frame.setContentPane(new MapSelectionMenu());
                MainMenu.frame.invalidate();
                MainMenu.frame.validate();
            }
        });

        multiBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainMenu.frame.setContentPane(new MapSelectionMenu());
                MainMenu.frame.invalidate();
                MainMenu.frame.validate();
            }
        });

        backBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainMenu.frame.setContentPane(new MainMenu());
                MainMenu.frame.invalidate();
                MainMenu.frame.validate();
            }
        });
    }
}
