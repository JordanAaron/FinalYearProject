package MapComponents;



import Maps.Pillars;

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
    public boolean MapCollisionDetection(int leftX, int rightX, int topY, int bottomY) {
        if (rightX > this.xPosMapComp && leftX < (this.xPosMapComp + this.w)){
            if (bottomY > this.yPosMapComp && topY < (this.yPosMapComp + this.h)){

                return true;
            }
        }
        return false;
    }

    public int getLeftX(){
        return this.xPosMapComp;
    }
    public int getRightX(){
        return this.xPosMapComp + w;
    }
    public int getTopY(){
        return this.yPosMapComp;
    }
    public int getBottomY(){
        return this.yPosMapComp + h;
    }

}
