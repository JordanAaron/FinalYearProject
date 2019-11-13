package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartMenu extends JPanel {
    //static StartMenu startMenu = new StartMenu();
    static JFrame frame;
    MainMenu mainMenu;
    private JButton startButton, settingsButton;
    GridBagConstraints c;

    public StartMenu(){
        c = new GridBagConstraints();
        setLayout(new GridBagLayout());
        components();
    }

    public void components(){
        startButton = new JButton("Start");
        c.anchor = GridBagConstraints.CENTER;
        startButton.setPreferredSize(new Dimension(100,30));
        add(startButton, c);

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                //new MainMenu().setVisible(true);

                mainMenu = new  MainMenu();
                frame.add(mainMenu);
                //mainMenu.setVisible(true);

            }
        });

        settingsButton = new JButton("Settings");
        c.anchor = GridBagConstraints.FIRST_LINE_END;
        c.insets = new Insets(20,0,0,20);
        c.gridx = 0;
        c.gridy = 0;
        c.weighty = 0.1;
        c.weightx = 0.1;
        settingsButton.setPreferredSize(new Dimension(100,30));
        add(settingsButton, c);
    }

    public static void main(String[] args) {
        frame = new JFrame();
        frame.setPreferredSize(new Dimension(800,600));
        frame.pack();
        frame.add(new StartMenu());
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
