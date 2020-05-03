package InputHandling;

import GUI.MainMenu;
import GameModes.Hardpoint.HardPointMode;
import MapComponents.InGameMenu;
import Maps.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class MultiPlayerInputHandling implements KeyListener, MouseListener {

    public static String mapSelection;
    public static void getMap(String map){
        mapSelection = map;
    }

    public static ArrayList<String> characters = new ArrayList<>();

    public static String playerSelection;
    public static void getPlayer(String player){


        if (characters.size() < 3){
            characters.add(player);
            //System.out.println(characters.get(0));
        }
    }

    private MapFrame mapFrame;
    public void getMapFrame(MapFrame frame){
        this.mapFrame = frame;
    }

    private InGameMenu inGameMenu;
    public void getInGameMenu(InGameMenu inGameMenu){this.inGameMenu = inGameMenu;}

    private HardPointMode hardPointMode;
    public void getHardPointMode(HardPointMode hardPointMode){this.hardPointMode = hardPointMode;}


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        if (mapFrame.paused){
            return;
        }

        if (e.getKeyCode() == KeyEvent.VK_ESCAPE){
            //System.out.println("esc pressed");
            mapFrame.pauseGame();
            //hardPointMode.pause();
        }

        if(e.getKeyCode() == KeyEvent.VK_UP){

            if (mapSelection.equals("TestingMap") ){
                TestingMap.p1.up();
            }

            if (mapSelection.equals("Blockage") && characters.get(0).equals("Gen")){
                Blockage.gen.up();
            } else if (mapSelection.equals("Blockage") && characters.get(0).equals("Purp")){
                Blockage.purp.up();
            } else if (mapSelection.equals("Blockage") && characters.get(0).equals("Orange")){
                Blockage.orange.up();
            }else if (mapSelection.equals("Blockage") && characters.get(0).equals("GreenBlocBoy")){
                Blockage.gbb.up();
            }

            if (mapSelection.equals("Pillars") && characters.get(0).equals("Gen")){
                Pillars.gen.up();
            } else if (mapSelection.equals("Pillars") && characters.get(0).equals("Purp")){
                Pillars.purp.up();
            } else if (mapSelection.equals("Pillars") && characters.get(0).equals("Orange")){
                Pillars.orange.up();
            }else if (mapSelection.equals("Pillars") && characters.get(0).equals("GreenBlocBoy")){
                Pillars.gbb.up();
            }

            if (mapSelection.equals("CenterCore") && characters.get(0).equals("Gen")){
                CenterCore.gen.up();
            } else if (mapSelection.equals("CenterCore") && characters.get(0).equals("Purp")){
                CenterCore.purp.up();
            } else if (mapSelection.equals("CenterCore") && characters.get(0).equals("Orange")){
                CenterCore.orange.up();
            }else if (mapSelection.equals("CenterCore") && characters.get(0).equals("GreenBlocBoy")){
                CenterCore.gbb.up();
            }

            //mapFrame.player = mapFrame.ss.getImage(2,1,32,32);
            //mapFrame.upArrow = true;
        }

        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            if (mapSelection.equals("TestingMap")){
                TestingMap.p1.left();
                TestingMap.p1.startMoving();
            }

            if (mapSelection.equals("Blockage") && characters.get(0).equals("Gen")){
                Blockage.gen.left();
                Blockage.gen.startMoving();
            } else if (mapSelection.equals("Blockage") && characters.get(0).equals("Purp")){
                Blockage.purp.left();
                Blockage.purp.startMoving();
            } else if (mapSelection.equals("Blockage") && characters.get(0).equals("Orange")){
                Blockage.orange.left();
                Blockage.orange.startMoving();
            }else if (mapSelection.equals("Blockage") && characters.get(0).equals("GreenBlocBoy")){
                Blockage.gbb.left();
                Blockage.gbb.startMoving();
            }

            if (mapSelection.equals("Pillars") && characters.get(0).equals("Gen")){
                Pillars.gen.left();
                Pillars.gen.startMoving();
            } else if (mapSelection.equals("Pillars") && characters.get(0).equals("Purp")){
                Pillars.purp.left();
                Pillars.purp.startMoving();
            } else if (mapSelection.equals("Pillars") && characters.get(0).equals("Orange")){
                Pillars.orange.left();
                Pillars.orange.startMoving();
            }else if (mapSelection.equals("Pillars") && characters.get(0).equals("GreenBlocBoy")){
                Pillars.gbb.left();
                Pillars.gbb.startMoving();
            }

            if (mapSelection.equals("CenterCore") && characters.get(0).equals("Gen")){
                CenterCore.gen.left();
                CenterCore.gen.startMoving();
            } else if (mapSelection.equals("CenterCore") && characters.get(0).equals("Purp")){
                CenterCore.purp.left();
                CenterCore.purp.startMoving();
            } else if (mapSelection.equals("CenterCore") && characters.get(0).equals("Orange")){
                CenterCore.orange.left();
                CenterCore.orange.startMoving();
            }else if (mapSelection.equals("CenterCore") && characters.get(0).equals("GreenBlocBoy")){
                CenterCore.gbb.left();
                CenterCore.gbb.startMoving();
            }
//            mapFrame.genPlayer = mapFrame.genericPlayerSS.getImage(2,2,32,32);
        }

        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            if (mapSelection.equals("TestingMap")){
                TestingMap.p1.right();
                TestingMap.p1.startMoving();
            }

            if (mapSelection.equals("Blockage") && characters.get(0).equals("Gen")){
                Blockage.gen.right();
            } else if (mapSelection.equals("Blockage") && characters.get(0).equals("Purp")){
                Blockage.purp.right();
                Blockage.purp.startMoving();
            } else if (mapSelection.equals("Blockage") && characters.get(0).equals("Orange")){
                Blockage.orange.right();
                Blockage.orange.startMoving();
            }else if (mapSelection.equals("Blockage") && characters.get(0).equals("GreenBlocBoy")){
                Blockage.gbb.right();
                Blockage.gbb.startMoving();
            }

            if (mapSelection.equals("Pillars") && characters.get(0).equals("Gen")){
                Pillars.gen.right();
                Pillars.gen.startMoving();
            } else if (mapSelection.equals("Pillars") && characters.get(0).equals("Purp")){
                Pillars.purp.right();
                Pillars.purp.startMoving();
            } else if (mapSelection.equals("Pillars") && characters.get(0).equals("Orange")){
                Pillars.orange.right();
                Pillars.orange.startMoving();
            }else if (mapSelection.equals("Pillars") && characters.get(0).equals("GreenBlocBoy")){
                Pillars.gbb.right();
                Pillars.gbb.startMoving();
            }

            if (mapSelection.equals("CenterCore") && characters.get(0).equals("Gen")){
                CenterCore.gen.right();
                CenterCore.gen.startMoving();
            } else if (mapSelection.equals("CenterCore") && characters.get(0).equals("Purp")){
                CenterCore.purp.right();
                CenterCore.purp.startMoving();
            } else if (mapSelection.equals("CenterCore") && characters.get(0).equals("Orange")){
                CenterCore.orange.right();
                CenterCore.orange.startMoving();
            }else if (mapSelection.equals("CenterCore") && characters.get(0).equals("GreenBlocBoy")){
                CenterCore.gbb.right();
                CenterCore.gbb.startMoving();
            }

//            mapFrame.genPlayer = mapFrame.genericPlayerSS.getImage(1,2,32,32);
        }
        if(e.getKeyCode() == KeyEvent.VK_P){
            if (mapSelection.equals("TestingMap")){
                TestingMap.p1.lightAttack();
            }

            if (mapSelection.equals("Blockage") && characters.get(0).equals("Gen")){
                Blockage.gen.lightAttack();
            } else if (mapSelection.equals("Blockage") && characters.get(0).equals("Purp")){
                Blockage.purp.lightAttack();
            } else if (mapSelection.equals("Blockage") && characters.get(0).equals("Orange")){
                Blockage.orange.lightAttack();
            }else if (mapSelection.equals("Blockage") && characters.get(0).equals("GreenBlocBoy")){
                Blockage.gbb.lightAttack();
            }

            if (mapSelection.equals("Pillars") && characters.get(0).equals("Gen")){
                Pillars.gen.lightAttack();
            } else if (mapSelection.equals("Pillars") && characters.get(0).equals("Purp")){
                Pillars.purp.lightAttack();
            } else if (mapSelection.equals("Pillars") && characters.get(0).equals("Orange")){
                Pillars.orange.lightAttack();
            }else if (mapSelection.equals("Pillars") && characters.get(0).equals("GreenBlocBoy")){
                Pillars.gbb.lightAttack();
            }

            if (mapSelection.equals("CenterCore") && characters.get(0).equals("Gen")){
                CenterCore.gen.lightAttack();
            } else if (mapSelection.equals("CenterCore") && characters.get(0).equals("Purp")){
                CenterCore.purp.lightAttack();
            } else if (mapSelection.equals("CenterCore") && characters.get(0).equals("Orange")){
                CenterCore.orange.lightAttack();
            }else if (mapSelection.equals("CenterCore") && characters.get(0).equals("GreenBlocBoy")){
                CenterCore.gbb.lightAttack();
            }
            //System.out.println("Light Attack!");
//            mapFrame.genPlayer = mapFrame.genericPlayerSS.getImage(1,3,32,32);
        }
        if(e.getKeyCode() == KeyEvent.VK_O){
//            if (mapSelection.equals("TestingMap")){
//                TestingMap.p1.heavyAttack();
//            } else if (mapSelection.equals("Blockage")){
//                Blockage.gen.heavyAttack();
//            } else if (mapSelection.equals("Pillars")){
//                Pillars.p1.heavyAttack();
//            } else if (mapSelection.equals("CenterCore")){
//                CenterCore.p1.heavyAttack();
//            }
//            System.out.println("Heavy Attack");
        }

        if(e.getKeyCode() == KeyEvent.VK_W){
            if (mapSelection.equals("TestingMap")){
                TestingMap.p2.up();
            }

            if (mapSelection.equals("Blockage") && characters.get(1).equals("Gen")){
                Blockage.gen.up();
            } else if (mapSelection.equals("Blockage") && characters.get(1).equals("Purp")){
                Blockage.purp.up();
            } else if (mapSelection.equals("Blockage") && characters.get(1).equals("Orange")){
                Blockage.orange.up();
            }else if (mapSelection.equals("Blockage") && characters.get(1).equals("GreenBlocBoy")){
                Blockage.gbb.up();
            }

            if (mapSelection.equals("Pillars") && characters.get(1).equals("Gen")){
                Pillars.gen.up();
            } else if (mapSelection.equals("Pillars") && characters.get(1).equals("Purp")){
                Pillars.purp.up();
            } else if (mapSelection.equals("Pillars") && characters.get(1).equals("Orange")){
                Pillars.orange.up();
            }else if (mapSelection.equals("Pillars") && characters.get(1).equals("GreenBlocBoy")){
                Pillars.gbb.up();
            }

            if (mapSelection.equals("CenterCore") && characters.get(1).equals("Gen")){
                CenterCore.gen.up();
            } else if (mapSelection.equals("CenterCore") && characters.get(1).equals("Purp")){
                CenterCore.purp.up();
            } else if (mapSelection.equals("CenterCore") && characters.get(1).equals("Orange")){
                CenterCore.orange.up();
            }else if (mapSelection.equals("CenterCore") && characters.get(1).equals("GreenBlocBoy")){
                CenterCore.gbb.up();
            }
        }

        if(e.getKeyCode() == KeyEvent.VK_A){
            if (mapSelection.equals("TestingMap")){
                TestingMap.p2.left();
                TestingMap.p2.startMoving();
            }

            if (mapSelection.equals("Blockage") && characters.get(1).equals("Gen")){
                Blockage.gen.left();
                Blockage.gen.startMoving();
            } else if (mapSelection.equals("Blockage") && characters.get(1).equals("Purp")){
                Blockage.purp.left();
                Blockage.purp.startMoving();
            } else if (mapSelection.equals("Blockage") && characters.get(1).equals("Orange")){
                Blockage.orange.left();
                Blockage.orange.startMoving();
            }else if (mapSelection.equals("Blockage") && characters.get(1).equals("GreenBlocBoy")){
                Blockage.gbb.left();
                Blockage.gbb.startMoving();
            }

            if (mapSelection.equals("Pillars") && characters.get(1).equals("Gen")){
                Pillars.gen.left();
                Pillars.gen.startMoving();
            } else if (mapSelection.equals("Pillars") && characters.get(1).equals("Purp")){
                Pillars.purp.left();
                Pillars.purp.startMoving();
            } else if (mapSelection.equals("Pillars") && characters.get(1).equals("Orange")){
                Pillars.orange.left();
                Pillars.orange.startMoving();
            }else if (mapSelection.equals("Pillars") && characters.get(1).equals("GreenBlocBoy")){
                Pillars.gbb.left();
                Pillars.gbb.startMoving();
            }

            if (mapSelection.equals("CenterCore") && characters.get(1).equals("Gen")){
                CenterCore.gen.left();
                CenterCore.gen.startMoving();
            } else if (mapSelection.equals("CenterCore") && characters.get(1).equals("Purp")){
                CenterCore.purp.left();
                CenterCore.purp.startMoving();
            } else if (mapSelection.equals("CenterCore") && characters.get(1).equals("Orange")){
                CenterCore.orange.left();
                CenterCore.orange.startMoving();
            }else if (mapSelection.equals("CenterCore") && characters.get(1).equals("GreenBlocBoy")){
                CenterCore.gbb.left();
                CenterCore.gbb.startMoving();
            }
        }

        if(e.getKeyCode() == KeyEvent.VK_D){
            if (mapSelection.equals("TestingMap")){
                TestingMap.p2.right();
                TestingMap.p2.startMoving();
            }

            if (mapSelection.equals("Blockage") && characters.get(1).equals("Gen")){
                Blockage.gen.right();
                Blockage.gen.startMoving();
            } else if (mapSelection.equals("Blockage") && characters.get(1).equals("Purp")){
                Blockage.purp.right();
                Blockage.purp.startMoving();
            } else if (mapSelection.equals("Blockage") && characters.get(1).equals("Orange")){
                Blockage.orange.right();
                Blockage.orange.startMoving();
            }else if (mapSelection.equals("Blockage") && characters.get(1).equals("GreenBlocBoy")){
                Blockage.gbb.right();
                Blockage.gbb.startMoving();
            }

            if (mapSelection.equals("Pillars") && characters.get(1).equals("Gen")){
                Pillars.gen.right();
                Pillars.gen.startMoving();
            } else if (mapSelection.equals("Pillars") && characters.get(1).equals("Purp")){
                Pillars.purp.right();
                Pillars.purp.startMoving();
            } else if (mapSelection.equals("Pillars") && characters.get(1).equals("Orange")){
                Pillars.orange.right();
                Pillars.orange.startMoving();
            }else if (mapSelection.equals("Pillars") && characters.get(1).equals("GreenBlocBoy")){
                Pillars.gbb.right();
                Pillars.gbb.startMoving();
            }

            if (mapSelection.equals("CenterCore") && characters.get(1).equals("Gen")){
                CenterCore.gen.right();
                CenterCore.gen.startMoving();
            } else if (mapSelection.equals("CenterCore") && characters.get(1).equals("Purp")){
                CenterCore.purp.right();
                CenterCore.purp.startMoving();
            } else if (mapSelection.equals("CenterCore") && characters.get(1).equals("Orange")){
                CenterCore.orange.right();
                CenterCore.orange.startMoving();
            }else if (mapSelection.equals("CenterCore") && characters.get(1).equals("GreenBlocBoy")){
                CenterCore.gbb.right();
                CenterCore.gbb.startMoving();
            }
        }
        if(e.getKeyCode() == KeyEvent.VK_G){
            if (mapSelection.equals("TestingMap")){
                TestingMap.p2.lightAttack();
            }

            if (mapSelection.equals("Blockage") && characters.get(1).equals("Gen")){
                Blockage.gen.lightAttack();
            } else if (mapSelection.equals("Blockage") && characters.get(1).equals("Purp")){
                Blockage.purp.lightAttack();
            } else if (mapSelection.equals("Blockage") && characters.get(1).equals("Orange")){
                Blockage.orange.lightAttack();
            }else if (mapSelection.equals("Blockage") && characters.get(1).equals("GreenBlocBoy")){
                Blockage.gbb.lightAttack();
            }

            if (mapSelection.equals("Pillars") && characters.get(1).equals("Gen")){
                Pillars.gen.lightAttack();
            } else if (mapSelection.equals("Pillars") && characters.get(1).equals("Purp")){
                Pillars.purp.lightAttack();
            } else if (mapSelection.equals("Pillars") && characters.get(1).equals("Orange")){
                Pillars.orange.lightAttack();
            }else if (mapSelection.equals("Pillars") && characters.get(1).equals("GreenBlocBoy")){
                Pillars.gbb.lightAttack();
            }

            if (mapSelection.equals("CenterCore") && characters.get(1).equals("Gen")){
                CenterCore.gen.lightAttack();
            } else if (mapSelection.equals("CenterCore") && characters.get(1).equals("Purp")){
                CenterCore.purp.lightAttack();
            } else if (mapSelection.equals("CenterCore") && characters.get(1).equals("Orange")){
                CenterCore.orange.lightAttack();
            }else if (mapSelection.equals("CenterCore") && characters.get(1).equals("GreenBlocBoy")){
                CenterCore.gbb.lightAttack();
            }
            //System.out.println("Light Attack!");

        }

        if(e.getKeyCode() == KeyEvent.VK_H){
//            if (mapSelection.equals("TestingMap")){
//                TestingMap.p2.heavyAttack();
//            } else if (mapSelection.equals("Blockage")){
//                Blockage.purp.heavyAttack();
//            } else if (mapSelection.equals("Pillars")){
//                Pillars.p2.heavyAttack();
//            } else if (mapSelection.equals("CenterCore")){
//                CenterCore.p2.heavyAttack();
//            }
//            System.out.println("Heavy Attack");

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_UP){

            mapFrame.genPlayer = mapFrame.genericPlayerSS.getImage(1,1,32,32);
            mapFrame.purp = mapFrame.trainingPlayerSS.getImage(5,1,32,32);
            //mapFrame.upArrow = true;
        }

        if(e.getKeyCode() == KeyEvent.VK_W){

            mapFrame.purp = mapFrame.trainingPlayerSS.getImage(5,1,32,32);
            //mapFrame.upArrow = true;
        }


        if(e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_RIGHT){
            if (mapSelection.equals("TestingMap")/* and player chosen is*/){
                TestingMap.p1.stopMoving();
            }

            if (mapSelection.equals("Blockage") && characters.get(0).equals("Gen")){
                Blockage.gen.stopMoving();
            } else if (mapSelection.equals("Blockage") && characters.get(0).equals("Purp")){
                Blockage.purp.stopMoving();
            } else if (mapSelection.equals("Blockage") && characters.get(0).equals("Orange")){
                Blockage.orange.stopMoving();
            }else if (mapSelection.equals("Blockage") && characters.get(0).equals("GreenBlocBoy")){
                Blockage.gbb.stopMoving();
            }

            if (mapSelection.equals("Pillars") && characters.get(0).equals("Gen")){
                Pillars.gen.stopMoving();
            } else if (mapSelection.equals("Pillars") && characters.get(0).equals("Purp")){
                Pillars.purp.stopMoving();
            } else if (mapSelection.equals("Pillars") && characters.get(0).equals("Orange")){
                Pillars.orange.stopMoving();
            }else if (mapSelection.equals("Pillars") && characters.get(0).equals("GreenBlocBoy")){
                Pillars.gbb.stopMoving();
            }

            if (mapSelection.equals("CenterCore") && characters.get(0).equals("Gen")){
                CenterCore.gen.stopMoving();
            } else if (mapSelection.equals("CenterCore") && characters.get(0).equals("Purp")){
                CenterCore.purp.stopMoving();
            } else if (mapSelection.equals("CenterCore") && characters.get(0).equals("Orange")){
                CenterCore.orange.stopMoving();
            }else if (mapSelection.equals("CenterCore") && characters.get(0).equals("GreenBlocBoy")){
                CenterCore.gbb.stopMoving();
            }


        }

        if(e.getKeyCode() == KeyEvent.VK_P){
            if (mapSelection.equals("TestingMap")){
                TestingMap.p1.stopLightAttack();
            }

            if (mapSelection.equals("Blockage") && characters.get(0).equals("Gen")){
                Blockage.gen.stopLightAttack();
            } else if (mapSelection.equals("Blockage") && characters.get(0).equals("Purp")){
                Blockage.purp.stopLightAttack();
            } else if (mapSelection.equals("Blockage") && characters.get(0).equals("Orange")){
                Blockage.orange.stopLightAttack();
            }else if (mapSelection.equals("Blockage") && characters.get(0).equals("GreenBlocBoy")){
                Blockage.gbb.stopLightAttack();
            }

            if (mapSelection.equals("Pillars") && characters.get(0).equals("Gen")){
                Pillars.gen.stopLightAttack();
            } else if (mapSelection.equals("Pillars") && characters.get(0).equals("Purp")){
                Pillars.purp.stopLightAttack();
            } else if (mapSelection.equals("Pillars") && characters.get(0).equals("Orange")){
                Pillars.orange.stopLightAttack();
            }else if (mapSelection.equals("Pillars") && characters.get(0).equals("GreenBlocBoy")){
                Pillars.gbb.stopLightAttack();
            }

            if (mapSelection.equals("CenterCore") && characters.get(0).equals("Gen")){
                CenterCore.gen.stopLightAttack();
            } else if (mapSelection.equals("CenterCore") && characters.get(0).equals("Purp")){
                CenterCore.purp.stopLightAttack();
            } else if (mapSelection.equals("CenterCore") && characters.get(0).equals("Orange")){
                CenterCore.orange.stopLightAttack();
            }else if (mapSelection.equals("CenterCore") && characters.get(0).equals("GreenBlocBoy")){
                CenterCore.gbb.stopLightAttack();
            }

        }


        if(e.getKeyCode() == KeyEvent.VK_H){
//            if (mapSelection.equals("TestingMap")){
//                TestingMap.p1.stopHeavyAttack();
//            } else if (mapSelection.equals("Blockage")){
//                Blockage.gen.stopHeavyAttack();
//            } else if (mapSelection.equals("Pillars")){
//                Pillars.p1.stopHeavyAttack();
//            } else if (mapSelection.equals("CenterCore")){
//                CenterCore.p1.stopHeavyAttack();
//            }
        }

        if(e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_D){
            if (mapSelection.equals("TestingMap")){
                TestingMap.p2.stopMoving();
            }

            if (mapSelection.equals("Blockage") && characters.get(1).equals("Gen")){
                Blockage.gen.stopMoving();
            } else if (mapSelection.equals("Blockage") && characters.get(1).equals("Purp")){
                Blockage.purp.stopMoving();
            } else if (mapSelection.equals("Blockage") && characters.get(1).equals("Orange")){
                Blockage.orange.stopMoving();
            }else if (mapSelection.equals("Blockage") && characters.get(1).equals("GreenBlocBoy")){
                Blockage.gbb.stopMoving();
            }

            if (mapSelection.equals("Pillars") && characters.get(1).equals("Gen")){
                Pillars.gen.stopMoving();
            } else if (mapSelection.equals("Pillars") && characters.get(1).equals("Purp")){
                Pillars.purp.stopMoving();
            } else if (mapSelection.equals("Pillars") && characters.get(1).equals("Orange")){
                Pillars.orange.stopMoving();
            }else if (mapSelection.equals("Pillars") && characters.get(1).equals("GreenBlocBoy")){
                Pillars.gbb.stopMoving();
            }

            if (mapSelection.equals("CenterCore") && characters.get(1).equals("Gen")){
                CenterCore.gen.stopMoving();
            } else if (mapSelection.equals("CenterCore") && characters.get(1).equals("Purp")){
                CenterCore.purp.stopMoving();
            } else if (mapSelection.equals("CenterCore") && characters.get(1).equals("Orange")){
                CenterCore.orange.stopMoving();
            }else if (mapSelection.equals("CenterCore") && characters.get(1).equals("GreenBlocBoy")){
                CenterCore.gbb.stopMoving();
            }
        }


        if(e.getKeyCode() == KeyEvent.VK_G){
            if (mapSelection.equals("TestingMap")){
                TestingMap.p2.stopLightAttack();
            }

            if (mapSelection.equals("Blockage") && characters.get(1).equals("Gen")){
                Blockage.gen.stopLightAttack();
            } else if (mapSelection.equals("Blockage") && characters.get(1).equals("Purp")){
                Blockage.purp.stopLightAttack();
            } else if (mapSelection.equals("Blockage") && characters.get(1).equals("Orange")){
                Blockage.orange.stopLightAttack();
            }else if (mapSelection.equals("Blockage") && characters.get(1).equals("GreenBlocBoy")){
                Blockage.gbb.stopLightAttack();
            }

            if (mapSelection.equals("Pillars") && characters.get(1).equals("Gen")){
                Pillars.gen.stopLightAttack();
            } else if (mapSelection.equals("Pillars") && characters.get(1).equals("Purp")){
                Pillars.purp.stopLightAttack();
            } else if (mapSelection.equals("Pillars") && characters.get(1).equals("Orange")){
                Pillars.orange.stopLightAttack();
            }else if (mapSelection.equals("Pillars") && characters.get(1).equals("GreenBlocBoy")){
                Pillars.gbb.stopLightAttack();
            }

            if (mapSelection.equals("CenterCore") && characters.get(1).equals("Gen")){
                CenterCore.gen.stopLightAttack();
            } else if (mapSelection.equals("CenterCore") && characters.get(1).equals("Purp")){
                CenterCore.purp.stopLightAttack();
            } else if (mapSelection.equals("CenterCore") && characters.get(1).equals("Orange")){
                CenterCore.orange.stopLightAttack();
            }else if (mapSelection.equals("CenterCore") && characters.get(1).equals("GreenBlocBoy")){
                CenterCore.gbb.stopLightAttack();
            }
        }

        if(e.getKeyCode() == KeyEvent.VK_O){
//            if (mapSelection.equals("TestingMap")){
//                TestingMap.p2.stopHeavyAttack();
//            } else if (mapSelection.equals("Blockage")){
//                Blockage.purp.stopHeavyAttack();
//            } else if (mapSelection.equals("Pillars")){
//                Pillars.p2.stopHeavyAttack();
//            } else if (mapSelection.equals("CenterCore")){
//                CenterCore.p2.stopHeavyAttack();
//            }
        }
    }


    @Override
    public void mouseClicked(MouseEvent e) {

        if (updatedX(e.getX()) > updatedX(this.inGameMenu.resumeButton.xPos) && updatedX(e.getX()) < (updatedX(this.inGameMenu.resumeButton.xPos)+updatedX(this.inGameMenu.resumeButton.width))){
            if ((updatedY(e.getY()) -5) > updatedY(this.inGameMenu.resumeButton.yPos) && (updatedY(e.getY())-5) < (updatedY(this.inGameMenu.resumeButton.yPos)+ updatedX(this.inGameMenu.resumeButton.width))){
                try {
                    mapFrame.resumeGame();
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }

        if (updatedX(e.getX()) > updatedX(this.inGameMenu.exitGame.xPos) && updatedX(e.getX()) < (updatedX(this.inGameMenu.exitGame.xPos)+updatedX(this.inGameMenu.exitGame.width))){
            if ((updatedY(e.getY()) -5) > updatedY(this.inGameMenu.exitGame.yPos) && (updatedY(e.getY())-5) < (updatedY(this.inGameMenu.exitGame.yPos)+ updatedX(this.inGameMenu.exitGame.width))){
                mapFrame.endThread();
                if (hardPointMode.running){
                    try {
                        hardPointMode.stopThread();
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }


                MainMenu.frame.setPreferredSize(new Dimension(800,600));
                MainMenu.frame.pack();
                MainMenu.frame.add(new MainMenu());
                MainMenu.frame.setVisible(true);
                MainMenu.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            }
        }
    }

    public int updatedX(int x){
        int screenWidth = mapFrame.getContentPane().getSize().width;
        return (int)(((double) x /screenWidth) * 100);
    }

    public int updatedY(int y){
        int screenHeight = mapFrame.getContentPane().getSize().height;
        return (int)(((double) y /screenHeight) * 100);
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //System.out.println("on screen");
        //System.out.println(MouseInfo.getPointerInfo().getLocation().x);
        //MouseInfo.getPointerInfo().getLocation();
    }

    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("off screen");
    }
}
