package Maps;

import InputHandling.InputHandler;
import MapComponents.Component;
import MapComponents.Platform;
import PlayerCharacters.GenericPlayer;
import PlayerCharacters.Player;
import sun.net.www.content.text.Generic;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;


public class TestingMap extends JPanel {

    ArrayList<MapComponents.Component> components = new ArrayList<>();
    ArrayList<PlayerCharacters.Player> players = new ArrayList<>();

    //GenericPlayer player = new GenericPlayer();

    private Frame frame;

    public TestingMap(Frame frame){
        this.frame = frame;
        setFocusable(true);
        addKeyListener(new InputHandler());

        setBackground(Color.BLACK);

        //Map component positions
        this.components.add(new Platform(0,100 - 5,100,5,Color.green,true));//floor
        this.components.add(new Platform(20,60,15,5,Color.white,true));//left platform
        this.components.add(new Platform(80 - 15,60,15,5,Color.white,true));//right platform

        //Player positions
        this.players.add(new GenericPlayer(spawnPointX(),60-7,Color.cyan));
    }

    private int getWindowWidth(){
        return this.frame.getContentPane().getSize().width;
    }

    private int getWindowHeight(){
        return this.frame.getContentPane().getSize().height;
    }

    private int spawnPointX(){
        Random r = new Random();
        int spawnLocation = r.nextInt(2);
        if(spawnLocation == 0){
            return 27;
        } else {
            return 72;
        }
    }
    private void spawnPointY(){

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for(Component c: this.components){
            c.updateWidth(this.getWindowWidth());
            c.updateHeight(this.getWindowHeight());
            c.draw(g);
        }


        for(Player p: this.players){
            p.updateWidth(this.getWindowWidth());
            p.updateHeight(this.getWindowHeight());
            p.draw(g);
        }
        //System.out.println("Drawing");
    }
}
