package GUI.InGameMenuComponents;

import InputHandling.MultiPlayerInputHandling;
import MapComponents.InGameMenu;
import Maps.MapFrame;

import java.awt.*;

public class MenuButtons {
    InGameMenu inGameMenu;
    MultiPlayerInputHandling multiInput;

    String buttonText;
    public int x,y,w,h;

    public int xPos,yPos,width,height;

    public static Rectangle rectangle;

    public MenuButtons(String buttonText, int x, int y, int width, int height,InGameMenu inGameMenu){
        this.buttonText = buttonText;
        this.x = x;
        this.y = y;
        this.w = width;
        this.h = height;
        this.inGameMenu = inGameMenu;
        this.multiInput = MapFrame.multiInput;

    }

    public void draw(Graphics g, Color c) {
        xPos = (int)((((double) this.x /100) * inGameMenu.width) +inGameMenu.xPos);
        yPos = (int)((((double) this.y /100) * inGameMenu.height) + inGameMenu.yPos);
        width = (int)(((double) this.w/100) * inGameMenu.width);
        height = (int)(((double) this.h/100) * inGameMenu.height);

        g.setColor(c);
        g.drawRect(xPos,yPos,width,height);

        g.drawString(buttonText, (int) ((xPos+width) * 0.86), (int) ((yPos+height)*0.94));
    }



    public boolean mouseOnButton(int btnX, int btnY, int btnW, int btnH){
//        if (multiInput.updatedX(MouseInfo.getPointerInfo().getLocation().x) > updatedResumeBtnX && multiInput.updatedX(MouseInfo.getPointerInfo().getLocation().x) < updatedResumeBtnX + updatedResumeBtnWidth){
//            if (multiInput.updatedY(MouseInfo.getPointerInfo().getLocation().y) > updatedResumeBtnY && multiInput.updatedY(MouseInfo.getPointerInfo().getLocation().y) < updatedResumeBtnY + updatedResumeBtnHeight){
//                return true;
//            }
//        }

        if (multiInput.updatedX(MouseInfo.getPointerInfo().getLocation().x) > btnX && multiInput.updatedX(MouseInfo.getPointerInfo().getLocation().x) < btnX + btnW){
            if (multiInput.updatedY(MouseInfo.getPointerInfo().getLocation().y) > btnY && multiInput.updatedY(MouseInfo.getPointerInfo().getLocation().y) < btnY + btnH){
                return true;
            }
        }
        return false;
    }

}
