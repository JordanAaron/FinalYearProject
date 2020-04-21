package MapComponents;

import java.awt.*;

public class Stairs extends Component {
    public Stairs(int x, int y, int x2, int y2, int x3, int y3, Color color) {
        super(x,y,x2,y2,x3,y3,color);
    }

    @Override
    public void draw(Graphics g) {
        int xPos = (int)(((double) this.xPosMapComp /100) * this.screenWidth);
        int yPos = (int)(((double) this.yPosMapComp /100) * this.screenHeight);
        int xPos2 = (int)(((double) this.x2PosMapComp /100) * this.screenWidth);
        int yPos2 =(int)(((double) this.y2PosMapComp /100) * this.screenWidth);
        int xPos3 = (int)(((double) this.x3PosMapComp /100) * this.screenWidth);
        int yPos3 =(int)(((double) this.y3PosMapComp /100) * this.screenWidth);


        int[] xPoints = {xPos,xPos2,xPos3};
        int[] yPoints = {yPos,yPos2,yPos3};
        int nPoints = 3;
        g.fillPolygon(xPoints,yPoints,nPoints);
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
        return false;
    }

}
