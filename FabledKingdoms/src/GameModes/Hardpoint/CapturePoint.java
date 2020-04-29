package GameModes.Hardpoint;

import java.awt.*;

public class CapturePoint {

    private int x, y, width, height;

    private int screenWidth, screenHeight;

    private boolean active;

    public CapturePoint(int x, int y){
        this.x = x;
        this.y = y;

        width = 4;
        height = 1;

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
        if (on){
            this.active = true;
        } else {
            this.active = false;
        }
    }

//    private long lastTrueTime;
//    private boolean timedBoolean(){
//        long now = System.currentTimeMillis();
//        if (setActive()){
//            lastTrueTime = now;
//            active = true;
//        }
//
//        if (lastTrueTime + 5000 < now){
//            active = false;
//        }
//        return true;
//    }

}

