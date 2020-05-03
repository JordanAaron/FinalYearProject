package GUI;

import InputHandling.MultiPlayerInputHandling;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayerSelectionMenu extends JPanel {
    JLabel title1, title2;
    JButton backBtn, playerBtn1, playerBtn2, playerBtn3, playerBtn4;

    JPanel topPanel;

    public PlayerSelectionMenu(){
        setLayout(new BorderLayout());
        topPanel = new JPanel();
        components();

    }

    public void components(){

        topPanel.setLayout(new BorderLayout());
        add(topPanel,BorderLayout.NORTH);


        title1 = new JLabel("Player 1 choose a player");
        topPanel.add(title1,BorderLayout.CENTER);

        backBtn = new JButton("Go Back");
        topPanel.add(backBtn, BorderLayout.LINE_END);

        JPanel midPanel = new JPanel();
        midPanel.setLayout(new GridLayout(2,2));
        add(midPanel, BorderLayout.CENTER);

        playerBtn1 = new JButton("Gen");
        midPanel.add(playerBtn1);

        playerBtn2 = new JButton("Purp");
        midPanel.add(playerBtn2);

        playerBtn3 = new JButton("OrangeMan");
        midPanel.add(playerBtn3);

        playerBtn4 = new JButton("Green Bloc Boy");
        midPanel.add(playerBtn4);

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

        playerBtn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MultiPlayerInputHandling.getPlayer("Gen");
                if (MultiPlayerInputHandling.characters.size() ==2){
                    MainMenu.frame.setContentPane(new MapSelectionMenu());
                    MainMenu.frame.invalidate();
                    MainMenu.frame.validate();
                } else if (MultiPlayerInputHandling.characters.size() == 1) {
                    title1.setText("Player 2 choose a player");
                }

            }
        });

        playerBtn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MultiPlayerInputHandling.getPlayer("Purp");
                if (MultiPlayerInputHandling.characters.size() ==2){
                    MainMenu.frame.setContentPane(new MapSelectionMenu());
                    MainMenu.frame.invalidate();
                    MainMenu.frame.validate();
                }else if (MultiPlayerInputHandling.characters.size() == 1) {
                    title1.setText("Player 2 choose a player");
                }
            }
        });

        playerBtn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MultiPlayerInputHandling.getPlayer("Orange");
                if (MultiPlayerInputHandling.characters.size() ==2){
                    MainMenu.frame.setContentPane(new MapSelectionMenu());
                    MainMenu.frame.invalidate();
                    MainMenu.frame.validate();
                }else if (MultiPlayerInputHandling.characters.size() == 1) {
                    title1.setText("Player 2 choose a player");
                }
            }
        });

        playerBtn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MultiPlayerInputHandling.getPlayer("GreenBlocBoy");
                if (MultiPlayerInputHandling.characters.size() ==2){
                    MainMenu.frame.setContentPane(new MapSelectionMenu());
                    MainMenu.frame.invalidate();
                    MainMenu.frame.validate();
                }else if (MultiPlayerInputHandling.characters.size() == 1) {
                    title1.setText("Player 2 choose a player");
                }
            }
        });
    }
}
