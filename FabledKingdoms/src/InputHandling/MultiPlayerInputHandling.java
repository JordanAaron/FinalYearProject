package InputHandling;

import GUI.InGameMenuComponents.MenuButtons;
import GUI.MainMenu;
import MapComponents.InGameMenu;
import Maps.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MultiPlayerInputHandling implements KeyListener, MouseListener {

    public static String mapSelection;
    public static void getMap(String map){
        mapSelection = map;
    }

    private MapFrame mapFrame;
    public void getMapFrame(MapFrame frame){
        this.mapFrame = frame;
    }

    private InGameMenu inGameMenu;
    public void getInGameMenu(InGameMenu inGameMenu){this.inGameMenu = inGameMenu;}


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
        }

        if(e.getKeyCode() == KeyEvent.VK_UP){
            if (mapSelection.equals("TestingMap")){
                TestingMap.p1.up();
            } else if (mapSelection.equals("Blockage")){
                Blockage.p1.up();
            } else if (mapSelection.equals("Pillars")){
                Pillars.p1.up();
            } else if (mapSelection.equals("CenterCore")){
                CenterCore.p1.up();
            }
        }

        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            if (mapSelection.equals("TestingMap")){
                TestingMap.p1.left();
                TestingMap.p1.startMoving();
            } else if (mapSelection.equals("Blockage")){
                Blockage.p1.left();
                Blockage.p1.startMoving();
            } else if (mapSelection.equals("Pillars")){
                Pillars.p1.left();
                Pillars.p1.startMoving();
            } else if (mapSelection.equals("CenterCore")){
                CenterCore.p1.left();
                CenterCore.p1.startMoving();
            }

        }
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            if (mapSelection.equals("TestingMap")){
                TestingMap.p1.right();
                TestingMap.p1.startMoving();
            } else if (mapSelection.equals("Blockage")){
                Blockage.p1.right();
                Blockage.p1.startMoving();
            } else if (mapSelection.equals("Pillars")){
                Pillars.p1.right();
                Pillars.p1.startMoving();
            } else if (mapSelection.equals("CenterCore")){
                CenterCore.p1.right();
                CenterCore.p1.startMoving();
            }

        }
        if(e.getKeyCode() == KeyEvent.VK_P){
            if (mapSelection.equals("TestingMap")){
                TestingMap.p1.lightAttack();
            } else if (mapSelection.equals("Blockage")){
                Blockage.p1.lightAttack();
            } else if (mapSelection.equals("Pillars")){
                Pillars.p1.lightAttack();
            } else if (mapSelection.equals("CenterCore")){
                CenterCore.p1.lightAttack();
            }
            System.out.println("Light Attack!");
        }
        if(e.getKeyCode() == KeyEvent.VK_O){
            if (mapSelection.equals("TestingMap")){
                TestingMap.p1.heavyAttack();
            } else if (mapSelection.equals("Blockage")){
                Blockage.p1.heavyAttack();
            } else if (mapSelection.equals("Pillars")){
                Pillars.p1.heavyAttack();
            } else if (mapSelection.equals("CenterCore")){
                CenterCore.p1.heavyAttack();
            }
            System.out.println("Heavy Attack");
        }

        if(e.getKeyCode() == KeyEvent.VK_W){
            if (mapSelection.equals("TestingMap")){
                TestingMap.p2.up();
            } else if (mapSelection.equals("Blockage")){
                Blockage.p2.up();
            } else if (mapSelection.equals("Pillars")){
                Pillars.p2.up();
            } else if (mapSelection.equals("CenterCore")){
                CenterCore.p2.up();
            }
        }

        if(e.getKeyCode() == KeyEvent.VK_A){
            if (mapSelection.equals("TestingMap")){
                TestingMap.p2.left();
                TestingMap.p2.startMoving();
            } else if (mapSelection.equals("Blockage")){
                Blockage.p2.left();
                Blockage.p2.startMoving();
            } else if (mapSelection.equals("Pillars")){
                Pillars.p2.left();
                Pillars.p2.startMoving();
            } else if (mapSelection.equals("CenterCore")){
                CenterCore.p2.left();
                CenterCore.p2.startMoving();
            }
        }

        if(e.getKeyCode() == KeyEvent.VK_D){
            if (mapSelection.equals("TestingMap")){
                TestingMap.p2.right();
                TestingMap.p2.startMoving();
            } else if (mapSelection.equals("Blockage")){
                Blockage.p2.right();
                Blockage.p2.startMoving();
            } else if (mapSelection.equals("Pillars")){
                Pillars.p2.right();
                Pillars.p2.startMoving();
            } else if (mapSelection.equals("CenterCore")){
                CenterCore.p2.right();
                CenterCore.p2.startMoving();
            }
        }
        if(e.getKeyCode() == KeyEvent.VK_G){
            if (mapSelection.equals("TestingMap")){
                TestingMap.p2.lightAttack();
            } else if (mapSelection.equals("Blockage")){
                Blockage.p2.lightAttack();
            } else if (mapSelection.equals("Pillars")){
                Pillars.p2.lightAttack();
            } else if (mapSelection.equals("CenterCore")){
                CenterCore.p2.lightAttack();
            }
            System.out.println("Light Attack!");

        }

        if(e.getKeyCode() == KeyEvent.VK_H){
            if (mapSelection.equals("TestingMap")){
                TestingMap.p2.heavyAttack();
            } else if (mapSelection.equals("Blockage")){
                Blockage.p2.heavyAttack();
            } else if (mapSelection.equals("Pillars")){
                Pillars.p2.heavyAttack();
            } else if (mapSelection.equals("CenterCore")){
                CenterCore.p2.heavyAttack();
            }
            System.out.println("Heavy Attack");

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_RIGHT){
            if (mapSelection.equals("TestingMap")){
                TestingMap.p1.stopMoving();
            } else if (mapSelection.equals("Blockage")){
                Blockage.p1.stopMoving();
            } else if (mapSelection.equals("Pillars")){
                Pillars.p1.stopMoving();
            } else if (mapSelection.equals("CenterCore")){
                CenterCore.p1.stopMoving();
            }
        }

        if(e.getKeyCode() == KeyEvent.VK_G){
            if (mapSelection.equals("TestingMap")){
                TestingMap.p1.stopLightAttack();
            } else if (mapSelection.equals("Blockage")){
                Blockage.p1.stopLightAttack();
            } else if (mapSelection.equals("Pillars")){
                Pillars.p1.stopLightAttack();
            } else if (mapSelection.equals("CenterCore")){
                CenterCore.p1.stopLightAttack();
            }
        }

        if(e.getKeyCode() == KeyEvent.VK_H){
            if (mapSelection.equals("TestingMap")){
                TestingMap.p1.stopHeavyAttack();
            } else if (mapSelection.equals("Blockage")){
                Blockage.p1.stopHeavyAttack();
            } else if (mapSelection.equals("Pillars")){
                Pillars.p1.stopHeavyAttack();
            } else if (mapSelection.equals("CenterCore")){
                CenterCore.p1.stopHeavyAttack();
            }
        }

        if(e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_D){
            if (mapSelection.equals("TestingMap")){
                TestingMap.p2.stopMoving();
            } else if (mapSelection.equals("Blockage")){
                Blockage.p2.startMoving();
            } else if (mapSelection.equals("Pillars")){
                Pillars.p2.stopMoving();
            } else if (mapSelection.equals("CenterCore")){
                CenterCore.p2.stopMoving();
            }
        }

        if(e.getKeyCode() == KeyEvent.VK_P){
            if (mapSelection.equals("TestingMap")){
                TestingMap.p2.stopLightAttack();
            } else if (mapSelection.equals("Blockage")){
                Blockage.p2.stopLightAttack();
            } else if (mapSelection.equals("Pillars")){
                Pillars.p2.stopLightAttack();
            } else if (mapSelection.equals("CenterCore")){
                CenterCore.p2.stopLightAttack();
            }
        }

        if(e.getKeyCode() == KeyEvent.VK_O){
            if (mapSelection.equals("TestingMap")){
                TestingMap.p2.stopHeavyAttack();
            } else if (mapSelection.equals("Blockage")){
                Blockage.p2.stopHeavyAttack();
            } else if (mapSelection.equals("Pillars")){
                Pillars.p2.stopHeavyAttack();
            } else if (mapSelection.equals("CenterCore")){
                CenterCore.p2.stopHeavyAttack();
            }
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
