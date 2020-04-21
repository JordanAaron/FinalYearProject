package MapComponents;

import java.awt.*;

public class AngledPlatform extends Component {
    public AngledPlatform(int x, int y, int width, int height, int angle, Color color) {
        super(x, y, width, height, angle, color);
    }

    @Override
    public void draw(Graphics g) {
        int xPos = (int)(((double) this.xPosMapComp /100) * this.screenWidth);
        int yPos = (int)(((double) this.yPosMapComp /100) * this.screenHeight);
        int width = (int)(((double) this.w/100) * this.screenWidth);
        int height = (int)(((double) this.h/100) * this.screenHeight);

//        g.setColor(c);
//        g.drawLine(xPos,yPos,xPos2,yPos2);

        Graphics2D g2d = (Graphics2D)g;
        g2d.setColor(c);
        Rectangle platform = new Rectangle(xPos, yPos, width, height);
        g2d.rotate(Math.toRadians(angle),xPos + (width / 2),yPos + (height / 2));
        g2d.fill(platform);
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
