package GUI;

import Maps.MapFrame;
import Maps.TestingMap;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JPanel {
    private JTabbedPane tabbedPane;

    public String tabCss =
            "margin:0;" +
            "width:100px;" +
            "border-radius:3px;" +
            "padding:10px;" +
            "text-align:center;" +
            "border:none;";

//    String css =
//            "margin:0;" +
//                    "width:110px;" +
//                    "height:10px;" +
//                    "border-radius:3px;" +
//                    "padding:10px;" +
//                    "background:#fff;" +
//                    "text-align:center;" +
//                    "border:none;";


    public MainMenu(){
        setLayout(new BorderLayout());
        components();
    }

    public void components(){
        tabbedPane  = new JTabbedPane();
        tabbedPane.setBackground(Color.black
        );

        tabbedPane.addTab(generateHtml("Play", tabCss), new PlayTab());
        tabbedPane.addTab(generateHtml("Friends", tabCss), new FriendsTab());
        tabbedPane.addTab(generateHtml("Combat Record", tabCss),new CombatRecordTab());
        tabbedPane.addTab(generateHtml("Settings", tabCss), new SettingsTab());
        add(tabbedPane);
    }

    public static String generateHtml(String tabLabel, String style){
        String string = "<html><body style = '" + style + "'>" + tabLabel + "</body></html>";
        return string;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setPreferredSize(new Dimension(800,600));
        frame.pack();
        frame.add(new MainMenu());
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
class PlayTab extends JPanel{
    JButton playBtn, customGameBtn, rankedBtn, trainingBtn;

    String css =
            "margin:0;" +
            "width:100px;"+
            "height:10px;" +
            "border-radius:3px;" +
            "padding:10px;" +
//            "background:#fff;" +
            "text-align:center;" +
            "border:none;";



    public PlayTab(){
        setBorder(BorderFactory.createLineBorder(Color.green));
        components();
    }

    public void components(){
        playBtn = new JButton(MainMenu.generateHtml("Play",css));
        add(playBtn);

        buttonListeners();
    }

    public void buttonListeners(){
        playBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MapFrame frame = new MapFrame();
                TestingMap testingMap = new TestingMap(frame);
                frame.add(testingMap);
                frame.pack();
            }
        });
    }
}

class FriendsTab extends JPanel{
    public FriendsTab(){
        setBorder(BorderFactory.createLineBorder(Color.orange));
    }
}

class CombatRecordTab extends JPanel{
    public CombatRecordTab(){
        setBorder(BorderFactory.createLineBorder(Color.blue));
    }
}

class SettingsTab extends JPanel{
    public SettingsTab(){
        setBorder(BorderFactory.createLineBorder(Color.magenta));
    }
}

