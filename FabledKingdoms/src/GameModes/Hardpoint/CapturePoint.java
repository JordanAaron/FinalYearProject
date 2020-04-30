package GameModes.Hardpoint;

import java.awt.*;

public class CapturePoint {

    private int x, y, width, height;

    private int screenWidth, screenHeight;

    public boolean active;

    public CapturePoint(int x, int y, int width){
        this.x = x;
        this.y = y;
        this.width = width;
        height = 2;

        active = false;
    }


    public void draw(Graphics g, Color c) {
        int xPos = (int)(((double) this.x /100) * this.screenWidth);
        int yPos = (int)(((double) this.y /100) * this.screenHeight);
        int width = (int)(((double) this.width/100) * this.screenWidth);
        int height = (int)(((double) this.height/100) * this.screenHeight);

        g.setColor(c);
        g.fillRect(xPos, yPos,width, height);
    }

    public void updateWidth(int w) {
        this.screenWidth = w;
    }

    public void updateHeight(int h) {
        this.screenHeight = h;
    }

    public void setActive(boolean on){
        this.active = on;
    }

    public boolean playerOnPoint(int leftX, int rightX, int bottomY){
        if (leftX > this.x && rightX <= (this.x + this.width)){
            if (bottomY >= this.y){
                return true;
            }
        }
        return false;
    }

}

