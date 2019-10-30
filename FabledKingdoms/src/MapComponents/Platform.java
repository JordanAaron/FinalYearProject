package MapComponents;

import java.awt.*;

public class Platform extends Component {
    public Platform(int x, int y, int width, int height, Color color, Boolean solid){
        super(x,y,width,height,color,solid);

    }

    @Override
    public void draw(Graphics g) {
        g.setColor(c);

        int xPos = (int)(((double) this.xPosMapComp /100) * this.screenWidth);
        int yPos = (int)(((double) this.yPosMapComp /100) * this.screenHeight);
        int width = (int)(((double) this.w/100) * this.screenWidth);
        int height = (int)(((double) this.h/100) * this.screenHeight);


        //System.out.println("screen width: " + this.screenWidth + "screen height: " + this.screenHeight);
        //System.out.println(xPos + ", " + yPos);

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
    public boolean colliding(int x, int y) {
        int xPos = (int)(((double) this.xPosMapComp /100) * this.screenWidth);
        int yPos = (int)(((double) this.yPosMapComp /100) * this.screenHeight);
        int width = (int)(((double) this.w/100) * this.screenWidth);
        return x>xPos && x<(xPos+width)  && y == yPos;
    }


}
