package MapComponents;

import java.awt.*;

public abstract class Component {
    public int xPosMapComp, yPosMapComp, w, h, screenWidth, screenHeight;
    Color c;

    public Component(int x, int y, int width, int height, Color color){
        this.xPosMapComp = x;
        this.yPosMapComp = y;
        this.w = width;
        this.h = height;
        this.c = color;
    }

    public abstract void draw(Graphics g);

    public abstract void updateWidth(int w);

    public abstract void updateHeight(int h);

    public abstract boolean MapColliding(int x, int y);

}
