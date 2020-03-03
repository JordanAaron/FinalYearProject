package GUI;

import javax.swing.*;
import java.awt.*;

public class InGameMenu extends JPanel {
    JButton exitBtn;
    public InGameMenu(){
        setLayout(new BorderLayout());
        components();
    }
    public void components(){
        JPanel emptyPanelLeft = new JPanel();
        emptyPanelLeft.setOpaque(false);
        add(emptyPanelLeft,BorderLayout.WEST);

        JPanel emptyPanelRight = new JPanel();
        emptyPanelRight.setOpaque(false);
        add(emptyPanelRight, BorderLayout.EAST);

        JPanel emptyPanelTop = new JPanel();
        emptyPanelTop.setOpaque(false);
        add(emptyPanelTop, BorderLayout.NORTH);

        JPanel emptyPanelBottom = new JPanel();
        emptyPanelBottom.setOpaque(false);
        add(emptyPanelBottom, BorderLayout.SOUTH);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new CardLayout());
        add(mainPanel,BorderLayout.CENTER);

        exitBtn = new JButton("Exit Match");
        mainPanel.add(exitBtn);

    }
}
