package MapComponents;

import java.awt.*;

public class AngledPlatform extends Component {
    public AngledPlatform(int x, int y, int x2, int y2, Color color) {
        super(x, y, x2, y2, color);
    }

    @Override
    public void draw(Graphics g) {
        int xPos = (int)(((double) this.xPosMapComp /100) * this.screenWidth);
        int yPos = (int)(((double) this.yPosMapComp /100) * this.screenHeight);
        int xPos2 = (int)(((double) this.w/100) * this.screenWidth);
        int yPos2 = (int)(((double) this.h/100) * this.screenHeight);

        g.setColor(c);
        g.drawLine(xPos,yPos,xPos2,yPos2);
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
    public boolean MapColliding(int x, int y) {
        return false;
    }
}
