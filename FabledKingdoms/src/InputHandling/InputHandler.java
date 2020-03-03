package InputHandling;

import GUI.InGameMenu;
import GUI.MainMenu;
import Maps.TestingMap;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputHandler implements KeyListener {
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_UP){
            TestingMap.p1.up();
            System.out.println("up arrow pressed");
        }
        if(e.getKeyCode() == KeyEvent.VK_DOWN){
        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            TestingMap.p1.left();
            TestingMap.p1.startMoving();
        }
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            TestingMap.p1.right();
            TestingMap.p1.startMoving();
        }
        if(e.getKeyCode() == KeyEvent.VK_X){
            System.out.println("Light Attack!");
            TestingMap.p1.lightAttack();
        }
        if(e.getKeyCode() == KeyEvent.VK_Z){
            System.out.println("Heavy Attack");
            TestingMap.p1.heavyAttack();
        }
        if(e.getKeyCode() == KeyEvent.VK_SPACE){
            System.out.println("Space bar pressed");
        }
        if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
            System.out.println("Escape Pressed");
            MainMenu.frame.setContentPane(new InGameMenu());
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_RIGHT){
            TestingMap.p1.stopMoving();
        }
        if(e.getKeyCode() == KeyEvent.VK_X){
            TestingMap.p1.stopLightAttack();
        }
        if(e.getKeyCode() == KeyEvent.VK_Z){
            TestingMap.p1.stopHeavyAttack();
        }

    }
}
