package InputHandling;

import Maps.TestingMap;
import PlayerCharacters.GenericPlayer;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputHandler implements KeyListener {
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_UP){
            TestingMap.p1.upArrow();
        }
        if(e.getKeyCode() == KeyEvent.VK_DOWN){
        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            TestingMap.p1.leftArrow();
            TestingMap.p1.startMoving();
        }
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            TestingMap.p1.rightArrow();
            TestingMap.p1.startMoving();
        }
        if(e.getKeyCode() == KeyEvent.VK_Z){
            System.out.println("Z pressed");
        }
        if(e.getKeyCode() == KeyEvent.VK_X){
            System.out.println("X pressed");
        }
        if(e.getKeyCode() == KeyEvent.VK_SPACE){
            System.out.println("Space bar pressed");
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_RIGHT){
            TestingMap.p1.stopMoving();
        }
    }
}
