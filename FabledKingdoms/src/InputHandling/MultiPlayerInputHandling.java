package InputHandling;

import Maps.Blockage;
import Maps.TestingMap;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MultiPlayerInputHandling implements KeyListener {

    public static String mapSelection;

    public static void getMap(String map){
        mapSelection = map;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_UP){
            if (mapSelection.equals("TestingMap")){
                TestingMap.p1.up();
            } else if (mapSelection.equals("Blockage")){
                Blockage.p1.up();
            }
        }

        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            if (mapSelection.equals("TestingMap")){
                TestingMap.p1.left();
                TestingMap.p1.startMoving();
            } else if (mapSelection.equals("Blockage")){
                Blockage.p1.left();
                Blockage.p1.startMoving();
            }

        }
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            if (mapSelection.equals("TestingMap")){
                TestingMap.p1.right();
                TestingMap.p1.startMoving();
            } else if (mapSelection.equals("Blockage")){
                Blockage.p1.right();
                Blockage.p1.startMoving();
            }

        }
        if(e.getKeyCode() == KeyEvent.VK_P){
            if (mapSelection.equals("TestingMap")){
                TestingMap.p1.lightAttack();
            } else if (mapSelection.equals("Blockage")){
                Blockage.p1.lightAttack();
            }
            System.out.println("Light Attack!");
        }
        if(e.getKeyCode() == KeyEvent.VK_O){
            if (mapSelection.equals("TestingMap")){
                TestingMap.p1.heavyAttack();
            } else if (mapSelection.equals("Blockage")){
                Blockage.p1.heavyAttack();
            }
            System.out.println("Heavy Attack");
        }

        if(e.getKeyCode() == KeyEvent.VK_W){
            if (mapSelection.equals("TestingMap")){
                TestingMap.p2.up();
            } else if (mapSelection.equals("Blockage")){
                Blockage.p2.up();
            }
        }

        if(e.getKeyCode() == KeyEvent.VK_A){
            if (mapSelection.equals("TestingMap")){
                TestingMap.p2.left();
                TestingMap.p2.startMoving();
            } else if (mapSelection.equals("Blockage")){
                Blockage.p2.left();
                Blockage.p2.startMoving();
            }
        }

        if(e.getKeyCode() == KeyEvent.VK_D){
            if (mapSelection.equals("TestingMap")){
                TestingMap.p2.right();
                TestingMap.p2.startMoving();
            } else if (mapSelection.equals("Blockage")){
                Blockage.p2.right();
                Blockage.p2.startMoving();
            }
        }
        if(e.getKeyCode() == KeyEvent.VK_G){
            if (mapSelection.equals("TestingMap")){
                TestingMap.p2.lightAttack();
            } else if (mapSelection.equals("Blockage")){
                Blockage.p2.lightAttack();
            }
            System.out.println("Light Attack!");

        }
        if(e.getKeyCode() == KeyEvent.VK_H){
            if (mapSelection.equals("TestingMap")){
                TestingMap.p2.heavyAttack();
            } else if (mapSelection.equals("Blockage")){
                Blockage.p2.heavyAttack();
            }
            System.out.println("Heavy Attack");

        }
//        if(e.getKeyCode() == KeyEvent.VK_SPACE){
//            System.out.println("Space bar pressed");
//        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_RIGHT){
            if (mapSelection.equals("TestingMap")){
                TestingMap.p1.stopMoving();
            } else if (mapSelection.equals("Blockage")){
                Blockage.p1.stopMoving();
            }
        }

        if(e.getKeyCode() == KeyEvent.VK_G){
            if (mapSelection.equals("TestingMap")){
                TestingMap.p1.stopLightAttack();
            } else if (mapSelection.equals("Blockage")){
                Blockage.p1.stopLightAttack();
            }
        }

        if(e.getKeyCode() == KeyEvent.VK_H){
            if (mapSelection.equals("TestingMap")){
                TestingMap.p1.stopHeavyAttack();
            } else if (mapSelection.equals("Blockage")){
                Blockage.p1.stopHeavyAttack();
            }
        }

        if(e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_D){
            if (mapSelection.equals("TestingMap")){
                TestingMap.p2.stopMoving();
            } else if (mapSelection.equals("Blockage")){
                Blockage.p2.stopMoving();
            }

        }

        if(e.getKeyCode() == KeyEvent.VK_P){
            if (mapSelection.equals("TestingMap")){
                TestingMap.p2.stopLightAttack();
            } else if (mapSelection.equals("Blockage")){
                Blockage.p2.stopLightAttack();
            }
        }

        if(e.getKeyCode() == KeyEvent.VK_O){
            if (mapSelection.equals("TestingMap")){
                TestingMap.p2.stopHeavyAttack();
            } else if (mapSelection.equals("Blockage")){
                Blockage.p2.stopHeavyAttack();
            }

        }
    }
}
