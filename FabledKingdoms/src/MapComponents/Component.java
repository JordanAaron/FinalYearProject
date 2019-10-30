package MapComponents;

import org.omg.CORBA.PUBLIC_MEMBER;

import java.awt.*;

public abstract class Component {
    public int xPosMapComp, yPosMapComp, w, h, screenWidth, screenHeight;
    public Boolean solid;
    Color c;

    public Component(int x, int y, int width, int height, Color color, Boolean solid){
        this.xPosMapComp = x;
        this.yPosMapComp = y;
        this.w = width;
        this.h = height;
        this.c = color;
        this.solid = solid;
    }

    public abstract void draw(Graphics g);


    public abstract void updateWidth(int w);

    public abstract void updateHeight(int h);

    public abstract boolean colliding(int x, int y);

}
