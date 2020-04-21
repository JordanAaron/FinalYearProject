package MapComponents;

import sun.awt.windows.WPrinterJob;

import java.awt.*;

public class Platform extends Component {

    public Platform(int x, int y, int width, int height, Color color){
        super(x,y,width,height,color);
    }

    @Override
    public void draw(Graphics g) {
        int xPos = (int)(((double) this.xPosMapComp /100) * this.screenWidth);
        int yPos = (int)(((double) this.yPosMapComp /100) * this.screenHeight);
        int width = (int)(((double) this.w/100) * this.screenWidth);
        int height = (int)(((double) this.h/100) * this.screenHeight);

        g.setColor(c);
        g.fillRect(xPos, yPos,width, height);

    }

    @Override
    public void updateWidth(int w) {
        this.screenWidth = w;
    }

    @Override
    public void updateHeight(int h) {
        this.screenHeight = h;
    }

    @Override
    public boolean MapColliding(int leftX, int rightX, int topY, int bottomY) {
        if (rightX > this.xPosMapComp && leftX < (this.xPosMapComp + this.w)){
            if (bottomY > this.yPosMapComp && topY < (this.yPosMapComp + this.h)){
                return true;
            }
        }
        return false;
    }

    public boolean componentCollide(int playerTop, int playerBottom){
        int componentLeft = this.xPosMapComp, componentRight = this.xPosMapComp + this.w;
//        if (abovePlatform()){
//
//        }
        return false;
    }

    private boolean abovePlatform(int xPlayer, int yPlayer){
        if (xPlayer >= this.xPosMapComp && xPlayer <= (this.xPosMapComp + this.w)){
            if (yPlayer >= this.yPosMapComp){
                return true;
            }
        }
        return false;
    }

    //check if we're going into each side of the platform

    public boolean collideWithLeft(int xPlayer, int yPlayer){
        int leftOfPlatform = this.xPosMapComp;
        int platformHeight = this.yPosMapComp;

        if (xPlayer > leftOfPlatform && yPlayer >= platformHeight){
            return true;
        }
//        else if (xPlayer > leftOfPlatform && yPlayer < platformHeight){
//            return false;
//        }
        return false;
    }

    public boolean collideWithTop(int xPlayer, int yPlayer){
        int platformHeight = this.yPosMapComp;
        if (xPlayer >= this.xPosMapComp && xPlayer <= (this.xPosMapComp + this.w)){
            if (yPlayer < platformHeight){
                return true;
            }
        }
        return false;
    }

}
