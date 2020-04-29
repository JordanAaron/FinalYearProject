package MapComponents;



import GUI.InGameMenuComponents.MenuButtons;
import InputHandling.MultiPlayerInputHandling;
import Maps.*;


import java.awt.*;

public class InGameMenu {
    MultiPlayerInputHandling multiInput;
    public int xPos, yPos, width, height;

    public MenuButtons resumeButton = new MenuButtons("Resume",25,20,50,15,this);

    public MenuButtons exitGame = new MenuButtons("Exit Game", 25,55,50,15,this);

    int x, y, w, h;
    int screenWidth,screenHeight;

    public InGameMenu(int x, int y, int width, int height){
        this.x = x;
        this.y = y;
        this.w = width;
        this.h = height;
        this.multiInput = MapFrame.multiInput;

    }

    public void draw(Graphics g, Color color){
        xPos = (int)(((double) this.x /100) * this.screenWidth);
        yPos = (int)(((double) this.y /100) * this.screenHeight);
        width = (int)(((double) this.w /100) * this.screenWidth);
        height = (int)(((double) this.h /100) * this.screenHeight);

        g.setColor(color);
        g.drawRect(xPos, yPos,width, height);

        if (TestingMap.menuPaused || Pillars.menuPaused || Blockage.menuPaused || CenterCore.menuPaused){
            if (mouseOnButton(resumeButton.x,resumeButton.y,resumeButton.w,resumeButton.h)){
                resumeButton.draw(g,Color.green);
            } else {
                resumeButton.draw(g, Color.pink);
            }

            if (mouseOnButton(exitGame.x,exitGame.y,exitGame.w,exitGame.h)){
                exitGame.draw(g,Color.green);
            } else {
                exitGame.draw(g,Color.pink);
            }
        }
    }

    public void updateWidth(int w) {
        this.screenWidth = w;
    }

    public void updateHeight(int h) {
        this.screenHeight = h;
    }


    public boolean mouseOnButton(int btnX, int btnY, int btnW, int btnH){
        int mouseX = multiInput.updatedX(MouseInfo.getPointerInfo().getLocation().x);
        int mouseY = multiInput.updatedY(MouseInfo.getPointerInfo().getLocation().y) - 5;

        if (mouseX >= this.x && mouseX <= (this.x + this.w)){
            if (mouseY >= this.y && mouseY <= ((this.y + this.h))){

                int mouseMenuX = (int) ((mouseX - 40) * 5.0);
                int mouseMenuY = (int) ((mouseY - 20) * 2.5);

                if (mouseMenuX > btnX && mouseMenuX < (btnX + btnW)){
                    if (mouseMenuY > btnY && mouseMenuY < (btnY + btnH)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
