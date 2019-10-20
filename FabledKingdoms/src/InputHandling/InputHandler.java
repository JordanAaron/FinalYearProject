package InputHandling;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputHandler implements KeyListener {
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_UP){
            System.out.println("Up arrow pressed");
        }
        if(e.getKeyCode() == KeyEvent.VK_DOWN){
            System.out.println("Down arrow pressed");
        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            System.out.println("Left arrow pressed");
        }
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            System.out.println("Right arrow pressed");
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
