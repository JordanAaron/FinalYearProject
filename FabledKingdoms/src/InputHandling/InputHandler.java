package InputHandling;

import Maps.TestingMap;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputHandler implements KeyListener {

    public static int playerID;

    public static void getPlayerID(int id){
        playerID = id;
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }


    //check if this is player one or player 2 before assigning

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_UP){
            //System.out.println("id: " + playerID);
            if (playerID == 1){
                TestingMap.p1.up();
            } else if (playerID == 2) {
                TestingMap.p2.up();
            }
            //System.out.println("up arrow pressed");
            //OnlineConnectivity.Client.OnlineConnectivity.Client.playerMoved(true);
        }

        if(e.getKeyCode() == KeyEvent.VK_DOWN){}

        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            if (playerID == 1) {
                TestingMap.p1.left();
                TestingMap.p1.startMoving();
            } else if (playerID == 2){
                TestingMap.p2.left();
                TestingMap.p2.startMoving();
            }
           // OnlineConnectivity.Client.OnlineConnectivity.Client.playerMoved(true);
        }

        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            if (playerID == 1) {
                TestingMap.p1.right();
                TestingMap.p1.startMoving();
            } else if (playerID == 2){
                TestingMap.p2.right();
                TestingMap.p2.startMoving();
            }
            //OnlineConnectivity.Client.OnlineConnectivity.Client.playerMoved(true);
        }

        if(e.getKeyCode() == KeyEvent.VK_X){
            System.out.println("Light Attack!");
            if (playerID == 1) {
                TestingMap.p1.lightAttack();
            } else if (playerID == 2){
                TestingMap.p2.lightAttack();
            }
        }

        if(e.getKeyCode() == KeyEvent.VK_Z){
            System.out.println("Heavy Attack");
            if (playerID == 1) {
                TestingMap.p1.heavyAttack();
            } else if (playerID == 2){
                TestingMap.p2.heavyAttack();
            }
        }

        if(e.getKeyCode() == KeyEvent.VK_SPACE){
            System.out.println("Space bar pressed");
        }

        //Open in game menu
//        if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
//            System.out.println("Escape Pressed");
//            MainMenu.frame.setContentPane(new InGameMenu());
//        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_RIGHT){
            if (playerID == 1) {
                TestingMap.p1.stopMoving();
            } else if (playerID == 2){
                TestingMap.p2.stopMoving();
            }
            //OnlineConnectivity.Client.OnlineConnectivity.Client.playerMoved(false);
        }
        if(e.getKeyCode() == KeyEvent.VK_X){
            if (playerID == 1) {
                TestingMap.p1.stopLightAttack();
            } else if (playerID == 2){
                TestingMap.p2.stopLightAttack();
            }
        }
        if(e.getKeyCode() == KeyEvent.VK_Z){
            if (playerID == 1) {
                TestingMap.p1.stopHeavyAttack();
            } else if (playerID == 2){
                TestingMap.p2.stopHeavyAttack();
            }
        }

    }
}
